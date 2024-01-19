package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By firstNameFieldBy = By.name("billing_first_name");
    By lastNameFieldBy = By.id("billing_last_name");
    By companyBy = By.id("billing_company");
    By regionDropdownBy = By.xpath("//span[@aria-label='Country / Region']");
    By regionDropdownItemsBy = By.xpath("//li[contains(@id, 'select2-billing_country')]");
    By firstStreetAddressFieldBy = By.id("billing_address_1");
    By secondStreetAddressFieldBy = By.id("billing_address_2");
    By billingTownFieldBy = By.id("billing_city");
    By postCodeFieldBy = By.id("billing_postcode");
    By billingPhoneFieldBy = By.id("billing_phone");
    By placeOrderBtnBy = By.id("place_order");
    By successfulOrderNoticeBy = By.xpath("//p[contains@class, 'woocommerce-thankyou-order-received']");


    public void enterBillingFirstName(String firstName) {
        WebElement firstNameField = getElement(firstNameFieldBy);
        if(firstNameField.getAttribute("value") == "") {
            addTextToInput(firstNameFieldBy, firstName);
        }
    }

    public void enterBillingLastName(String lastName) {
        WebElement firstNameField = getElement(lastNameFieldBy);
        if(firstNameField.getAttribute("value") == "") {
            addTextToInput(lastNameFieldBy, lastName);
        }
    }

    public void enterCompanyName(String companyName) {
        WebElement companyField = getElement(companyBy);
        if (companyField.getAttribute("value") == "") {
            addTextToInput(companyBy, companyName);
        }
    }

    public void selectRegion(String region) {
        selectFromPseudoDropdown(regionDropdownBy, regionDropdownItemsBy, region);
    }

    public void enterFirstStreetAddress(String firstStreetAddress) {
        if(getElement(firstStreetAddressFieldBy).getAttribute("value") == "")
            addTextToInput(firstStreetAddressFieldBy, firstStreetAddress);
    }

    public void enterSecondStreetAddress(String seconStreetAddress) {
        if(getElement(secondStreetAddressFieldBy).getAttribute("value") == "")
            addTextToInput(secondStreetAddressFieldBy, seconStreetAddress);
    }

    public void enterBillingTown(String town) {
        if(getElement(billingTownFieldBy).getAttribute("value") == "")
            addTextToInput(billingTownFieldBy, town);
    }

    public void enterBillingPostCode(String postCode) {
        if(getElement(postCodeFieldBy).getAttribute("value") == "")
            addTextToInput(postCodeFieldBy, postCode);
    }

    public void enterBillingPhone(String phoneNumber) {
        if(getElement(billingPhoneFieldBy).getAttribute("value") == "")
            addTextToInput(billingPhoneFieldBy, phoneNumber);
    }

    public void placeOrder() {
        getElement(placeOrderBtnBy).click();
    }

    public void isOrderSuccessful(String noticeMessage) {
        String successfulOrderNotice = getElement(successfulOrderNoticeBy).getText();
        checkSimilarityOfText(successfulOrderNotice, noticeMessage);
    }
}
