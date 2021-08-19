package tools;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;

public class URLHandler {
    public static String wasURL;
    public static String isURL;
    public BasePage checkPagePresent(BasePage basePage, WebDriver driver) {
        isURL = driver.getCurrentUrl();
        if(isURL.contains("https://mail.rambler.ru/folder/DraftBox/")){
            isURL = "folderName=DraftBox";
            //System.out.println(isURL);
        }
        if(!isURL.equals(wasURL)) {
            wasURL = isURL;
            return new PagesCreater().createPage(driver, isURL);
        }
        return basePage;
    }

    public void getDefaultURL(WebDriver driver) {
        wasURL = driver.getCurrentUrl();
    }
}

