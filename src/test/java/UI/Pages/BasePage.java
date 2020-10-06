package UI.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BasePage {
    private WebDriver driver;
    @FindBy(xpath = "//*[@id='header']//a[@data-test-id='header-home-button']")
    private WebElement homeButton;
    @FindBy(xpath = "//*[@id='header']//button[@data-test-id='header-boards-menu-button']")
    private WebElement boardsButton;
    @FindBy(xpath = "//*[@id='header']//input[@data-test-id='header-search-input']")
    private WebElement inputSearch;
    @FindBy(xpath = "//*[@id='header']//button[@data-test-id='header-create-menu-button']")
    private WebElement addButton;
    @FindBy(xpath = "//*[@id='header']//button[@data-test-id='header-info-button']")
    private WebElement informationButton;
    @FindBy(xpath = "//*[@id='header']//button[@data-test-id='header-notifications-button']")
    private WebElement notificationButton;
    @FindBy(xpath = "//*[@id='header']//button[@data-test-id='header-member-menu-button']")
    private WebElement profileButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    public boolean search(String boardName) {
        inputSearch.sendKeys(boardName);
        if (driver.findElement(By.xpath("//div[contains(text(),'" + boardName + "')]")) == null) {
            return false;
        }
        return true;

    }

    public void clickHomeButton() {
        homeButton.click();
    }

}


