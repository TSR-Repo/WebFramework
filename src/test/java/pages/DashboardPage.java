package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    By logoutBtn = By.linkText("Logout");

    public void logout() {
        getElement(logoutBtn).click();
    }
    
}
