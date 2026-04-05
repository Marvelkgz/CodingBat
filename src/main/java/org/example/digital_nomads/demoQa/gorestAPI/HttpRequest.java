package org.example.digital_nomads.demoQa.gorestAPI;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.digital_nomads.demoQa.gorestAPI.config.ConfigurationManager;

import static io.restassured.RestAssured.given;

@Slf4j
@Data

public class HttpRequest {

    protected String url;
    protected RequestSpecification requestSpecification; // блок request --> post/get/body/header
    protected Response response; // блок response
    private static final String SLASH = "/";

    public HttpRequest(String url) {
        this.url = url;
        this.requestSpecification = given().baseUri(url).header("Authorization","Bearer " +
                ConfigurationManager.getBaseConfig().bearerToken()).contentType(ContentType.JSON).accept(ContentType.JSON);
    }

    public Response get(String endPoint){
        log.info("Performed GET {}",endPoint);
        this.response = given().spec(requestSpecification).get(endPoint);
        logResponse();
        return  this.response;
    }

    public Response post(String endPoint,String body){
        log.info("Performed POST {}",endPoint);
        log.info("Body is {}",body);
        this.response = given().spec(requestSpecification).body(body).post(endPoint);
        logResponse();
        return this.response;
    }

    private void logResponse(){
        log.warn("Response is: ");
        log.warn(getResponse().getBody().asPrettyString());
        log.warn("Status code is: {}",getResponse().getStatusCode());
    }

    public String getEndpoint(String... endPoints){// "..." optional
        StringBuilder endPoint = new StringBuilder();
        for (String arg : endPoints){
            endPoint.append(arg).append(SLASH);
        }
        return endPoint.substring(0,endPoint.length()-1); // public,v2,users --> 1) public/ 2) public/v2/ 3) public/v2/users
    }

    public Response delete(String endPoint) {
        log.info("Performed DELETE {}", endPoint);
        this.response = given().spec(requestSpecification).delete(endPoint);
        logResponse();
        return this.response;
    }
}
