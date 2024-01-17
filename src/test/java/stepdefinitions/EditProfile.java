package stepdefinitions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditProfile {
  WebDriver driver;

    @Given("A user is logged in")
public void a_user_is_logged_in() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/account/");
        WebElement usernameLoginField = driver.findElement(By.id("username"));
		usernameLoginField.sendKeys("vefavo5577@wentcity.com");
		WebElement passwordLoginField = driver.findElement(By.id("password"));
		passwordLoginField.sendKeys("password123");
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();

}
@When("the user clicks on the Account details link")
public void the_user_clicks_on_the_account_details_link() {
    WebElement AccountDetails = driver.findElement(By.linkText("Account details"));
    AccountDetails.click();

    
}
@When("the user fills the form")
public void the_user_fills_the_form() {
    WebElement firstName = driver.findElement(By.id("account_first_name"));
    firstName.sendKeys("Adeba");
    WebElement lastName = driver.findElement(By.id("account_last_name"));
    lastName.sendKeys("Joy");
    //WebElement displayName = driver.findElement(By.id("account_display_name"));
    //displayName.sendKeys("Podew");
    //WebElement email = driver.findElement(By.id("account_email"));
    //email.sendKeys("podew79407@grassdev.com");
    WebElement currentPassword = driver.findElement(By.id("password_current"));
    currentPassword.sendKeys("password123");
    WebElement newPassword = driver.findElement(By.id("password_1"));
    newPassword.sendKeys("password1234");
    WebElement confirmPassword = driver.findElement(By.id("password_2"));
    confirmPassword.sendKeys("password1234");

}
@When("the user clicks on Save Changes")
public void the_user_clicks_on_save_changes() throws InterruptedException {
   WebElement savechange = driver.findElement(By.name("save_account_details"));
   savechange.click();


} 

    @Then("the user should be notified about the updates")
    public void the_user_should_be_notified_about_the_updates() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
			WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
			//Thread.sleep(100000);
			String alertMessage = alert.getText();
			System.out.println(alertMessage);
			driver.close();
    }

    
}
