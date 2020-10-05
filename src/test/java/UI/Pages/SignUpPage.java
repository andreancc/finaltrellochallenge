package com.usta.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
	private WebDriver driver;
	@FindBy(id = "email")
	private WebElement mail;
	

    public SignUpPage(WebDriver driver){
	this.driver=driver;
}
   public void enterMail(String mail) {
	   this.mail.sendKeys(mail);
	   this.mail.sendKeys(Keys.ENTER);
	   wait(5000);
	   
   }
   public void createUser(String name,String pass) {
	   WebDriverWait wait = new WebDriverWait(driver,30);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("displayName")));
	   driver.findElement(By.id("displayName")).sendKeys(name);
	   WebElement password=driver.findElement(By.id("password"));
	   password.sendKeys(pass);
	   password.sendKeys(Keys.ENTER);
	   
	   
	   
   }
   public void wait(int seconds){
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.MILLISECONDS);
		} 
}
