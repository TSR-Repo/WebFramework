package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDetailsPage extends BasePage{

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    By firstNameBy = By.id("account_first_name");
    By lastNameBy = By.id("account_last_name");
    By displayNameBy = By.id("account_display_name");
    By saveChangesBy = By.name("save_account_details");
    By successfulProfileUpdateNoticeContainerBy = By.xpath("//div[@role='alert']");


    public void updateFirstName(String newFirstName) {
        clearField(firstNameBy);
        addTextToInput(firstNameBy, newFirstName);
    }
    
    public void updateLastName(String newLastName) {
        clearField(lastNameBy);
        addTextToInput(lastNameBy, newLastName);
    }

    public void updateDisplayName(String newDisplayName) {
        clearField(displayNameBy);
        addTextToInput(displayNameBy, newDisplayName);
    }

    public void saveChangesOnProfile() {
        getElement(saveChangesBy).click();
    }

    public void isProfileUpdateSuccessful(String expectedNotice) {
        String successfulProfileUpdateNotice = getElement(successfulProfileUpdateNoticeContainerBy).getText();
        checkSimilarityOfText(expectedNotice, successfulProfileUpdateNotice);
    }
}
