package stepdefinitions;

import org.openqa.selenium.WebDriver;

import factory.DriverManager;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutPage;
import pages.StorePage;

public class Checkout {
    WebDriver driver = DriverManager.getDriver();
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @When("the user navigates to the cart page")
    public void the_user_navigates_to_the_cart_page() {
        new StorePage(driver).viewCart();
    }

    @When("the user clicks on Proceed to Checkout button")
    public void the_user_clicks_on_proceed_to_checkout_button() {
        new CartPage(driver).proceedToCheckout();
    }

    @When("the user fills in {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
    public void the_user_fills_in_and(String string, String string2, String string3, String string4, String string5,
            String string6, String string7, String string8) {
        checkoutPage.enterBillingFirstName(string);
        checkoutPage.enterBillingLastName(string2);
        checkoutPage.enterCompanyName(string3);
        checkoutPage.selectRegion(string4);
        checkoutPage.enterFirstStreetAddress(string5);
        checkoutPage.enterSecondStreetAddress(string5);
        checkoutPage.enterBillingTown(string6);
        checkoutPage.enterBillingPostCode(string7);
        checkoutPage.enterBillingPhone(string8);
    }

    @When("the user clicks on Place Order button")
    public void the_user_clicks_on_place_order_button() {
        checkoutPage.placeOrder();
    }

    @When("the user should see the message {string}")
    public void the_user_should_see_the_message(String string) {
        checkoutPage.isOrderSuccessful(string);
    }
}
