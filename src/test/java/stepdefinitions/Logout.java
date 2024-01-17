package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import factory.DriverManager;
import io.cucumber.java.en.*;
import pages.DashboardPage;

public class Logout {
	private WebDriver driver = DriverManager.getDriver();
	DashboardPage dashPage = new DashboardPage(driver);

	@Given("a user is logged in")
	public void a_user_is_logged_in() {
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
		String actualAccountPageHeaderText = dashPage.getPageHeaderText();
		String expectedPageHeaderText = "Account";
		dashPage.checkSimilarityOfText(actualAccountPageHeaderText, expectedPageHeaderText);
	}

	@When("the user clicks on Logout link")
	public void the_user_clicks_on_logout_link() {
		dashPage.logout();
	}

	@Then("the user should be logged out")
	public void the_user_should_be_logged_out() {
		WebElement loginText = driver.findElement(By.xpath("//h2[text()=\"Login\"]"));
		String expectedloginText = "Login";
		String actualloginText = loginText.getText();
		dashPage.checkSimilarityOfText(expectedloginText, actualloginText);
	}
}
