package org.example.digital_nomads.demoQa.gorestAPI.controller;


import io.restassured.response.Response;
import org.example.digital_nomads.demoQa.gorestAPI.HttpRequest;
import org.example.digital_nomads.demoQa.gorestAPI.endPoint.EndPoint;
import org.example.digital_nomads.demoQa.gorestAPI.goRestModels.ToDo;

public class ToDoController extends HttpRequest {

    public ToDoController(String url) {
        super(url);
    }

    public ToDo[] getUserToDosById(Integer id){ //    /public/v2/users/7911361/todos
        return super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS, String.valueOf(id),
                EndPoint.TODOS)).as(ToDo[].class);
    }

    public ToDo createUserToDo(ToDo toDo, Integer id){
        Response response = super.post(
                getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS,
                        String.valueOf(id), EndPoint.TODOS),
                toDo.toJson()
        );
        if (response.getStatusCode() != 201) {
            throw new RuntimeException("Failed to create todo: " + response.asPrettyString());
        }
        return response.as(ToDo.class);
    }
}
