package com.usta.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage {
	private WebDriver driver;
	@FindBy(id = "user")
	private WebElement user;
	@FindBy(id = "password")
	private WebElement password;

    public AuthenticationPage(WebDriver driver){
	this.driver=driver;
}
   public void logIn(String user,String password) {
	   this.user.sendKeys(user);
	   this.password.sendKeys(password);
	   this.password.sendKeys(Keys.ENTER);
	   
   }
     

}
