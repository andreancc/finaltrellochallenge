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

public class TestList {
    private static BoardAPI board;
    private static CardsAPI cards;
    private static ListAPI list;
    @BeforeClass
    public static void before() {
        board = new BoardAPI();
        cards=new CardsAPI();
        list=new ListAPI();
    }

    @Test
    public void VerifyNewListOnBoard() {
        String boardID=CreatelistTogetId();
        list.createList(boardID,"esta67");
        Response listsinBoard=board.getListinBoard(boardID);
        ListPojo[] boardresults = listsinBoard.as(ListPojo[].class);
        boolean isInTheList = false;

        for (ListPojo result : boardresults) {
            if (result.getName().equals("esta67"))
                isInTheList = true;
        }
        Assert.assertTrue(isInTheList);
        board.deleteBoard(boardID);

    }
    @Test
    public void VerifyNewCardOnList() {
//CardsPojo cardsResults=rsplist.as(CardsPojo.class);
        //String cardId=cardsResults.getName();
       // hola
    }














    public String CreatelistTogetId(){
        Response newBoard = board.createBoard("board to test list");
        BoardPojo results =newBoard.as(BoardPojo.class);
        String boardID=results.getId();
        return boardID;
    }
}
