package Steps;

import BO.User;
import Pages.BasePage;
import Pages.IndexPage;
import org.openqa.selenium.WebDriver;

import static Pages.IndexPage.*;

public class LogInSteps {
    public static Pages.BasePage login(WebDriver driver) {
        return new IndexPage(driver)
                .openHomePage()
                .switchToIFrame("//iframe[contains(@src,'id.rambler.ru/login')]")
                .WBDw82(driver,"//input[@id='login']")
                .enterValues(loginField, User.getLOGIN())
                .enterValues(passwordField,User.getPASSWORD())
                .click(loginBtn)
                .WBDw8(driver,"//span[@class='rui__1E3a7']");
    }
}
