package stepdefinitions;

import org.openqa.selenium.WebDriver;
import factory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AuthenticationPage;

public class Login {
    private WebDriver driver = DriverManager.getDriver();
    AuthenticationPage authPage = new AuthenticationPage(driver);

    @Given("a user in on the login page")
    public void the_user_in_on_the_login_page() {
        authPage.openUrl("https://askomdch.com/account/");
    }

    @When("the user enters the username as {string}")
    public void the_user_enters_the_username_as(String string) {
        authPage.enterUsername(string);
    }

    @When("the user enters the password as {string}")
    public void the_user_enters_the_password_as(String string) {
        authPage.enterPassword(string);
    }

    @When("the user clicks on login button")
    public void the_user_clicks_on_login_button() {
        authPage.clickLoginButton();
    }

    @Then("the login should fail with the message as {string}")
    public void the_login_should_fail_with_the_message_as(String string) {
        String actualErrorMessage = authPage.getErrorMessageText();
        String expectedErrorMessage = string;
        authPage.doErrorsMatch(actualErrorMessage, expectedErrorMessage);
    }

    @Then("the user should be logged in and redirected to their account page")
    public void user_should_be_logged_in() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://askomdch.com/account/";
        authPage.checkSimilarityOfText(currentUrl, expectedUrl);
    }
}
