package tools;

import Pages.*;
import org.openqa.selenium.WebDriver;

public class PagesCreater {
    protected WebDriver driver;
    public BasePage createPage(WebDriver driver, String URL) {
        switch (URL) {
            case "https://mail.rambler.ru/": return new IndexPage(driver);
            case "https://mail.rambler.ru/folder/INBOX": return new HomePage(driver);
            case "https://mail.rambler.ru/compose": return new NewLetterPage(driver);
            case "https://mail.rambler.ru/folder/DraftBox": return new DraftBoxPage(driver);
            case "folderName=DraftBox": return new LastDraftPage(driver);
            case "https://mail.rambler.ru/folder/SentBox": return new SentBoxPage(driver);
            default: throw new RuntimeException("problem in switch");
        }
    }
}
