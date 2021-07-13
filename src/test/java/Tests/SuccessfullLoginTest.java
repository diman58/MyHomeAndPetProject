package Tests;

import BO.User;
import Pages.BasePage;
import Steps.LogInSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tools.DriverManager;


import static Pages.HomePage.myAccName;


public class SuccessfullLoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void browserSetUp() {
        driver = DriverManager.getDriver();
    }

    @Test
    public void loginTest()  {
        BasePage tempPage = LogInSteps.login(driver);

        String actualValue = tempPage.getTextValue(myAccName);

        Assert.assertSame(actualValue,User.getLOGIN());
    }

    @AfterMethod
    public void browserTearDown() {
        driver.quit();
        driver = DriverManager.killDriver();
    }
}
