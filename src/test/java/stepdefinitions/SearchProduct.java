package stepdefinitions;

import org.openqa.selenium.WebDriver;

import factory.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.StorePage;

public class SearchProduct {
    WebDriver driver = DriverManager.getDriver();
    StorePage storePage = new StorePage(driver);

    @When("the user enters a {string}")
    public void the_user_enters_a(String string) {
        storePage.enterSearchTerm(string);
    }

    @When("the user clicks on the search button")
    public void the_user_clicks_on_the_search_button() {
        storePage.searcProduct();
    }

    @Then("the products containing the {string} should be displayed")
    public void the_products_containing_the_should_be_displayed(String string) {
        storePage.checkSearchResults(string);
    }
}
