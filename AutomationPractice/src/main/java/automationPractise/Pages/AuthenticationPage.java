package automationPractise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePage {
    @FindBy(css="#create-account_form")
    WebElement createAccountForm;
    @FindBy(css="#email_create")
    WebElement emailTextBox;
    @FindBy(css="#SubmitCreate")
    WebElement createAccountButton;
    @FindBy(css="#login_form")
    WebElement loginForm;
    @FindBy(css="#email")
    WebElement loginEmailElement;
    @FindBy(css="#passwd")
    WebElement loginPasswordElement;
    @FindBy(css="#SubmitLogin")
    WebElement signInButton;

    public AuthenticationPage(){
        PageFactory.initElements(driver,this);
    }
    public boolean isCreateAccountPanelDisplayed(){
        return createAccountForm.isDisplayed();
    }
    public void enterEmailAndContinue(String email){
        emailTextBox.sendKeys(email);
        createAccountButton.click();;
    }
    public boolean isLoginPanelDisplayed(){
        return loginForm.isDisplayed();
    }
    public void enterEmail(String loginEmail){
        loginEmailElement.sendKeys(loginEmail);
    }
    public void enterPassword(String loginPassword){
        loginPasswordElement.sendKeys(loginPassword);
    }
    public void clickSignInButton(){
        signInButton.click();;
    }



}
