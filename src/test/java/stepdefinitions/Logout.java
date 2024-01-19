package stepdefinitions;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import factory.DriverManager;
import io.cucumber.java.en.*;
import pages.AuthenticationPage;
import pages.DashboardPage;

public class Logout {
	private WebDriver driver = DriverManager.getDriver();
	DashboardPage dashPage = new DashboardPage(driver);

	// @Given("a user is logged in")
	// public void a_user_is_logged_in() {
	// 	new AuthenticationPage(driver).login("wewison900@tsderp.com", "password");
	// }

	@Given("the user is on account page")
	public void the_user_is_on_account_page() {
		dashPage.navigateToAccountPage();
	}

	@When("the user clicks on Logout link")
	public void the_user_clicks_on_logout_link() {
		dashPage.logout();
	}

	@Then("the user should be logged out")
	public void the_user_should_be_logged_out() throws NoSuchElementException {
		new AuthenticationPage(driver).isUserLoggedOut();
	}
}
