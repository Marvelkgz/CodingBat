package dbTest;

import org.example.digital_nomads.demoQa.db.beans.Actor;
import org.example.digital_nomads.demoQa.db.db_utils.DB_Connection;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ActorTest {
    @Tag("RegressionDB")
    @Test
    void actorTest() throws SQLException {
        DB_Connection.openConnection("dvdrental");
        Actor.getAllActor().forEach(System.out :: println);
        Actor actor = Actor.getBy("actor_id", 1);
        System.out.println(actor);
    }
    @Tag("RegressionDB")
    @Test
    void createActor() throws SQLException {
        DB_Connection.openConnection("dvdrental");

        Map<String, Object> fields = new LinkedHashMap<>();
        fields.put("first_name", "Jet");
        fields.put("last_name", "Li");

        DB_Connection.create("actor", fields);
    }
    @Tag("RegressionDB")
    @Test
    void readAllActors() throws SQLException {
        DB_Connection.openConnection("dvdrental");

        ResultSet rs = DB_Connection.readAll("actor");
        while (rs.next()) {
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
        }
    }
    @Tag("RegressionDB")
    @Test
    void readActorById() throws SQLException {
        DB_Connection.openConnection("dvdrental");

        ResultSet rs = DB_Connection.readBy("actor", "actor_id", 1);
        if (rs.next()) {
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
        }
    }
    @Tag("RegressionDB")
    @Test
    void updateActor() throws SQLException {
        DB_Connection.openConnection("dvdrental");

        Map<String, Object> fields = new LinkedHashMap<>();
        fields.put("first_name", "Bruce");
        fields.put("last_name", "Lee");

        DB_Connection.update("actor", "actor_id", 1, fields);
    }
    @Tag("RegressionDB")
    @Test
    void deleteActor() throws SQLException {
        DB_Connection.openConnection("dvdrental");
        DB_Connection.delete("film_actor", "actor_id", 1);// Сначала удаляем связанные записи в film_actor
        DB_Connection.delete("actor", "actor_id", 1);// Теперь можно удалить актёра
    }
}
