package Steps;

import BO.Letter;
import Pages.BasePage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;


import static Pages.HomePage.draftsBtn;
import static Pages.HomePage.writeLetterBtn;
import static Pages.NewLetterPage.*;

public class CreateNewDraftLetterSteps {
    public static BasePage createNewDraftLetterSteps(WebDriver driver) {
        return new HomePage(driver).click(writeLetterBtn)
                .WBDw8(driver,"//iframe[@id='editor_ifr']")
                .enterValues(receiversField, Letter.getReceiversFieldValue())  //new Letter().getCustomReceiver("asd")
                .enterValues(subjectField, Letter.getSubjectFieldValue())
                .getParentWindow(driver)
                .switchToIFrame("//iframe[@id='editor_ifr']")
                .enterValues(bodyOfLetterField,Letter.getBodyOfLetterFieldValue())
                .returnBackToParentWindow(driver)
                .click(draftsBtn)
                .WBDw8(driver,"//iframe[@style='height:0;width:0;border:0;position:absolute;left:-10000px;top:-1000px;']")
                .click(saveAsDraftBtn)
                .WBDw82(driver,"//div[text()='Изменения сохранены']");
    }
}
