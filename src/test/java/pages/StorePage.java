package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

    public StorePage(WebDriver driver) {
        super(driver);
    }

    By storeLinkBy = By.linkText("Store");


    public void navigateToStorePage() {
        getElement(storeLinkBy).click();
    }

    public void viewProduct(String productName) {
        getElement(By.xpath("//h2[text()='" + productName + "']")).click(); //"h2[text()='Blue Jeans']"
    }

    public String getDisplayedProductName(String productName) {
        return getElement(By.xpath("//h1[text()='" + productName + "']")).getText();
    }
    
}
