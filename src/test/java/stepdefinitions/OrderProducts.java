package stepdefinitions;

import org.openqa.selenium.WebDriver;

import factory.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.StorePage;

public class OrderProducts {
    WebDriver driver = DriverManager.getDriver();
    StorePage storePage = new StorePage(driver);

    @When("the user filters products by price from low to high")
    public void the_user_filters_products_by_price_from_low_to_high() {
        storePage.orderProducts("Sort by price: low to high");
    }

    @Then("the products should display from the cheapest to the most expensive")
    public void the_products_should_display_from_the_cheapest_to_the_most_expensive() {
        storePage.checkOrderOfProductsByPrice();
    }
}
