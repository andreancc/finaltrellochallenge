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
    public Response getCards(String idcard) {
        Response getresponse =
                given().log().uri().spec(requestSpec)
                        .pathParam("id",idcard)
                        .when()
                        .get(URLs.getCardsperid)
                        .andReturn();
        System.out.println(getresponse);
        return getresponse;
    }

    public Response createCards(String id,String namecard) {
        Response getresponse =
                given().log().uri().spec(requestSpec)
                        .queryParam("idList",id)
                        .queryParam("name",namecard)
                        .when()
                        .post(URLs.createCards)
                        .andReturn();
        System.out.println(getresponse);
        return getresponse;
    }
}
