package Hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void setUp() {
		
		String browser = System.getProperty("browser", "chrome");
		System.out.println("Initializing browser: " + browser);
		DriverFactory.initDriver(browser);
		DriverFactory.getDriver().get("https://www.saucedemo.com/v1/");

	}

	@After
	public void tearDown(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();

        if (scenario.isFailed()) {
            // Take screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define destination
            String screenshotName = scenario.getName().replaceAll(" ", "_") + ".png";
            File destination = new File("target/screenshots/" + screenshotName);

            try {
                Files.createDirectories(destination.getParentFile().toPath());
                Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Screenshot saved: " + destination.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Failed to save screenshot: " + e.getMessage());
            }
        }

        DriverFactory.quitDriver();
    }

}
