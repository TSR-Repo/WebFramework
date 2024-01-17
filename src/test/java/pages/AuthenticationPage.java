package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {
    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    By usernameLoginField = By.id("username");
    By passwordLoginField = By.id("password");
    By loginBtn = By.name("login");

    public void enterUsername(String username) {
        addTextToInput(usernameLoginField, username);
    }

    public void enterPassword(String password) {
        addTextToInput(passwordLoginField, password);
    }

    public void doErrorsMatch(String actualErrorMessage, String expectedErrorMessage) {
        checkSimilarityOfText(actualErrorMessage, expectedErrorMessage);
    }
}
