package org.example.digital_nomads.demoQa.gorestAPI.controller;


import org.example.digital_nomads.demoQa.gorestAPI.HttpRequest;
import org.example.digital_nomads.demoQa.gorestAPI.endPoint.EndPoint;
import org.example.digital_nomads.demoQa.gorestAPI.models.Todo;

public class ToDoController extends HttpRequest {

    public ToDoController(String url) {
        super(url);
    }

    public Todo[] getUserToDoById(Integer id){
        return super.get(getEndpoint(EndPoint.PUBLIC,EndPoint.V2,EndPoint.USERS,String.valueOf(id),
                EndPoint.TODOS)).as(Todo[].class);
    }

    public Todo createUserToDo(Todo toDo, Integer id){
        return super.post(getEndpoint(EndPoint.PUBLIC,EndPoint.V2,EndPoint.USERS,String.valueOf(id),
                EndPoint.TODOS),toDo.toJson()).as(Todo.class);
    }
}
