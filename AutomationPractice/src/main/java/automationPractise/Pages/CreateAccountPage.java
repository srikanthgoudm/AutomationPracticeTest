package automationPractise.Pages;

import automationPractise.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BasePage {
    @FindBy(css="#account-creation_form")
    WebElement registrationPageForm;
    @FindBy(css="#id_gender1")
    WebElement gender1;
    @FindBy(css="#id_gender2")
    WebElement gender2;
    @FindBy(css="#customer_firstname")
    WebElement firstNameElement;
    @FindBy(css="#days")
    WebElement dobDays;
    @FindBy(css="#months")
    WebElement dobMonths;
    @FindBy(css="#years")
    WebElement dobYears;
    @FindBy(css="#id_state")
    WebElement stateElement;
    @FindBy(css="#submitAccount")
    WebElement registerButton;

    public CreateAccountPage(){
        PageFactory.initElements(driver,this);
    }
    public boolean isCreateAccountPageDisplayed(){
        return registrationPageForm.isDisplayed();
    }
    public void selectTitle(String title){
        if(title=="Mr"){
            gender1.click();
        }else if(title=="Mrs"){
            gender2.click();;
        }
    }
    public void enterFirstName(String firstName){
        firstNameElement.sendKeys(firstName);
    }
    public void enterDob(String day, String month, String year){
        Utils.selectByValue(dobDays,day);
        Utils.selectByValue(dobMonths,month);
        Utils.selectByValue(dobYears,year);
    }
    public void selectState(String state){
        Utils.selectByText(stateElement,state);
    }
    public void clickRegisterButton(){
        registerButton.click();
    }
}
