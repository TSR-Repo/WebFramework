package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import factory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
    WebDriver driver;

    @Given("a user is on is on home page")
    public void a_user_is_on_is_on_home_page() {
        driver = DriverManager.getDriver();
        driver.get("https://askomdch.com/account/");
    }

    @When("the user navigates to the account page")
    public void the_user_navigates_to_the_account_page() {
        WebElement accountPageLink = driver.findElement(By.linkText("Account"));
        accountPageLink.click();
    }

    @When("the user enters a username as {string}")
    public void the_user_enters_a_username_as(String string) {
        WebElement usernameRegField = driver.findElement(By.id("reg_username"));
        usernameRegField.sendKeys("Podew");
    }

    @When("the user enters a email as {string}")
    public void the_user_enters_a_email_as(String string) {
        WebElement passwordRegField = driver.findElement(By.id("reg_email"));
        passwordRegField.sendKeys("podew79407@grassdev.com");
    }

    @When("the user enters a password as {string}")
    public void the_user_enters_a_password_as(String string) {
        WebElement passwordRegField = driver.findElement(By.id("reg_password"));
        passwordRegField.sendKeys("password123");
    }

    @When("the user clicks on the Register button")
    public void the_user_clicks_on_the_register_button() {
        WebElement registerBtn = driver.findElement(By.name("register"));
        registerBtn.click();
    }

    @Then("the user should be registered and logged in")
    public void the_user_should_be_registered_and_logged_in() {
        String currentUrl = driver.getCurrentUrl();
        String accountPageUrl = "https://askomdch.com/account/";

        Assert.assertEquals(currentUrl, accountPageUrl);
    }
}
