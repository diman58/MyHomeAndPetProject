package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='rui-Button-content']")
    public static WebElement writeLetterBtn;

    @FindBy(xpath = "//span[@class='rui__1E3a7']")
    public static WebElement myAccName;

    @FindBy(xpath = "//a[contains(@title,'Черновики')]")
    public static WebElement draftsBtn;

    @FindBy(xpath = "//a[@data-cerber='topline::mail::menu::sport']")
    public static WebElement sportBtn;

    @FindBy(xpath = "//header[text()='Письмо отправлено']")
    public static WebElement letterHasBeenSentSuccessfully;

    @FindBy(xpath = "//a[@href='/folder/SentBox']")
    public static WebElement sentBox;

    @FindBy(xpath = "//button[@data-cerber='topline::mail::user::exit']")
    public static WebElement exitBtn;

}
