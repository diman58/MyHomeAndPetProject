package Tests;

import Pages.BasePage;
import Pages.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.BasePage.EMAIL;
import static Pages.BasePage.PASSWORD;
import static Pages.DraftBoxPage.*;
import static Pages.HomePage.draftsBtn;
import static Pages.HomePage.sentBox;
import static Pages.IndexPage.*;
import static Pages.LastDraftPage.editBtn;
import static Pages.NewLetterPage.sendBtn;
import static Pages.SentBoxPage.*;

public class ValidateJustSentLetterIsInSentFolder {
    private WebDriver driver;
    private static final String receiversFieldValue = "arrow2383347dmitriy@gmail.com";
    private static final String subjectFieldValue = "testSubject";
    private static final String bodyOfLetterFieldValue = "testBodyValue";

    @BeforeMethod
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validateJustSentLetter() {
        BasePage tempPage = new IndexPage(driver);
        tempPage = tempPage
                .openHomePage()
                .switchToIFrame("//iframe[contains(@src,'id.rambler.ru/login')]")
                .WBDw82(driver,"//input[@id='login']")
                .enterValues(loginField,EMAIL)
                .enterValues(passwordField,PASSWORD)
                .click(loginBtn)
                .WBDw8(driver,"//span[@class='rui__1E3a7']")
                .click(sentBox)
                .WBDw82(driver,"//span[@class='MailListItem-sender-1G']");

        String actualReceiver = tempPage.getTextValue(lastSentLetterReceiver);
        actualReceiver = actualReceiver + "@gmail.com";
        String actualSubject = tempPage.getTextValue(lastSentLetterSubject);
        String actualBodyValue = tempPage.getTextValue(lastSentBodyValue);
        actualBodyValue = actualBodyValue.substring(actualSubject.length());

        Assert.assertSame(actualReceiver,receiversFieldValue, "wrong receiver");
        Assert.assertSame(actualSubject,subjectFieldValue, "wrong subject");
        Assert.assertSame(actualBodyValue,bodyOfLetterFieldValue, "wrong body");

    }

    @AfterMethod
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
