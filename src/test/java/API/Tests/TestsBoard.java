package API.Tests;

import API.Modules.BoardAPI;
import API.POJOS.BoardPojo;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestsBoard {
    private static BoardAPI board;

    @BeforeClass
    public static void before() {
        board = new BoardAPI();
    }

    @Test
    public void createNewBoard() {
        Response rsp = board.createBoard("board 2");
        BoardPojo results = rsp.as(BoardPojo.class);
        Assert.assertEquals(results.getName(), "board 2");
    }

    @Test
    public void getBoardInList() {
        board.createBoard("board 3");
        Response rsp = board.getmyBoard();
        BoardPojo[] results = rsp.as(BoardPojo[].class);
        boolean isInTheList = false;
        for (BoardPojo result : results) {
            if (result.getName().equals("board 3"))
                isInTheList = true;
        }
        Assert.assertTrue(isInTheList);
    }

    @Test
    public void checkBoardDeleted() {
        Response rsp = board.createBoard("board to delete2");
        BoardPojo results = rsp.as(BoardPojo.class);
        String boardId = results.getId();
        Response deleteresponse = board.deleteBoard(boardId).then().extract().path("value");
        Assert.assertNull(deleteresponse);

    }


}
