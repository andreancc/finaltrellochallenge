package UI.Test;

import java.util.concurrent.TimeUnit;
import UI.Pages.*;
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
		LoginPage.logIn("laura.castillo@usantoto.edu.co", "Bladimir55");

	}

	@Test
	public void authentication() {
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		Assert.assertEquals("Boards", home.isLoginSuccesfull());
	}
	@Test
	public void testSearch() {
//		driver.findElement(By.linkText("Log In")).click();
//		AuthenticationPage page = PageFactory.initElements(driver, AuthenticationPage.class);
//		page.logIn("laura.castillo@usantoto.edu.co", "Bladimir55");
		wait(10000);
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
		wait(10000);
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

	}


	public void signUp()  {
		LauchPage lauchPage=PageFactory.initElements(driver,LauchPage.class);
		lauchPage.clickSignUp();
		SignUpPage page = PageFactory.initElements(driver, SignUpPage.class);
		page.enterMail("andreanccwe@hotmail.com");
		Assert.assertTrue(page.createUserWithoutPassword("Andrea"));
}

	@After
	public void tearDown() {
		driver.quit();
	}

	public void wait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.MILLISECONDS);
	}
}
