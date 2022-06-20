package automationPractise.SmokeTestSuite;

import automationPractise.Pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest extends BasePage {
    @BeforeClass
    public static void openBrowser(){
        WebDriverManager.chromedriver().setup();
        //Open the browser
        driver= new ChromeDriver();

        //Open Url
        driver.get(baseUrl);
        //wait page to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @AfterClass
    public static void closeBrowser(){
//        driver.close();
    }
    /*@Before
    public void navigateToAuthenticationPage(){
        WebElement signInLink= driver.findElement(By.cssSelector(".login"));
        signInLink.click();
        // wait for pageload
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }*/
}
