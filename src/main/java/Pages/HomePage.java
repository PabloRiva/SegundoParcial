package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement appLogo;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement sauceLabsBackPackAddToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement sauceLabsBackPackRemoveToCartButton;




    @FindBy(className = "product_sort_container")
    WebElement productFilterDropDown;

    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPricesLabel;
    @FindBy(id="inventory_sidebar_link")
    WebElement allItems;

    @FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElement tShirtRedAddToCartButton;




    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }




    public void clickOnAddSauceLabsBackPackToCartButton(){
        sauceLabsBackPackAddToCartButton.click();
    }



    public void clickOnCartIcon(){
        cartIcon.click();
    }
    public void clickOnAllItems(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(allItems));
        allItems.click();
    }
    public void addTshirtRedButton(){
        tShirtRedAddToCartButton.click();
    }
    public String getCartIconText(){
        String txt = cartIcon.getText();
        return txt;
    }

}
