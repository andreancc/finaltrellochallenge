package UI.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardPage extends BasePage {
    private WebDriver driver;


    @FindBy(name = "name")
    private WebElement nameInput;
    @FindBy(css = ".js-list:nth-child(1) .open-card-composer > .icon-sm")
    private WebElement listButton;
    @FindBy(css =".list-card-composer-textarea")
    private WebElement cardTitle;
    @FindBy (className ="list-card-details js-card-details")
    private WebElement card;
    @FindBy(css =".icon-edit")
    private WebElement cardOptions;
    @FindBy (css =".js-move-card > .quick-card-editor-buttons-item-text")
    private WebElement moveButton;



    public BoardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    public void createList(String name) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(nameInput)).sendKeys(name);
        nameInput.sendKeys(Keys.ENTER);
    }

    public void createCard(String name) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(listButton)).click();
        wait.until(ExpectedConditions.visibilityOf(cardTitle)).sendKeys(name);
        cardTitle.sendKeys(Keys.ENTER);
    }
    public void moveCardtoInProgress() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(cardOptions));
        actions.contextClick(cardOptions).perform();
        wait.until(ExpectedConditions.visibilityOf(moveButton)).click();
        WebElement element = driver.findElement(By.cssSelector(".js-move-card > .quick-card-editor-buttons-item-text"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        driver.findElement(By.cssSelector(".js-select-list")).click();
        WebElement dropdown = driver.findElement(By.cssSelector(".js-select-list"));
        dropdown.findElement(By.xpath("//option[. = 'In Progress']")).click();
        driver.findElement(By.xpath("//*[@id='chrome-container']//input[@value='Move']")).click();
    }
    public void moveCardtoInDone() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(cardOptions));
        actions.contextClick(cardOptions).perform();
        wait.until(ExpectedConditions.visibilityOf(moveButton)).click();
        WebElement element = driver.findElement(By.cssSelector(".js-move-card > .quick-card-editor-buttons-item-text"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        driver.findElement(By.cssSelector(".js-select-list")).click();
        WebElement dropdown = driver.findElement(By.cssSelector(".js-select-list"));
        dropdown.findElement(By.xpath("//option[. = 'Done']")).click();
        driver.findElement(By.xpath("//*[@id='chrome-container']//input[@value='Move']")).click();
    }


    public String isCardInList(String listName, String cardName){
       return driver.findElement(By.xpath("//textarea[contains(text(),'"+listName+"')]/../..//span[contains(text(),'"+cardName+"')]")).getText();
    }




    public String isTheListCreated(String nameList) {
        wait(2000);
        return driver.findElement(By.xpath("//textarea[contains(text(),'" + nameList + "')]")).getText();
    }

    public void wait(int miliseconds) {
        driver.manage().timeouts().implicitlyWait(miliseconds, TimeUnit.MILLISECONDS);
    }
}

