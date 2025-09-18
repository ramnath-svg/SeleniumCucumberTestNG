package TestRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
	@CucumberOptions (
	features = {"src/test/resources/Feature/homepage.feature"},
	glue = {"StepDefinitions","PageObjects" , "Hooks"}, 
	plugin = { "pretty", "html:target/chrome-report.html" }, 
	tags = "@addtocart" 
	)

public class CucumberTestRunnerChromeTest extends AbstractTestNGCucumberTests {
		
		@Parameters("browser")
		 @BeforeClass
		 public void setBrowser(@Optional("chrome") String browser) {
		        System.setProperty("browser", browser);
		        System.out.println("Running on browser: " + browser);
		    }


}
