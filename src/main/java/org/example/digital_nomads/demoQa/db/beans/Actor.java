package org.example.digital_nomads.demoQa.db.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.example.digital_nomads.demoQa.db.db_utils.DB_Connection.makeQuery;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Actor {

    String actor_id;
    String first_name;
    String last_name;
    String last_update;

    public static List<Actor> getAllActor() throws SQLException {
        String query = "select * from actor";
        try(ResultSet resultSet = makeQuery(query)){
            return new BeanProcessor().toBeanList(resultSet,Actor.class);
        }
    }

    public static Actor getBy(String column,int value) throws SQLException {
        String query = "select * from actor where " + column + " = ?; ";
        ResultSet resultSet = makeQuery(query,value);
        if (!resultSet.next()){
            return null;
        } else {
            return  new BeanProcessor().toBean(resultSet, Actor.class);
        }
    }

}
