package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepdefinitions"},
        dryRun = false,
        tags = "@Smoke",
        plugin = {"pretty", "html:target/test-output.html"},
        monochrome = true,
        publish = true
)
@RunWith(Cucumber.class)
public class testRunner {
}
