package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLetterPage extends BasePage{
    public NewLetterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='receivers']")
    public static WebElement receiversField;

    @FindBy(xpath = "//input[@id='subject']")
    public static WebElement subjectField;

    @FindBy(xpath = "//body[@id='tinymce']")
    public static WebElement bodyOfLetterField;

    @FindBy(xpath = "//span[text()='Сохранить черновик']")
    public static WebElement saveAsDraft;

    @FindBy(xpath = "//span[text()='Сохранить']")
    public static WebElement saveAsDraftBtn;

    @FindBy(xpath = "//button[@data-compose-button='top-send']")
    public static WebElement sendBtn;

    @FindBy(xpath = "//span[text()='Прикрепить файл']")
    public static WebElement attachFile;
}
