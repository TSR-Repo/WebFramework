package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.*;
import io.cucumber.java.en.*;

public class Logout {
WebDriver driver; 
	@Given("a user is logged in")
	public void a_user_is_logged_in() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://askomdch.com/account/");
		WebElement usernameLoginField = driver.findElement(By.id("username"));
		usernameLoginField.sendKeys("podew79407@grassdev.com");
		WebElement passwordLoginField = driver.findElement(By.id("password"));
		passwordLoginField.sendKeys("password123");
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
