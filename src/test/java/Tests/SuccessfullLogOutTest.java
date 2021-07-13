package Tests;

import Steps.LogInSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tools.DriverManager;


import static Pages.HomePage.exitBtn;
import static Pages.HomePage.myAccName;
import static Pages.IndexPage.*;

public class SuccessfullLogOutTest {
    private WebDriver driver;

    @BeforeMethod
    public void browserSetUp() {
        driver = DriverManager.getDriver();
    }

    @Test
    public void logOut() {
        LogInSteps.login(driver)
                .refreshPage()
                .click(myAccName)
                .WBDw82(driver,"//span[@class='rui__1E3a7']")
                .click(exitBtn);

        Assert.assertTrue(!HOMEPAGE_URL.equals(driver.getCurrentUrl()));
    }

    @AfterMethod
    public void browserTearDown() {
        driver.quit();
        driver = DriverManager.killDriver();
    }
}
