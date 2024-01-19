package pages;

import static org.junit.Assert.assertTrue;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
    By orderProductsBy = By.name("orderby");
    By priceContainersBy = By.xpath("//a[text()='Add to cart']/preceding-sibling::span[@class='price']/span[@class='woocommerce-Price-amount amount']/bdi");

    public void navigateToStorePage() {
        getElement(storeLinkBy).click();
    }

    public void viewProduct(String productName) {
        getElement(By.xpath("//h2[text()='" + productName + "']")).click();
    }

    public String getDisplayedProductName(String productName) {
        return getElement(By.xpath("//h1[text()='" + productName + "']")).getText();
    }

    public void addProductToCart(String productName) {
        String rawPath = "//a[@aria-label='Add “" + productName + "” to your cart']";
        byte[] bytesPath = rawPath.getBytes(StandardCharsets.UTF_8);
        String pathUtf8Encoded = new String(bytesPath, StandardCharsets.UTF_8);
        By addTocartButtonBy = By.xpath(pathUtf8Encoded);
        getElement(addTocartButtonBy).click();
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

    public void orderProducts(String attribute) {
        selectFromDropdown(orderProductsBy, attribute);
    }

    public void checkOrderOfProductsByPrice() {
        List<WebElement> priceContainers = getElements(priceContainersBy);
        List<Double> productPrices = new ArrayList<>();
        
        for(WebElement priceContainer : priceContainers) {
            String priceString = priceContainer.getText();
            String cleanedPriceString = priceString.replaceAll("[^\\d.]", "");
            if (!cleanedPriceString.isEmpty()) {
                try {
                    Double price = Double.parseDouble(cleanedPriceString);
                    productPrices.add(price);
                } catch (NumberFormatException e) {
                    
                }
            }
        }

        for(int i = 1; i < productPrices.size(); i++) {
            assertTrue(productPrices.get(i) > productPrices.get(i - 1));
        }
    }
}
