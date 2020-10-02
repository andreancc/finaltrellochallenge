package API.Tests;

import API.Modules.BoardAPI;
import API.Modules.CardsAPI;
import API.POJOS.BoardPojo;
import API.POJOS.CardsPojo;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCards {
    private static BoardAPI board;
    private static CardsAPI cards;

    @BeforeClass
    public static void before() {
        board = new BoardAPI();
        cards=new CardsAPI();
    }

    @Test
    public void getCards() {
        Response rsp = cards.getCards("5f481736a832602d45ff66cb");
        CardsPojo[] results = rsp.as(CardsPojo[].class);

        for (CardsPojo result : results) {
            System.out.println(result.getName());
        }


    }
    @Test
    public void createCards() {
        Response rsp = cards.getCards("5f481736a832602d45ff66cb");
        CardsPojo[] results = rsp.as(CardsPojo[].class);

        for (CardsPojo result : results) {
            System.out.println(result.getName());
        }


    }
}
