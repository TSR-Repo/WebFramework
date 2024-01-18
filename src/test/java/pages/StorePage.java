package pages;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StorePage extends BasePage {

    public StorePage(WebDriver driver) {
        super(driver);
    }

    By storeLinkBy = By.linkText("Store");
    By viewCartLinkby = By.xpath("//a[@title='View your shopping cart']");
    By searchFieldBy = By.id("woocommerce-product-search-field-0");
    By searchBtnBy = By.xpath("//button[@type='submit']");
    By productsTitleContainersBy = By.className("woocommerce-loop-product__title");

    public void navigateToStorePage() {
        getElement(storeLinkBy).click();
    }

    public void viewProduct(String productName) {
        getElement(By.xpath("//h2[text()='" + productName + "']")).click(); //"h2[text()='Blue Jeans']"
    }

    public String getDisplayedProductName(String productName) {
        return getElement(By.xpath("//h1[text()='" + productName + "']")).getText();
    }

    public void addProductToCart(String productName) {
        //a[@aria-label='Add “Anchor Bracelet” to your cart']
        getElement(By.xpath("//a[@aria-label='Add “" + productName + "” to your cart']")).click();
    }

    public void viewCart() {
        getElement(viewCartLinkby).click();
    }

    public void enterSearchTerm(String searchTerm) {
        getElement(searchFieldBy).sendKeys(searchTerm);
    }

    public void searcProduct() {
        getElement(searchBtnBy).click();
    }

    public void checkSearchResults(String searchTerm) {
        List<WebElement> productsHeadersContainers = getElements(productsTitleContainersBy);
        List<String> productNames = new ArrayList<>();  
        for(WebElement headerContainer : productsHeadersContainers) {
            productNames.add(headerContainer.getText());
        }

        for(String productName : productNames) {
            assertTrue(productName.contains(searchTerm));
        }
    }
}
