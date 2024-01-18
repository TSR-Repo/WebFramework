package stepdefinitions;

import org.openqa.selenium.WebDriver;

import factory.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.StorePage;

public class AddProductToCart {
    WebDriver driver = DriverManager.getDriver();
    StorePage storePage = new StorePage(driver);
    CartPage cartPage = new CartPage(driver);

    @When("the user adds a {string} to cart")
    public void the_user_adds_a_to_cart(String string) {
        storePage.addProductToCart(string);
    }

    @When("the user navigates to cart")
    public void the_user_clicks_on_view_cart_link() {
        storePage.viewCart();
    }

    @Then("the added {string} should be present in the cart")
    public void the_added_should_be_present_in_the_cart(String string) {
        String productInCart = cartPage.getProductNameFromCart(string);
        String expectedProductInCart = string;
        cartPage.checkSimilarityOfText(productInCart, expectedProductInCart);
    }

}
