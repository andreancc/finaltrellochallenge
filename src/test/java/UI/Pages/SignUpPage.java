package UI.Pages;

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
    @FindBy(id = "signup-submit")
    private WebElement signupButton;
    @FindBy(className = "sc-kvZOFW kTQwdd")
    private WebElement warning;


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterMail(String mail) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(this.mail)).sendKeys(mail);
        this.mail.sendKeys(Keys.ENTER);
    }

    public boolean createUserWithoutPassword(String name) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("displayName"))).sendKeys(name);
        signupButton.click();
        if (ExpectedConditions.visibilityOf(warning) != null) {
            return true;
        }
        return false;
    }


    public void wait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.MILLISECONDS);
    }
}
