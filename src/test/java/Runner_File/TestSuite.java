package Runner_File;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},features = "src\\test\\resources\\Features\\25_My_medicare_claims_positive_scenarios.feature", glue= {"StepDefinitions"})
public class TestSuite {
}
