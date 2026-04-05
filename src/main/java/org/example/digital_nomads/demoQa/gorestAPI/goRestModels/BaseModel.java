package org.example.digital_nomads.demoQa.gorestAPI.goRestModels;


import org.example.digital_nomads.demoQa.gorestAPI.JsonUtils;

public abstract class BaseModel {

    public String toJson(){
        return JsonUtils.toJson(this);
    }

}
