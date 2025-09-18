package TestRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/Feature/homepage.feature" }, glue = { "StepDefinitions",
		"PageObjects", "Hooks" }, plugin = { "pretty", "html:target/html.report.html" },
		tags = "@removecart")

public class CucumberTestRunnerCartRemove extends AbstractTestNGCucumberTests {

	@Parameters("browser")
	 @BeforeClass
	 public void setBrowser(String browser) {
	        System.setProperty("browser", browser);
	    }

}
