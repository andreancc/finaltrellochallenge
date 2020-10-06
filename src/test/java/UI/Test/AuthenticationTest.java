package UI.Test;

import UI.Pages.AuthenticationPage;
import UI.Pages.HomePage;
import UI.Pages.LauchPage;
import UI.Pages.SignUpPage;
import UI.Utils.BrowserFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AuthenticationTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        driver = BrowserFactory.getBrowser("Firefox");
        driver.get("https://trello.com/");


    }
    @Test
    public void authentication() {
        LauchPage lauchPage=PageFactory.initElements(driver,LauchPage.class);
        lauchPage.clickLogin();
        wait(5000);
        AuthenticationPage LoginPage = PageFactory.initElements(driver, AuthenticationPage.class);
        LoginPage.logIn("laura.castillo@usantoto.edu.co", "Bladimir55");
        HomePage home= PageFactory.initElements(driver, HomePage.class);
        Assert.assertEquals("Boards", home.isLoginSuccesfull());
    }
    @Test
    public void signUp()  {
        LauchPage lauchPage=PageFactory.initElements(driver,LauchPage.class);
        lauchPage.clickSignUp();
        SignUpPage page = PageFactory.initElements(driver, SignUpPage.class);
        page.enterMail("andreanccwe@hotmail.com");
        Assert.assertTrue(page.createUserWithoutPassword("Andrea"));
    }

    public void wait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.MILLISECONDS);
    }
}
