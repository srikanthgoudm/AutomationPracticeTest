package automationPractise.Pages;

import automationPractise.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyAccountPage extends BasePage {
    @FindBy(css=".account")
    WebElement accountName;
    @FindBy(css=".logout")
    WebElement signOutLink;
    @FindBy(css="#center_column")
    WebElement myAccountPanel;
    @FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    WebElement dressesTab;
    @FindBy(css = ".product_list.grid.row")
    private WebElement dressesGrid;
    @FindBy(xpath="//div[@class='product-image-container']//span[@class='price product-price']")
    List<WebElement> productPrices;
    @FindBy(xpath = "//div[@class='right-block']")
    List<WebElement> rightBlocks;
    @FindBy(className = "shopping_cart")
    WebElement shoppingCart;

    @FindBy(css="[title='Proceed to checkout']")
    WebElement goToCheckout;
    public MyAccountPage(){
        PageFactory.initElements(driver,this);
    }
    public String getSignInUserAccountName(){
        return accountName.getText();
    }
    public void clickSignOutLink(){
        signOutLink.click();
    }
    public boolean isMyAccountPanelDisplayed(){
        return myAccountPanel.isDisplayed();
    }
    public void clickDressesTab(){
        dressesTab.click();
    }
    public void addHighestPriceItemToCart(){
       // System.out.println(productPrices);
        List<Float> priceList = new ArrayList<Float>();
        for(WebElement element:productPrices){

            //String price=element.getText();
            String price=element.getAttribute("innerHTML");
            float currencyValue = Float.parseFloat(price.replaceAll("[^\\d.]", ""));
            priceList.add(currencyValue);
        }

//        Float highestPrice = Collections.max(priceList);
        Collections.max(priceList);
        Float secondHighestPrice = priceList.get(priceList.size()-2);;
        for(WebElement block:rightBlocks){

            WebElement productPrice=block.findElement(By.cssSelector(".price.product-price"));
           String price=productPrice.getText();
            float currencyValue = Float.parseFloat(price.replaceAll("[^\\d.]", ""));
            if(currencyValue==secondHighestPrice){
                Actions action = new Actions(driver);
                action.moveToElement(block).perform();
                System.out.println(price);
                WebElement addCartButtons=block.findElement(By.cssSelector(".button.ajax_add_to_cart_button.btn.btn-default"));
                addCartButtons.isDisplayed();
                System.out.println(addCartButtons.isDisplayed());
                addCartButtons.click();
            }

        }

    }
    public void CheckAddedItemInCart(){
        shoppingCart.click();
    }

    public void continueToCheckout() {
        Utils.waitForElement(shoppingCart,10);
        goToCheckout.click();
    }
}
