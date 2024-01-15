package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
    WebDriver driver;

    @Given("a user in on the login page")
    public void the_user_in_on_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/account/");
    }

    @When("the user enters the username as {string}")
    public void the_user_enters_the_username_as(String string) {
        WebElement usernameLoginField = driver.findElement(By.id("username"));
        usernameLoginField.sendKeys(string);
    }

    @When("the user enters the password as {string}")
    public void the_user_enters_the_password_as(String string) {
        WebElement passwordLoginField = driver.findElement(By.id("password"));
        passwordLoginField.sendKeys(string);
    }

    @When("the user clicks on login button")
    public void the_user_clicks_on_login_button() {
        WebElement loginBtn = driver.findElement(By.name("login"));
        loginBtn.click();
    }

    @Then("the login should fail with the message as {string}")
    public void the_login_should_fail_with_the_message_as(String string) {
        String actualErrorMessage = driver.findElement(By.cssSelector("ul[role='alert'] li")).getText();
        String expectedErrorMessage = string;
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

        driver.quit();
    }

    @Then("the user should be logged in and redirected to their account page")
    public void user_should_be_logged_in() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://askomdch.com/account/";

        Assert.assertEquals(expectedUrl, currentUrl);

        driver.quit();
    }
}
