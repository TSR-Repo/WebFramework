package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    By logoutBtnBy = By.linkText("Logout");
    By headerBy = By.xpath("//h1[text()='Account']");

    public void logout() {
        getElement(logoutBtnBy).click();
    }

    public String getPageHeaderText() {
       return getElement(headerBy).getText();
    }
}
