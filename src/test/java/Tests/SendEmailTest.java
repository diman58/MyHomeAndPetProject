package Tests;

import Pages.BasePage;
import Steps.LogInSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tools.DriverManager;



import static Pages.DraftBoxPage.lastDraftLetterReceiver;
import static Pages.HomePage.draftsBtn;
import static Pages.LastDraftPage.editBtn;
import static Pages.NewLetterPage.sendBtn;

public class SendEmailTest {
    private WebDriver driver;

    @BeforeMethod
    public void browserSetUp() {
        driver = DriverManager.getDriver();
    }

    @Test
    public void sendEmail() {
        BasePage tempPage = LogInSteps.login(driver);

        String tempTextValue = tempPage.getTextValue(draftsBtn);
        char[] aVBA = tempTextValue.toCharArray();
        char actualValueBeforeActions = aVBA[aVBA.length-1];
        if(!Character.isDigit(actualValueBeforeActions)) {
            actualValueBeforeActions = '0';
        }

        String tempTextValue2 =
                tempPage.click(draftsBtn)
                .WBDw82(driver,"//div[contains(@class,'ListItem-sender')]")
                .click(lastDraftLetterReceiver)
                .click(editBtn)
                .WBDw8(driver,"//p[text()='Новое сообщение']")
                .refreshPage()
                .WBDw82(driver,"//button[@data-compose-button='top-send']")
                .click(sendBtn)
                .WBDw82(driver,"//header[text()='Письмо отправлено']")
                .click(draftsBtn)
                .getTextValue(draftsBtn);
        char[] aVBA2 = tempTextValue2.toCharArray();
        char actualValueAfterActions = aVBA2[aVBA2.length-1];
        if(!Character.isDigit(actualValueAfterActions)) {
            actualValueAfterActions = '0';
        }

        int before = Integer.parseInt(String.valueOf(actualValueBeforeActions));
        int after = Integer.parseInt(String.valueOf(actualValueAfterActions));

        System.out.println("before:"+before);
        System.out.println("after:"+after);

        Assert.assertEquals(before,after+1);
    }

    @AfterMethod
    public void browserTearDown() {
        driver.quit();
        driver = DriverManager.killDriver();
    }
}
