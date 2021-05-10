package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;	
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		strict = true,
		features = {"src/test/resources/Features/Chrome_successflow.feature"},
		glue = {"StepDefinitions"},
		tags = "@ChromeBrowser",
		plugin = {"json:target/cucumber.json"},
		monochrome = true
		)
public class ChromeTestRunner {

}
