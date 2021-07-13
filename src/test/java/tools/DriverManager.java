package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver==null) {
            setDriver();
        }
        return driver;
    }

    public static WebDriver setDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver killDriver() {
        driver = null;
        return driver;
    }
}
