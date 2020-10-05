package com.usta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	@FindBy(xpath  = "//span[contains(text(),'Create new board')]")
	private WebElement newBoard;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void createBoard(String tittle) {
		newBoard.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("subtle-input")));
		WebElement inputTittle = driver.findElement(By.className("subtle-input"));
		inputTittle.sendKeys(tittle);
		inputTittle.sendKeys(Keys.ENTER);

	}
}
