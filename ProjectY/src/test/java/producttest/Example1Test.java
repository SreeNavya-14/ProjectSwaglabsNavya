package producttest;

import java.time.Duration;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseConfig;
import pagerepository.CartPage;
import pagerepository.CheckoutOverviewPage;
import pagerepository.CheckoutPage;
import pagerepository.HomePage;
@Listeners(listenerlibrary.ListenerImplementation.class)

public class Example1Test extends BaseConfig {

	@Test(groups="RT",priority = 1, invocationCount = 1,enabled = true,dataProvider ="CheckoutInfo" )
	public void orderProducts(String FirstName,String LastName,String ZipCode) {
		
		Reporter.log(FirstName,true);
		Reporter.log(LastName,true);
		Reporter.log(ZipCode,true);

		// Wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Verify Home Page
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		// Create an object for Home page
		HomePage hpobj = new HomePage(driver);

		// Use the webElement from POM class

		// Click on the fourth product
		hpobj.getfourthproduct().click();
		// Verify Add To Cart button is Displayed & is Enabled
		Assert.assertTrue(hpobj.getaddtocartbtn4().isDisplayed() && hpobj.getaddtocartbtn4().isEnabled());
		// Click on Add To Cart button
		hpobj.getaddtocartbtn4().click();
		// Verify Back To Products link is Displayed & is Enabled
		Assert.assertTrue(hpobj.getbacktoproducts4().isDisplayed() && hpobj.getbacktoproducts4().isEnabled());
		// Click on Back To Products
		hpobj.getbacktoproducts4().click();

		// Click on the Third product
		hpobj.getthirdproduct().click();
		// Verify Add To Cart button is Displayed & is Enabled
		Assert.assertTrue(hpobj.getaddtocartbtn3().isDisplayed() && hpobj.getaddtocartbtn3().isEnabled());
		// Click on Add To Cart button
		hpobj.getaddtocartbtn3().click();
		// Verify Back To Products link is Displayed & is Enabled
		Assert.assertTrue(hpobj.getbacktoproducts4().isDisplayed() && hpobj.getbacktoproducts4().isEnabled());
		// Click on Back To Products
		hpobj.getbacktoproducts3().click();

		// Click on the Second product
		hpobj.getsecondproduct().click();
		// Verify Add To Cart button is Displayed & is Enabled
		Assert.assertTrue(hpobj.getaddtocartbtn2().isDisplayed() && hpobj.getaddtocartbtn2().isEnabled());
		// Click on Add To Cart button
		hpobj.getaddtocartbtn2().click();
		// Verify Back To Products link is Displayed & is Enabled
		Assert.assertTrue(hpobj.getbacktoproducts2().isDisplayed() && hpobj.getbacktoproducts2().isEnabled());
		// Click on Back To Products
		hpobj.getbacktoproducts2().click();

		// Verify Cart Icon is Displayed & is Enabled
		Assert.assertTrue(hpobj.getcarticon().isDisplayed() && hpobj.getcarticon().isEnabled());
		// Click on Cart Icon
		hpobj.getcarticon().click();

		// Verify Cart Page
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		// Create an object for Cart page
		CartPage cpobj = new CartPage(driver);

		// Use the webElement from POM class

		// Verify Checkout button is Displayed & is Enabled
		Assert.assertTrue(cpobj.getcheckoutbtn().isDisplayed() && cpobj.getcheckoutbtn().isEnabled());
		// Click on the CheckOut button
		cpobj.getcheckoutbtn().click();

		// Verify Checkout Page
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		// Create an object for CheckOut page
		CheckoutPage chkobj = new CheckoutPage(driver);

		// Verify First Name text field is Displayed & Is Enabled
		Assert.assertTrue(chkobj.getfirstname().isDisplayed() && chkobj.getfirstname().isEnabled());
		// Enter the First Name
		chkobj.getfirstname().sendKeys(FirstName);
		// Verify Last Name text field is Displayed & Is Enabled
		Assert.assertTrue(chkobj.getlastname().isDisplayed() && chkobj.getlastname().isEnabled());
		// Enter Last Name
		chkobj.getlastname().sendKeys(LastName);
		// Verify Zipcode text field is Displayed & Is Enabled
		Assert.assertTrue(chkobj.getzipcode().isDisplayed() && chkobj.getzipcode().isEnabled());
		// Enter Zipcode
		chkobj.getzipcode().sendKeys(ZipCode);
		//chkobj.getzipcode().sendKeys(String.valueOf(ZipCode));

		
		// Verify Continue button is Displayed &is Enabled
		Assert.assertTrue(chkobj.getcontinuebtn().isDisplayed() && chkobj.getcontinuebtn().isEnabled());
		// Click on Continue button
		chkobj.getcontinuebtn().click();

		// Verify Checkout Complete Page
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		// Create an object for CheckOut-Overview page
		CheckoutOverviewPage ckovobj = new CheckoutOverviewPage(driver);

		// Verify Finish button is Displayed &is Enabled
		Assert.assertTrue(ckovobj.getfinishbtn().isDisplayed() && ckovobj.getfinishbtn().isEnabled());

		// Click on Finish button
		ckovobj.getfinishbtn().click();
		
		//Assert.fail();

	}

}