package UI.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LauchPage {
    private WebDriver driver;
    @FindBy(linkText = "Log In")
    private WebElement logInButton;
    @FindBy(linkText = "Sign Up")
    private WebElement signUpButton;

    public LauchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(logInButton)).click();

    }

    public void clickSignUp() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(signUpButton)).click();

    }
}
