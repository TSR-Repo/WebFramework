package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage{
    @FindBy(id = "username") private WebElement usernameLoginField;
    @FindBy(id = "password") private WebElement passwordLoginField;
    @FindBy(name = "login") private WebElement loginBtn;
    @FindBy(css = "ul[role='alert'] li") private WebElement actualErrorMessage;


    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }
    
}
