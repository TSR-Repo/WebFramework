package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    By logoutBtnBy = By.linkText("Logout");
    By accountDetailsLinkBy = By.linkText("Account details");
    By accountPageLinkBy = By.linkText("Account");

    public void logout() {
        getElement(logoutBtnBy).click();
    }

    public void navigateToAccountDetails() {
        getElement(accountDetailsLinkBy).click();
    }

    public void navigateToAccountPage() {
        getElement(accountPageLinkBy).click();
    }
}
