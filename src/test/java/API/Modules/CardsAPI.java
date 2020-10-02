package API.Modules;

import API.EnvProperties;
import Helpers.URLs;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CardsAPI {

    private static RequestSpecification requestSpec;
    public CardsAPI() {

        requestSpec = new RequestSpecBuilder()
                .addQueryParam("key", EnvProperties.key)
                .addQueryParam("token",EnvProperties.token)
                .setBaseUri(URLs.theUrl).setContentType(ContentType.JSON).build();
    }
    public Response getCards(String id) {
        Response getresponse =
                given().log().uri().spec(requestSpec)
                        .pathParam("id",id)
                        .when()
                        .get(URLs.getCards)
                        .andReturn();
        System.out.println(getresponse);
        return getresponse;
    }


}
