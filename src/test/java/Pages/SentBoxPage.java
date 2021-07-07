package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SentBoxPage extends BasePage{
    public SentBoxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='MailListItem-sender-1G']")
    public static WebElement lastSentLetterReceiver;

    @FindBy(xpath = "//span[contains(@class,'MailListItem-subject')]")
    public static WebElement lastSentLetterSubject;

    @FindBy(xpath = "//span[contains(@class,'MailListItem-snippet')]")
    public static WebElement lastSentBodyValue;
}
