package API.Tests;

import API.Modules.BoardAPI;
import API.Modules.CardsAPI;
import API.Modules.ListAPI;
import API.POJOS.BoardPojo;
import API.POJOS.CardsPojo;
import API.POJOS.ListPojo;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCards {
    private static BoardAPI board;
    private static CardsAPI cards;
    private static ListAPI list;

    @BeforeClass
    public static void before() {
        board = new BoardAPI();
        cards = new CardsAPI();
        list = new ListAPI();
    }

    @Test
    public void getCard() {
        String cardName = "new card 5";
        String listID = CreatelistTogetId()[1];
        Response rsp = cards.createCards(listID, cardName);
        CardsPojo results = rsp.as(CardsPojo.class);
        String cardId=results.getId();
        Assert.assertEquals(cardName,cards.getCards(cardId).then().extract().path("name"));

    }

    @Test
    public void createCards() {
        String cardName = "new card 5";
        String listID = CreatelistTogetId()[1];
        Response rsp = cards.createCards(listID, cardName);
        CardsPojo results = rsp.as(CardsPojo.class);
        Assert.assertEquals(results.getName(), cardName);


    }

    public String[] CreatelistTogetId() {
        Response newBoard = board.createBoard("board new");
        BoardPojo resultsBoard = newBoard.as(BoardPojo.class);
        Response response = list.createList(resultsBoard.getId(), "list new");
        ListPojo resultlist = response.as(ListPojo.class);
        String[] ids=new String[2];
        ids[0]=resultsBoard.getId();
        ids[1]=resultlist.getId();
        return ids;
    }
}
