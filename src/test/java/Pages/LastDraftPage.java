package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LastDraftPage extends BasePage{
    public LastDraftPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains(@class,'ButtonWithIcon-icon-1Q')]")
    public static WebElement editBtn;
}
