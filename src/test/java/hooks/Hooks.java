package hooks;

import org.openqa.selenium.WebDriver;

import factory.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.BasePage;

public class Hooks {
    private WebDriver driver;
    @Before
    public void setup() {
        driver = DriverManager.initializeDriver(System.getProperty("browser", "chrome"));
        new BasePage(driver).openUrl("https://askomdch.com/account/");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
