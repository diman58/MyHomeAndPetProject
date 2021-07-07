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
import static Pages.HomePage.myAccName;
import static Pages.IndexPage.*;

public class SuccessfullLoginTest {
    private WebDriver driver;
    private final String expectedValue = "forselenium@rambler.ru";

    @BeforeMethod
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest()  {
        String actualValue = new IndexPage(driver)
                .openHomePage()
                .switchToIFrame("//iframe[contains(@src,'id.rambler.ru/login')]")
                .WBDw82(driver,"//input[@id='login']")
                .enterValues(loginField,EMAIL)
                .enterValues(passwordField,PASSWORD)
                .click(loginBtn)
                .WBDw8(driver,"//span[@class='rui__1E3a7']")
                .getTextValue(myAccName);

        Assert.assertSame(actualValue,expectedValue);
    }

    @AfterMethod
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

 /*String x = new BasePage(driver)
                .openHomePage()
                .switchToIFrame("//iframe[contains(@src,'id.rambler.ru/login')]")
                .enterValues(loginField,EMAIL)
                .enterValues(passwordField,PASSWORD)
                .click(loginBtn)
                .WBDw8(driver,"//span[@class='rui__1E3a7']")
                .click(writeLetterBtn)
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
                .getTextValue(draftsBtn);
                asd
        char[] x2 = x.toCharArray();
        System.out.println(x2[x2.length-1]); //дождаться обновления количества писем*/