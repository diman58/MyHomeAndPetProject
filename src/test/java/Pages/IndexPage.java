package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage {
    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//iframe[contains(@src,'id.rambler.ru/login')]")
    private WebElement iframe;

    @FindBy(xpath = "//input[@id='login']")
    public static WebElement loginField;

    @FindBy(xpath = "//input[@id='password']")
    public static WebElement passwordField;

    @FindBy(xpath = "//span[@class='rui-Button-content']")
    public static WebElement loginBtn;

}
