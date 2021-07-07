package Pages;

import org.openqa.selenium.WebDriver;

public class URLHandler {
    public static String wasURL;
    public static String isURL;
    public BasePage checkPagePresent(BasePage basePage, WebDriver driver) {
        isURL = driver.getCurrentUrl();
        if(isURL.contains("https://mail.rambler.ru/folder/DraftBox/DraftBox")){
            isURL = isURL.substring(0,isURL.length()-4);
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

