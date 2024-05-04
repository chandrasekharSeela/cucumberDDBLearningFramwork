package RunnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


//@RunWith(Cucumber.class)
@CucumberOptions( plugin = "html:target/reports.html",
        features = "src/main/resources/featureFiles",
        glue = "StepDefinations")

public class RunnerTest extends AbstractTestNGCucumberTests {
}
