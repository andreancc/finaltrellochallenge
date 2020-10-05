package com.usta.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.usta.pages.AuthenticationPage;
import com.usta.pages.BoardPage;
import com.usta.pages.HomePage;
import com.usta.pages.SignUpPage;
import com.usta.utils.BrowserFactory;

public class UITest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = BrowserFactory.getBrowser("Chrome");
		driver.get("https://trello.com/");

	}


	public void authentication() {

		driver.findElement(By.linkText("Log In")).click();
		wait(5000);
		AuthenticationPage page = PageFactory.initElements(driver, AuthenticationPage.class);
		page.logIn("laura.castillo@usantoto.edu.co", "Bladimir55");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='content']//span[contains(text(),'Boards')]")));
		String actual = driver.findElement(By.xpath("//*[@id='content']//span[contains(text(),'Boards')]")).getText();
		Assert.assertEquals("Boards", actual);
	}

	public void createBoard() {

		driver.findElement(By.linkText("Log In")).click();
		wait(5000);
		AuthenticationPage page = PageFactory.initElements(driver, AuthenticationPage.class);
		page.logIn("laura.castillo@usantoto.edu.co", "Bladimir55");
		wait(5000);
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		home.createBoard("example");
	}
	
	public void createList() {

		driver.findElement(By.linkText("Log In")).click();
		wait(5000);
		AuthenticationPage page = PageFactory.initElements(driver, AuthenticationPage.class);
		page.logIn("laura.castillo@usantoto.edu.co", "Bladimir55");
		wait(5000);
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		home.createBoard("exampleBoard");
		wait(10000);
		BoardPage board=PageFactory.initElements(driver, BoardPage.class);
		board.createList("To do");
		Assert.assertEquals("To do", board.isTheListCreated("To do"));
	}
	
	@Test
	public void createCard() {

		driver.findElement(By.linkText("Log In")).click();
		wait(5000);
		AuthenticationPage page = PageFactory.initElements(driver, AuthenticationPage.class);
		page.logIn("laura.castillo@usantoto.edu.co", "Bladimir55");
		wait(5000);
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		home.createBoard("exampleBoard");
		wait(10000);
		BoardPage board=PageFactory.initElements(driver, BoardPage.class);
		board.createList("To do");
		Assert.assertEquals("To do", board.isTheListCreated("To do"));
	}

	
	public void signUp() throws InterruptedException {

		driver.findElement(By.linkText("Sign Up")).click();
		wait(10000);
		SignUpPage page = PageFactory.initElements(driver, SignUpPage.class);
		page.enterMail("pedro444@gmail.com");
		page.createUser("pedro", "password");
		Thread.sleep(3000);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	public void wait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.MILLISECONDS);
	}
}
