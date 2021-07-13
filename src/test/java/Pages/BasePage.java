package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.PagesCreater;
import tools.URLHandler;

import static Pages.HomePage.sportBtn;

public class BasePage {
    public static final String HOMEPAGE_URL = "https://mail.rambler.ru/";
    public static final int TIME_OUT = 10;
    public static String parent;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        WBDw82(driver, "//iframe[contains(@src,'id.rambler.ru/login')]");
        new URLHandler().getDefaultURL(driver);
        return new PagesCreater().createPage(driver, driver.getCurrentUrl());
    }

    public BasePage click(WebElement element) {
        element.click();
        return new URLHandler().checkPagePresent(this, this.driver);
    }

    public BasePage enterValues(WebElement element, String value) {
        element.sendKeys(value);
        return this;
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public BasePage switchToIFrame(String xpath) {
        WebElement iframe = driver.findElement(By.xpath(xpath));
        driver.switchTo().frame(iframe);
        return this;
    }

    public String getTextValue(WebElement element) {
        return element.getText();
    }

    public BasePage WBDw8(WebDriver driver, String xPath) {
        new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(xPath)
                ));
        return new URLHandler().checkPagePresent(this, this.driver);
    }

    public BasePage WBDw82(WebDriver driver,String xPath) {
        new WebDriverWait(driver,TIME_OUT)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(xPath)
                ));
        return this;
    }

    public BasePage getParentWindow (WebDriver driver) {
        parent = driver.getWindowHandle();
        return this;
    }

    public BasePage returnBackToParentWindow(WebDriver driver) {
        driver.switchTo().window(parent);
        return this;
    }

    public BasePage closeNotificationsWindow(WebDriver driver) {
        new Actions(driver).moveToElement(sportBtn).moveByOffset(30,30).click().build().perform();
        return this;
    }

    public BasePage refreshPage() {
        return new URLHandler().checkPagePresent(this, this.driver);
    }

    public BasePage closeAllert() {
        Alert alert = (new WebDriverWait(this.driver,TIME_OUT).until(ExpectedConditions.alertIsPresent()));
        driver.switchTo().alert().dismiss();
        return this;
    }

}
