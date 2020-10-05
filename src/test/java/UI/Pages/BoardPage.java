package com.usta.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardPage {
	private WebDriver driver;
	
	
	@FindBy(name= "name")
	private WebElement nameInput; 
	  public BoardPage(WebDriver driver){
			this.driver=driver;
			
		}
	  
	  public void createList(String name) {
		  nameInput.sendKeys(name);
		  nameInput.sendKeys(Keys.ENTER);
	  }
	  public void createCard(String name) {
		  driver.findElement(By.className("card-composer-container js-card-composer-container")).click();
		  
	  }
	  public String isTheListCreated(String nameList) {
		  wait(2000);
		  return driver.findElement(By.xpath( "//textarea[contains(text(),'"+nameList+"')]")).getText();
	
		
	  }
	  public void wait(int seconds) {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.MILLISECONDS);
		}
}

