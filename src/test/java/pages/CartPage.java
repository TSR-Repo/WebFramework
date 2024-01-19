package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By proceedToCheckoutBy = By.className("wc-proceed-to-checkout");

    public String getProductNameFromCart(String productName) {
        return getElement(By.linkText(productName)).getText();
    }

    public void proceedToCheckout() {
        getElement(proceedToCheckoutBy).click();
    }
}
