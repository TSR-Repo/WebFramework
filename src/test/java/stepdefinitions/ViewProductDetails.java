package stepdefinitions;

import org.openqa.selenium.WebDriver;

import factory.DriverManager;
import io.cucumber.java.en.*;
import pages.StorePage;

public class ViewProductDetails {
    WebDriver driver = DriverManager.getDriver();
    StorePage storePage = new StorePage(driver);

    @Given("the user is on the store page")
    public void user_is_on_the_store_page() {
        storePage.navigateToStorePage();
    }

    @When("the user clicks on a product with product name {string}")
    public void the_user_clicks_on_a_product_with_product_name(String string) {
        storePage.viewProduct(string);
    }

    @Then("the details of {string} should be displayed")
    public void the_details_of_should_be_displayed(String string) {
        String displayedProductName = storePage.getDisplayedProductName(string);
        String expectedProductName = string;
        storePage.checkSimilarityOfText(displayedProductName, expectedProductName);
    }
}
