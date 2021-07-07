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
import static Pages.DraftBoxPage.lastDraftLetterReceiver;
import static Pages.HomePage.draftsBtn;
import static Pages.HomePage.letterHasBeenSentSuccessfully;
import static Pages.IndexPage.*;
import static Pages.LastDraftPage.editBtn;
import static Pages.NewLetterPage.attachFile;
import static Pages.NewLetterPage.sendBtn;

public class SendEmailTest {
    private WebDriver driver;

    @BeforeMethod
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void sendEmail() {
        BasePage tempPage = new IndexPage(driver)
            .openHomePage()
            .switchToIFrame("//iframe[contains(@src,'id.rambler.ru/login')]")
            .WBDw82(driver,"//input[@id='login']")
            .enterValues(loginField,EMAIL)
            .enterValues(passwordField,PASSWORD)
            .click(loginBtn)
            .WBDw8(driver,"//span[@class='rui__1E3a7']");
        String tempTextValue = tempPage.getTextValue(draftsBtn);
        char[] aVBA = tempTextValue.toCharArray();
        char actualValueBeforeActions = aVBA[aVBA.length-1];
        if(!Character.isDigit(actualValueBeforeActions)) {
            actualValueBeforeActions = '0';
        }
        //String tempTextValue2 =
                tempPage.click(draftsBtn)
                .WBDw82(driver,"//span[@class='MailListItem-sender-1G']")
                .click(lastDraftLetterReceiver)
                .click(editBtn)
                .WBDw8(driver,"//p[text()='Новое сообщение']")
                .refreshPage()
                .WBDw82(driver,"//button[@data-compose-button='top-send']")
                .click(sendBtn);
        /*        .WBDw82(driver,"//header[text()='Письмо отправлено']")
                .getTextValue(draftsBtn);
        char[] aVBA2 = tempTextValue2.toCharArray();
        char actualValueAfterActions = aVBA2[aVBA2.length-1];
        if(!Character.isDigit(actualValueAfterActions)) {
            actualValueAfterActions = '0';
        }

        Assert.assertTrue(actualValueBeforeActions==actualValueAfterActions+1);*/

        /*BasePage tempPage = new IndexPage(driver);
        tempPage = tempPage
                .openHomePage()
                .switchToIFrame("//iframe[contains(@src,'id.rambler.ru/login')]")
                .enterValues(loginField,EMAIL)
                .enterValues(passwordField,PASSWORD)
                .click(loginBtn)
                .WBDw8(driver,"//span[@class='rui__1E3a7']")
                .click(draftsBtn)
                .WBDw82(driver,"//span[@class='MailListItem-sender-1G']")
                .click(lastDraftLetterReceiver)
                .click(editBtn)
                .WBDw8(driver,"//p[text()='Новое сообщение']")
                .refreshPage()
                .WBDw82(driver,"//button[@data-compose-button='top-send']")
                .click(sendBtn);
        System.out.println(tempPage);*/

    }

    @AfterMethod
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
