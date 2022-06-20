package automationPractise.SmokeTestSuite;

import automationPractise.Pages.AuthenticationPage;
import automationPractise.Pages.CreateAccountPage;
import automationPractise.Pages.HomePage;
import automationPractise.Pages.MyAccountPage;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;


public class SmokeTestSuite extends BaseTest {

    // test data for verifyUserCanLoginWithValidCredentials test case
    static String loginEmail="testaccount123@mailinator.com";
    static String loginPassword="Password123";
    static String loginUserAccountName="John Test";

    HomePage homePage= new HomePage();
    AuthenticationPage authenticationPage=new AuthenticationPage();
    CreateAccountPage createAccountPage=new CreateAccountPage();
    MyAccountPage myAccountPage =new MyAccountPage();


    @Test
    public void verifyUserCanLoginAndAddProductToCart(){
        //Verify Home page is displayed
        Assert.assertTrue(homePage.isHomeTabsDisplayed());
        //Click signIn Link
        homePage.clickSignInLink();
        //wait page to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        //Verify SignIn Panel is displayed
        Assert.assertTrue(authenticationPage.isLoginPanelDisplayed());
        //Enter email
        authenticationPage.enterEmail(loginEmail);
        //Enter password
        authenticationPage.enterPassword(loginPassword);
        //click signIn Button
        authenticationPage.clickSignInButton();
        //wait page to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        //Get SignIn user account name
        String displayedAccountName= myAccountPage.getSignInUserAccountName();
        //Verify login user
        Assert.assertEquals(displayedAccountName,loginUserAccountName);
        //Verify myAccount panel is displayed
        myAccountPage.isMyAccountPanelDisplayed();
        myAccountPage.clickDressesTab();
        //wait page to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        myAccountPage.addHighestPriceItemToCart();
        myAccountPage.continueToCheckout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        myAccountPage.CheckAddedItemInCart();
    }
}
