package hooks;

import org.openqa.selenium.WebDriver;

import factory.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private WebDriver driver;
    @Before
    public void setup() {
        driver = DriverManager.initializeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
