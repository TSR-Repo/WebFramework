package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public String getElementText(By locator) {
        return getElement(locator).getText();
    }

    public void addTextToInput(By locator, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void checkSimilarityOfText(String text1, String text2) {
        Assert.assertEquals(text1, text2);
    }

    public List<WebElement> getElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements;
    }

    public void selectFromDropdown(By locator, String attribute) {
        WebElement dropdownElement = getElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(attribute);
    }

    public void selectFromPseudoDropdown(By dropdownLocator, By pseudoDropdownItemsLocator, String attribute) {
        getElement(dropdownLocator).click();
        List<WebElement> optionsList = getElements(pseudoDropdownItemsLocator);
        for (WebElement option : optionsList) {
            if(option.getText().contains(attribute)) {
                option.click();
                break;
            }
        }
    }

    
}
