package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import factory.DriverManager;
import io.cucumber.java.en.*;

public class Logout {
	private WebDriver driver;

	@Given("a user is logged in")
	public void a_user_is_logged_in() {
		driver = DriverManager.getDriver();
		driver.get("https://askomdch.com/account/");
		WebElement usernameLoginField = driver.findElement(By.id("username"));
		usernameLoginField.sendKeys("wewison900@tsderp.com");
		WebElement passwordLoginField = driver.findElement(By.id("password"));
		passwordLoginField.sendKeys("password");
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
	}

	@Given("the user is on account page")
	public void the_user_is_on_account_page() {

		WebElement accountHeader = driver.findElement(By.xpath("//h1[text()=\"Account\"]"));
		String expectedHeader = "Account";
		String actualHeader = accountHeader.getText();
		Assert.assertEquals(actualHeader, expectedHeader);
	}

	@When("the user clicks on Logout link")
	public void the_user_clicks_on_logout_link() {
		WebElement logoutLink = driver.findElement(By.linkText("Logout"));
		logoutLink.click();

	}

	@Then("the user should be logged out")
	public void the_user_should_be_logged_out() {
		WebElement loginText = driver.findElement(By.xpath("//h2[text()=\"Login\"]"));
		String expectedloginText = "Login";
		String actualloginText = loginText.getText();
		Assert.assertEquals(actualloginText, expectedloginText);
		driver.quit();
	}

}
