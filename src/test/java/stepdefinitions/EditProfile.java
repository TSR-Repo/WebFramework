package stepdefinitions;

import factory.DriverManager;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountDetailsPage;
import pages.AuthenticationPage;
import pages.DashboardPage;

public class EditProfile {
    WebDriver driver = DriverManager.getDriver();
    AccountDetailsPage accDetailsPage = new AccountDetailsPage(driver);

    @Given("a user is logged in")
    public void a_user_is_logged_in() {
        new AuthenticationPage(driver).login("wewison900@tsderp.com", "password");
    }

    @When("the user clicks on the Account details link")
    public void the_user_clicks_on_the_account_details_link() {
        new DashboardPage(driver).navigateToAccountDetails();
    }

    @When("the user adds {string}, {string}, and {string}")
    public void the_user_fills_the_form(String string, String string2, String string3) {
        accDetailsPage.updateFirstName(string);
        accDetailsPage.updateLastName(string2);
        accDetailsPage.updateDisplayName(string3);
    }

    @When("the user clicks on Save Changes")
    public void the_user_clicks_on_save_changes() throws InterruptedException {
        accDetailsPage.saveChangesOnProfile();
    }

    @Then("the update should be successful with message {string}")
    public void the_user_should_be_notified_about_the_updates(String string) {
        accDetailsPage.isProfileUpdateSuccessful(string);
    }
}
