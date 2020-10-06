package UI.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void moveCardtoInProgress(String name) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(listButton)).click();
        wait.until(ExpectedConditions.visibilityOf(cardTitle)).sendKeys(name);
        cardTitle.sendKeys(Keys.ENTER);
    }


    public String isTheListCreated(String nameList) {
        wait(2000);
        return driver.findElement(By.xpath("//textarea[contains(text(),'" + nameList + "')]")).getText();


    }

    public void wait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.MILLISECONDS);
    }
}

