package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftBoxPage extends BasePage{
    public DraftBoxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(@title,'Черновики')]")
    public static WebElement draftsBtn;

    @FindBy(xpath = "//a[@class='MailListItem-wrapper-3Q']")
    public static WebElement lastDraft;

    @FindBy(xpath = "//span[@class='MailListItem-sender-1G']")
    public static WebElement lastDraftLetterReceiver;

    @FindBy(xpath = "//span[contains(@class,'MailListItem-subject')]")
    public static WebElement lastDraftLetterSubject;

    @FindBy(xpath = "//span[contains(@class,'MailListItem-snippet')]")
    public static WebElement lastDraftBodyValue;
}
