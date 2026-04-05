package org.example.digital_nomads.demoQa.gorestAPI.models;



public abstract class BaseModel {

    public String toJson(){
        return JsonUtils.toJson(this);
    }
}
