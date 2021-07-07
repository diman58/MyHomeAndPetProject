package Tests;

import Pages.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.BasePage.EMAIL;
import static Pages.BasePage.PASSWORD;
import static Pages.HomePage.exitBtn;
import static Pages.HomePage.myAccName;
import static Pages.IndexPage.*;

public class SuccessfullLogOutTest {
    private WebDriver driver;

    @BeforeMethod
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void logOut() {
        new IndexPage(driver)
                .openHomePage()
                .switchToIFrame("//iframe[contains(@src,'id.rambler.ru/login')]")
                .WBDw82(driver,"//input[@id='login']")
                .enterValues(loginField,EMAIL)
                .enterValues(passwordField,PASSWORD)
                .click(loginBtn)
                .WBDw82(driver,"//span[@class='rui__1E3a7']")
                .refreshPage()
                .click(myAccName)
                .WBDw82(driver,"//span[@class='rui__1E3a7']")
                .click(exitBtn);
        Assert.assertTrue(!HOMEPAGE_URL.equals(driver.getCurrentUrl()));
    }

    @AfterMethod
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
