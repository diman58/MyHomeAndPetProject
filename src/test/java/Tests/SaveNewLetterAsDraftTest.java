package Tests;

import Pages.BasePage;
import Steps.CreateNewDraftLetterSteps;
import Steps.LogInSteps;
import io.cucumber.java.sl.In;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tools.DriverManager;


import static Pages.HomePage.draftsBtn;

public class SaveNewLetterAsDraftTest {
    private WebDriver driver;

    @BeforeMethod
    public void browserSetUp() {
        driver = DriverManager.getDriver();
    }

    @Test
    public void saveAsDraft()  {
        BasePage tempPage = LogInSteps.login(driver);

        String tempTextValue = tempPage.getTextValue(draftsBtn);
        char[] aVBA = tempTextValue.toCharArray();
        char actualValueBeforeActions = aVBA[aVBA.length-1];
        if(!Character.isDigit(actualValueBeforeActions)) {
            actualValueBeforeActions = '0';
        }

        tempPage = CreateNewDraftLetterSteps.createNewDraftLetterSteps(driver);

        String tempTextValue2 = tempPage.getTextValue(draftsBtn);
        char[] aVAA = tempTextValue2.toCharArray();
        char actualValueAfterActions = aVAA[aVAA.length-1];

        int before = Integer.parseInt(String.valueOf(actualValueBeforeActions));
        int after = Integer.parseInt(String.valueOf(actualValueAfterActions));

        Assert.assertEquals(before,after-1);
    }

    @AfterMethod
    public void browserTearDown() {
        driver.quit();
        driver = DriverManager.killDriver();
    }
}
