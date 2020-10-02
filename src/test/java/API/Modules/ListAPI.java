package API.Modules;

import API.EnvProperties;
import Helpers.URLs;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ListAPI {
    private static RequestSpecification requestSpec;
    public ListAPI() {

        requestSpec = new RequestSpecBuilder()
                .addQueryParam("key", EnvProperties.key)
                .addQueryParam("token",EnvProperties.token)
                .setBaseUri(URLs.theUrl).setContentType(ContentType.JSON).build();
    }
    public Response createList(String boardId,String name) {
        Response getresponse =
                given().log().uri().spec(requestSpec)
                        .queryParam("idBoard",boardId)
                        .queryParam("name",name)
                        .when()
                        .post(URLs.createList)
                        .andReturn();
        return getresponse;
    }
    public Response getList(String boardId,String name) {
        Response getresponse =
                given().log().uri().spec(requestSpec)
                        .queryParam("idBoard",boardId)
                        .queryParam("name",name)
                        .when()
                        .post(URLs.createList)
                        .andReturn();
        return getresponse;
    }
}
