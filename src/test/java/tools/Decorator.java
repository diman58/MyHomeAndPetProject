package tools;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Decorator {
    Click click;
    WebDriver driver;

    public Decorator(Click click) {
        this.click = click;
    }

    public void regularClick(WebElement webElement) {
        webElement.click();
        this.log();
    }

    public void JSClick(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", webElement);
        this.log2();
    }

    public void log() {
        System.out.println("Click was made with regular API");
    }

    public void log2() {
        System.out.println("Click was made with JSexecutor");
    }
}
