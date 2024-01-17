import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/authentication", glue = {"stepdefinitions", "hooks"}, plugin = {"pretty"}, tags = "@log")
public class RunnerTest {

}