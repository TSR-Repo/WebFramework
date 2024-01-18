package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductNameFromCart(String productName) {
        return getElement(By.linkText(productName)).getText();
    }
}
