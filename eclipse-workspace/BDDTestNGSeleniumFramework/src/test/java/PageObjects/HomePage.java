package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage {

	WebDriver driver;
	@FindBy(xpath = "//div[contains(text(),'Products')]")
	private WebElement homepage_logo;

	@FindBy(xpath = "//div[contains(text(), 'Sauce Labs Backpack')]")
	private WebElement product_label;

	@FindBy(xpath = "//div[@class='inventory_list'][1]/div[1]/div[3]")
	private WebElement price_label;

	@FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")
	private WebElement lbl_addtocart;

	@FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
	private WebElement cart_count;

	@FindBy(xpath = "//button[@class='btn_secondary cart_button']")
	private WebElement remove_btn_on_cart;

	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")
	List<WebElement> cartItems;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomePageLogo() {
		return homepage_logo;
	}

	public WebElement getProductLabel() {
		return product_label;
	}

	public WebElement getPriceLabel() {
		return price_label;
	}

	public WebElement getAddTocartBtn() {
		return lbl_addtocart;
	}

	public WebElement getCartCountBtn() {
		return cart_count;
	}

	public WebElement getRemoveBtnOnCart() {
		return remove_btn_on_cart;
	}

	public List<WebElement> getCartItems() {
		return cartItems;
	}
}
