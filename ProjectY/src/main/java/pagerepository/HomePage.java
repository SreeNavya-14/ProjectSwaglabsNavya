package pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// 1. WebElement Identification & Declaration

	@FindBy(xpath = "//div[text()='Sauce Labs Fleece Jacket']")
	private WebElement fourthproduct;

	@FindBy(id = "add-to-cart")
	private WebElement addtocartbtn_4;

	@FindBy(id = "back-to-products")
	private WebElement backtoproducts_4;

	@FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']")
	private WebElement thirdproduct;

	@FindBy(id = "add-to-cart")
	private WebElement addtocartbtn_3;

	@FindBy(id = "back-to-products")
	private WebElement backtoproducts_3;

	@FindBy(xpath = "//div[text()='Sauce Labs Bike Light']")
	private WebElement secondproduct;

	@FindBy(id = "add-to-cart")
	private WebElement addtocartbtn_2;

	@FindBy(id = "back-to-products")
	private WebElement backtoproducts_2;

	// Identify Shopping cart icon
	@FindBy(className = "shopping_cart_link")
	private WebElement carticon;

	// 2. WebElement Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// 3. WebElement Utilization
	public WebElement getfourthproduct() {
		return fourthproduct;
	}

	public WebElement getaddtocartbtn4() {
		return addtocartbtn_4;
	}
	
	public WebElement getbacktoproducts4() {
		return backtoproducts_4;
	}

	public WebElement getthirdproduct() {
		return thirdproduct;
	}

	public WebElement getaddtocartbtn3() {
		return addtocartbtn_3;
	}
	
	public WebElement getbacktoproducts3() {
		return backtoproducts_3;
	}


	public WebElement getsecondproduct() {
		return secondproduct;
	}

	public WebElement getaddtocartbtn2() {
		return addtocartbtn_2;
	}
	
	public WebElement getbacktoproducts2() {
		return backtoproducts_2;
	}


	public WebElement getcarticon() {
		return carticon;
	}

}