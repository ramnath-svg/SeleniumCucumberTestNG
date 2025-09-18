package StepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import Utils.DriverFactory;
import Utils.SeleniumUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

	private WebDriver driver = DriverFactory.getDriver();
	private LoginPage loginpage;
	private HomePage homepage;
	private SeleniumUtils utils;

	public HomePageSteps() {
		utils = new SeleniumUtils(driver);
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
	}

	@Given("user is logged in with {string} and {string}")
	public void user_is_logged_in_with_and(String username, String password) {
		utils.enterText(loginpage.getUsernameText(), username);
		utils.enterText(loginpage.getPasswordText(), password);
		utils.clickElement(loginpage.getLoginButton());
	}

	@And("user is on the home page")
	public void user_is_on_the_home_page() {
		assertEquals(homepage.getHomePageLogo().getText(), "Products");
		System.out.println("Product: " + homepage.getProductLabel().getText());
		System.out.println("Price: " + homepage.getPriceLabel().getText());
	}

	@When("user selects product")
	public void user_selects_product() {
		assertEquals(homepage.getProductLabel().getText(), "Sauce Labs Backpack");
	}

	@And("clicks on Add to cart")
	public void clicks_on_add_to_cart() {
		utils.clickElement(homepage.getAddTocartBtn());
	}

	@Then("product {string} should be added to cart")
	public void product_should_be_added_to_cart(String expectedProduct) {
		utils.clickElement(homepage.getCartCountBtn());
		assertEquals(homepage.getProductLabel().getText(), expectedProduct);
	}

	@When("user clicks on Remove from cart")
	public void user_clicks_on_remove_from_cart() {
		//utils.waitForElement(homepage.getRemoveBtnOnCart());
		//utils.clickElement(homepage.getRemoveBtnOnCart());
	}

	@Then("{string} should be removed from cart")
	public void should_be_removed_from_cart(String removedProduct) {
		//utils.isProductRemoved(homepage.getCartItems(), removedProduct);
	}
}
