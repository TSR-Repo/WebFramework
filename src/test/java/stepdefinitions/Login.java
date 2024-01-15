package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
    WebDriver driver;

    @Given("a user is on the login page")
    public void a_user_is_on_the_login_page() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://framework.kanbanize.com/ctrl_login");
    }

    @When("the user enters their username as {string}")
    public void the_user_enters_their_username_as(String string) throws InterruptedException {
       WebElement emailField = driver.findElement(By.name("login_email"));
       emailField.sendKeys("jimac41864@tanlanav.com");
    }

    @When("the user enters their password as {string}")
    public void the_user_enters_their_password_as(String string) throws InterruptedException {
        WebElement passwordField = driver.findElement(By.name("login_password"));
        passwordField.sendKeys("TestSolutions100");
    }

    @When("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"form_login\"]/button"));
        loginBtn.click();
    }

    @Then("the user should be logged and redirected to their dashboard")
    public void the_user_should_be_logged_and_redirected_to_their_dashboard() throws InterruptedException {
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        String dashboardUrl = "https://framework.kanbanize.com/ctrl_dashboard";
        Assert.assertEquals(currentUrl, dashboardUrl);
        driver.quit();
    }
}
