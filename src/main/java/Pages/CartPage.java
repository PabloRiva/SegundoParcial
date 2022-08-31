package Pages;

import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    @FindBy(id="item_4_title_link")
    WebElement backPack;
    @FindBy(id="item_3_title_link")
    WebElement tShirt;
    @FindBy(id="remove-sauce-labs-backpack")
    WebElement bpRemoveButton;
    @FindBy(id="remove-test.allthethings()-t-shirt-(red)")
    WebElement tsRemoveButton;
    @FindBy(id="continue-shopping")
    WebElement csButton;
    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    WebElement bpPrice;
    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")
    WebElement tsPrice;
    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean backPackIsOnCart(){
        boolean bpIsOnCart = backPack.isDisplayed();
        return  bpIsOnCart;
    }
    public boolean tShirtIsOnCart(){
        boolean tsIsOnCart = tShirt.isDisplayed();
        return tsIsOnCart;
    }
    public void clickOnBPRemoveButton(){
        bpRemoveButton.click();
    }
    public void clickOnTSRemoveButton(){
        tsRemoveButton.click();
    }
    public void clickOnContinueShoppingButton(){
        csButton.click();
    }
    public boolean bpRemoveButtonIsDisplayed(){
        boolean isDisplayed = bpRemoveButton.isDisplayed();
        return  isDisplayed;
    }

    public String getBPrice(){
        String price = bpPrice.getText();
        return price;
    }
    public String getTSPrice(){
        String price = tsPrice.getText();
        return price;
    }

}
