import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features/authentication",
        "src/test/resources/features/store" }, glue = { "stepdefinitions", "hooks",
                "pages" }, plugin = { "pretty" }, tags = "@showcase")
public class RunnerTest {

}