package UI.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    private WebDriver driver;
    @FindBy(xpath = "//span[contains(text(),'Create new board')]")
    private WebElement newBoard;
    @FindBy(xpath = "//*[@id='content']//span[contains(text(),'Boards')]")
    private WebElement boardLabel;
    @FindBy(className ="subtle-input")
	private WebElement boardTitle;

    public HomePage(WebDriver driver) {

        super(driver);
        this.driver = driver;

    }

    public void createBoard(String tittle) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(newBoard)).click();
        wait.until(ExpectedConditions.visibilityOf(boardTitle)).sendKeys(tittle);
        boardTitle.sendKeys(Keys.ENTER);

    }

    public String isLoginSuccesfull() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions
                .visibilityOf(boardLabel)).getText();

    }
}
