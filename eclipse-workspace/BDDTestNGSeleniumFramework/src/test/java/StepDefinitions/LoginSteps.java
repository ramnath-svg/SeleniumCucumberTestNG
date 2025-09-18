package StepDefinitions;

import org.openqa.selenium.WebDriver;

import PageObjects.LoginPage;
import Utils.DriverFactory;
import Utils.SeleniumUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private WebDriver driver = DriverFactory.getDriver();
	private LoginPage loginpage;
	private SeleniumUtils utils;

	public LoginSteps() {

		utils = new SeleniumUtils(driver);
		loginpage = new LoginPage(driver);
	}

	@Given("User is on login page")
	public void user_is_on_login_page() {

		utils.elementIsDisplayed(loginpage.getUsernameText());
		utils.elementIsDisplayed(loginpage.getPasswordText());
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String username, String password) {

		utils.enterText(loginpage.getUsernameText(), username);
		utils.enterText(loginpage.getPasswordText(), password);

	}

	@And("clicks on login button")
	public void clicks_on_login_button() {

		utils.clickElement(loginpage.getLoginButton());

	}

	@Then("user should navigated to home page")
	public void user_should_navigated_to_home_page() {

	}

}
