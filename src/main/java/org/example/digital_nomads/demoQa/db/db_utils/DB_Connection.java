package org.example.digital_nomads.demoQa.db.db_utils;

import lombok.Getter;
import org.example.digital_nomads.demoQa.gorestAPI.config.ConfigurationManager;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.*;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class DB_Connection {

    @Getter
    private static Connection connection;
    private static Statement statement;

    private DB_Connection(){
        //singleton pattern
    }

    private static PGSimpleDataSource getBaseDataSource(String dataBase) {
        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource() {{
            setServerName(ConfigurationManager.getBaseConfig().server());
            setPortNumber(ConfigurationManager.getBaseConfig().port());
            setUser(ConfigurationManager.getBaseConfig().user());
            setPassword("rayana2913");
            setDatabaseName(dataBase);
        }};
        return pgSimpleDataSource;
    }

    public static void openConnection(String database) throws SQLException {
        if (connection == null){
            connection = getBaseDataSource(database).getConnection();
            statement = connection.createStatement();
        }
    }

    public static  void closeConnection(){
        try{
            if (statement != null){
                statement.close();
                statement = null;
            }
            if (connection != null){
                connection.close();
                connection = null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

// select * users;
// select * from users / where user.name = ? and id = ? --> String query
// 'John', '5' --> Object params ('John' --> begin from index 1,5 --> index 2)
    public static ResultSet makeQuery(String query, Object... params) throws SQLException {
        if (params.length == 0) {
            return statement.executeQuery(query);
        } else {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }                              //select * from users / where id = ? and name = ?, '5', 'Bob';
            return preparedStatement.executeQuery();
        }
    }

    public static int makeUpdate(String query, Object... params) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        return preparedStatement.executeUpdate();
    }

    public static void create(String table, Map<String, Object> fields) throws SQLException {
        String columns = String.join(", ", fields.keySet());
        String placeholders = String.join(", ", Collections.nCopies(fields.size(), "?"));
        String query = String.format("INSERT INTO %s (%s) VALUES (%s)", table, columns, placeholders);
        DB_Connection.makeUpdate(query, fields.values().toArray());
    }

    // READ ALL — SELECT * FROM table
    public static ResultSet readAll(String table) throws SQLException {
        return DB_Connection.makeQuery("SELECT * FROM " + table);
    }

    // READ BY — SELECT * FROM table WHERE column = ?
    public static ResultSet readBy(String table, String column, Object value) throws SQLException {
        return DB_Connection.makeQuery(
                String.format("SELECT * FROM %s WHERE %s = ?", table, column), value
        );
    }

    // UPDATE — UPDATE table SET col1 = ?, col2 = ? WHERE idColumn = ?
    public static void update(String table, String idColumn, Object idValue, Map<String, Object> fields) throws SQLException {
        String setClause = fields.keySet().stream()
                .map(key -> key + " = ?")
                .collect(Collectors.joining(", "));
        String query = String.format("UPDATE %s SET %s WHERE %s = ?", table, setClause, idColumn);

        Object[] params = new Object[fields.size() + 1];
        System.arraycopy(fields.values().toArray(), 0, params, 0, fields.size());
        params[fields.size()] = idValue;

        DB_Connection.makeUpdate(query, params);
    }

    // DELETE — DELETE FROM table WHERE idColumn = ?
    public static void delete(String table, String idColumn, Object idValue) throws SQLException {
        DB_Connection.makeUpdate(
                String.format("DELETE FROM %s WHERE %s = ?", table, idColumn), idValue
        );
    }
}

