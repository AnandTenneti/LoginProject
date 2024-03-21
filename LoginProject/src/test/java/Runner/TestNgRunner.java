package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/features/",
        glue = "stepdefinitions",
        dryRun = false,
        monochrome = true,
        tags="@Smoke",
        plugin = {"pretty", "html:target/test-output.html",
                "timeline:test-classes/"}
)
public class TestNgRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
