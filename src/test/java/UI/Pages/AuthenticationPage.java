package UI.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage {
    private WebDriver driver;
    @FindBy(id = "user")
    private WebElement user;
    @FindBy(id = "password")
    private WebElement password;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logIn(String user, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(this.user)).sendKeys(user);
        this.password.sendKeys(password);
        this.password.sendKeys(Keys.ENTER);

    }


}
