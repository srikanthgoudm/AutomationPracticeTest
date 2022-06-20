package automationPractise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    @FindBy(css="#home-page-tabs")
    WebElement homeTabs;

    @FindBy(css=".login")
    WebElement signInLink;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    public boolean isHomeTabsDisplayed(){
        return homeTabs.isDisplayed();
    }
    public void clickSignInLink(){
        signInLink.click();
    }


}
