package Tests;

import BO.Letter;
import Pages.BasePage;
import Steps.LogInSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tools.DriverManager;


import static Pages.DraftBoxPage.*;
import static Pages.HomePage.draftsBtn;

public class ValidateJustCreatedDraftLetterTest {
    private WebDriver driver;

    @BeforeMethod
    public void browserSetUp() {
        driver = DriverManager.getDriver();
    }

    @Test
    public void validateJustCreatedDraftletter() {
        BasePage tempPage = LogInSteps.login(driver)
                .click(draftsBtn)
                .WBDw82(driver,"//span[@class='MailListItem-sender-1G']");

        String actualReceiver = tempPage.getTextValue(lastDraftLetterReceiver);
        actualReceiver = actualReceiver + "@gmail.com";

        String actualSubject = tempPage.getTextValue(lastDraftLetterSubject);

        String actualBodyValue = tempPage.getTextValue(lastDraftBodyValue);
        actualBodyValue = actualBodyValue.substring(actualSubject.length());

        Assert.assertSame(actualReceiver, Letter.getReceiversFieldValue(), "wrong receiver");
        Assert.assertSame(actualSubject,Letter.getSubjectFieldValue(), "wrong subject");
        Assert.assertSame(actualBodyValue,Letter.getBodyOfLetterFieldValue(), "wrong body");

    }

    @AfterMethod
    public void browserTearDown() {
        driver.quit();
        driver = DriverManager.killDriver();
    }
}
