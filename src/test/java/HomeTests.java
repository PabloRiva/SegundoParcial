import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class HomeTests extends BaseTest{
    @Test
    public void mainTest(){
        // Login with standard user
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        // Add products
        HomePage homepage= new HomePage(DriverManager.getDriver().driver);
        homepage.addTshirtRedButton();
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        // Go to cart
        homepage.clickOnCartIcon();
        // Verify both Items are in the cart
        CartPage cartPage = new CartPage(DriverManager.getDriver().driver);
        Assert.assertTrue(cartPage.tShirtIsOnCart());
        Assert.assertTrue(cartPage.backPackIsOnCart());
        // Verify the number of elements is correct in cart icon
        Assert.assertEquals("2",homepage.getCartIconText());
        // Remove both elements
        cartPage.clickOnBPRemoveButton();
        cartPage.clickOnTSRemoveButton();
        // Verify both elements have been removed
        try{
            Assert.assertFalse(cartPage.backPackIsOnCart());
            Assert.assertFalse(cartPage.tShirtIsOnCart());
        } catch (Exception e){}
        // Verify the cart icon has no numbers
        Assert.assertEquals("",homepage.getCartIconText());

    }
}
