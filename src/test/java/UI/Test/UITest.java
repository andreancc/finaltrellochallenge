package UI.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import UI.Pages.*;
import UI.UIProperties;
import UI.Utils.BrowserFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class UITest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = BrowserFactory.getBrowser("Firefox");
		driver.get("https://trello.com/");
		LauchPage lauchPage=PageFactory.initElements(driver,LauchPage.class);
		lauchPage.clickLogin();
		wait(5000);
		AuthenticationPage LoginPage = PageFactory.initElements(driver, AuthenticationPage.class);
		Properties prop = new Properties();
		LoginPage.logIn(UIProperties.user,UIProperties.password);

	}


	@Test
	public void testSearch() {

		HomePage home=PageFactory.initElements(driver, HomePage.class);
		home.createBoard("exampleBoardForSearching");
		Assert.assertTrue("We can not find the board",home.search("exampleBoardForSearching"));
	}
	@Test
	public void createBoard() {

		HomePage home=PageFactory.initElements(driver, HomePage.class);
		home.createBoard("example");
	}

	@Test
	public void createList() {

		HomePage home=PageFactory.initElements(driver, HomePage.class);
		home.createBoard("exampleBoard");
		BoardPage board=PageFactory.initElements(driver, BoardPage.class);
		board.createList("To do");
		Assert.assertEquals("To do", board.isTheListCreated("To do"));
	}
	
	@Test
	public void createCard() {

		HomePage home=PageFactory.initElements(driver, HomePage.class);
		home.createBoard("exampleBoard3");
		BoardPage board=PageFactory.initElements(driver, BoardPage.class);
		board.createList("To do");
		board.createCard("new card");
		Assert.assertEquals("new card",board.isCardInList("To do","new card"));

	}
	@Test
	public void moveCardToInProgress() {

		HomePage home=PageFactory.initElements(driver, HomePage.class);
		home.createBoard("exampleBoard3");
		BoardPage board=PageFactory.initElements(driver, BoardPage.class);
		board.createList("To do");
		board.createList("In Progress");
		board.createList("Done");
		board.createCard("new card");
        board.moveCardtoInProgress();
        Assert.assertEquals("new card",board.isCardInList("In Progress","new card"));
	}
	@Test
	public void moveCardToDone() {

		HomePage home=PageFactory.initElements(driver, HomePage.class);
		home.createBoard("exampleBoard3");
		BoardPage board=PageFactory.initElements(driver, BoardPage.class);
		board.createList("To do");
		board.createList("In Progress");
		board.createList("Done");
		board.createCard("new card");
		board.moveCardtoInDone();
		Assert.assertEquals("new card",board.isCardInList("Done","new card"));
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	public void wait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.MILLISECONDS);
	}
}
