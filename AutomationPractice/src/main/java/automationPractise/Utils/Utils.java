package automationPractise.Utils;

import automationPractise.Pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils extends BasePage {
    public static boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }
    public static void typeText(WebElement element,String text){
        element.sendKeys(text);
    }
    public static void selectByValue(WebElement element, String text){
        Select select= new Select(element);
        select.selectByValue(text);
    }
    public static void selectByText(WebElement element, String text){
        Select select= new Select(element);
        select.selectByVisibleText(text);
    }

    public static void waitForElement(WebElement element,int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
