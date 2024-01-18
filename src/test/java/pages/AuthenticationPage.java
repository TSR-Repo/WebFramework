package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends BasePage {
    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    By usernameLoginField = By.id("username");
    By passwordLoginField = By.id("password");
    By loginBtnBy = By.name("login");
    By errorMessageContainerBy = By.cssSelector("ul[role='alert'] li");

    public void enterUsername(String username) {
        addTextToInput(usernameLoginField, username);
    }

    public void enterPassword(String password) {
        addTextToInput(passwordLoginField, password);
    }

    public  void clickLoginButton() {
        getElement(loginBtnBy).click();
    }

    public String getErrorMessageText() {
        return getElement(errorMessageContainerBy).getText();
    }

    public void doErrorsMatch(String actualErrorMessage, String expectedErrorMessage) {
        checkSimilarityOfText(actualErrorMessage, expectedErrorMessage);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
