package Tests;

import Pages.BasePage;
import Pages.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.BasePage.EMAIL;
import static Pages.BasePage.PASSWORD;
import static Pages.HomePage.draftsBtn;
import static Pages.HomePage.writeLetterBtn;
import static Pages.IndexPage.*;
import static Pages.NewLetterPage.*;

public class SaveNewLetterAsDraftTest {
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
    public void saveAsDraft()  {
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

        String tempTextValue2 = tempPage.click(writeLetterBtn)
                .WBDw8(driver,"//iframe[@id='editor_ifr']")
                .enterValues(receiversField,receiversFieldValue)
                .enterValues(subjectField,subjectFieldValue)
                .getParentWindow(driver)
                .switchToIFrame("//iframe[@id='editor_ifr']")
                .enterValues(bodyOfLetterField,bodyOfLetterFieldValue)
                .returnBackToParentWindow(driver)
                .click(draftsBtn)
                .WBDw8(driver,"//iframe[@style='height:0;width:0;border:0;position:absolute;left:-10000px;top:-1000px;']")
                .click(saveAsDraftBtn)
                .WBDw82(driver,"//div[text()='Изменения сохранены']")
                .getTextValue(draftsBtn);
        char[] aVAA = tempTextValue2.toCharArray();
        char actualValueAfterActions = aVAA[aVAA.length-1];


        Assert.assertTrue(actualValueBeforeActions==actualValueAfterActions-1);
    }

    @AfterMethod
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
