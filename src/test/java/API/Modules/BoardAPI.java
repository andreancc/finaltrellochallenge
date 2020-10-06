package API.Modules;

import API.EnvProperties;
import Helpers.URLs;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BoardAPI {

    private static RequestSpecification requestSpec;

    public BoardAPI() {

        requestSpec = new RequestSpecBuilder()
                .addQueryParam("key", EnvProperties.key)
                .addQueryParam("token",EnvProperties.token)
                .setBaseUri(URLs.theUrl).setContentType(ContentType.JSON).build();
    }
    public Response getmyBoard() {
        Response getresponse =
                given().spec(requestSpec)
                        .when()
                        .get(URLs.myBoardsEndpoint)
                        .andReturn();
        return getresponse;
    }
    public Response createBoard(String name) {
        Response ret = given().spec(requestSpec)
                .queryParam("name",name)
                .post(URLs.createBoardsEndpoint).andReturn();
        return ret;
    }
    public Response deleteBoard(String id) {
        Response ret = given()
                .spec(requestSpec)
                .pathParam("id",id).when()
                .delete( URLs.deleteBoardsEndpoint).andReturn();
        return ret;
    }
    public Response getListinBoard(String boardId) {
        Response getresponse =
                given().spec(requestSpec)
                        .pathParam("id",boardId)
                        .when()
                        .get(URLs.getListonBoard)
                        .andReturn();
        return getresponse;
    }




}
