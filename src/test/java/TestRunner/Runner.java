package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = ".//Features/Student.feature",
               glue = "stepDefination",
                dryRun = false,
                monochrome = true,
                plugin = {"pretty","html:test-output"}
                //tags= "@sanity,@regression"
        )
public class Runner {
}
