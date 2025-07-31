package genericLibrary;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pagerepository.CheckoutCompletePage;
import pagerepository.LoginPage;

public class BaseConfig {
	public static WebDriver staticdriver;

	public WebDriver driver;
	
	public String url;
	public String username;
	public String password;
	
	public String FirstName;
	public String LastName;
	public String ZipCode;
	 public ExtentReports report;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	@BeforeTest
	public void ReportSetup() {
		//Create the SparkReport
		 spark = new ExtentSparkReporter("./AdvanceReports/report.html");
		// Configure the SparkReport Information
		spark.config().setDocumentTitle("Regresstion testing for the SwagLabs");
		spark.config().setReportName("RegresstionSuite");
		spark.config().setTheme(Theme.DARK);
		
		//Create Extent Report
		 report = new ExtentReports();
		 // Attach the Spark Report and ExtentReport
		 report.attachReporter(spark);
		 //Configure the System Information in Extent Report
		 report.setSystemInfo("DeviceName:", "Sree");
		 report.setSystemInfo("OperatingSystem:", "WINDOWS ");
		 report.setSystemInfo("Browser:", "Chrome");
		 report.setSystemInfo("BrowserVersion:", "chrome-138.0.7204.169");
	}
	
	@AfterTest
	public void ReportTerminate() {
		
		 //Flush the Re[port
		 report.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

    @Parameters("BrowserName")
	@BeforeClass
	public void browserSetup(String browser ) {
		
		//String browser = "chrome";
    	
    	//Open the Browser
    	driver=WebDriverLibrary.openBrowser(browser);
    	staticdriver=driver;
    	
    	
    	//Maximize the Browser
    	WebDriverLibrary.maximizeBrowser();
    	
    	//Wait Statement
    	WebDriverLibrary.WaitStatement();
    	
    	//Navigate to the Application via Url
    	WebDriverLibrary.navToApp(PropertiesLibrary.readData("url"));
    	
    	//Verify the Page Using Title
		Assert.assertEquals( "Swag Labs",driver.getTitle());

		
		/*
		 * url=PropertiesLibrary.readData("url");
		 * 
		 * String browsername = "edge";
		 * 
		 * if (browsername.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); }
		 * else if (browsername.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
		 * else if (browsername.equalsIgnoreCase("firefox")) { driver = new
		 * FirefoxDriver(); } else { System.out.println("Invalid browser name"); }
		 * 
		 * // Maximize the Browser driver.manage().window().maximize();
		 * 
		 * // Wait Statement
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 * 
		 * // Navigate to the application via URL driver.get(url);
		 */
		Reporter.log("Browser setup is done", true);

	}

	@BeforeMethod
	public void LogIn() {
		
		
		//Wait Statement
    	WebDriverLibrary.WaitStatement();
    	
    	//Create an Object For LoginPage
    	LoginPage loginobj = new LoginPage(driver);
    	
    	//Validate the UserName TextFeild
    	Assert.assertTrue(loginobj.getusernametextfield().isDisplayed());
    	
    	//Perform an Action
    	//Enter the UserName in the UserName TextFeld
    	WebDriverLibrary.enterTheData(loginobj.getusernametextfield(),PropertiesLibrary.readData("username"));
    	
    	//Enter the Password TextFeld
    	WebDriverLibrary.enterTheData(loginobj.getpasswordtextfield(),PropertiesLibrary.readData("password"));
    	
    	
    	//Validate the login Button
        Assert.assertTrue(loginobj.getloginbutton().isDisplayed());	
    	
    	//Click on login Button
    	WebDriverLibrary.elementClick(loginobj.getloginbutton());
    	
    	
    	
    	
    	
		
		/*
		 * username=PropertiesLibrary.readData("username");
		 * password=PropertiesLibrary.readData("password");
		 * 
		 * FirstName=ExcelLibrary.readsingledata("CheckoutInfo",1,0);
		 * LastName=ExcelLibrary.readsingledata("CheckoutInfo",1,1); ZipCode =
		 * ExcelLibrary.readsingledata("CheckoutInfo", 1, 2);
		 * 
		 * 
		 * 
		 * // Verify Login page System.out.println("title is:" + driver.getTitle());
		 * 
		 * // Create an object for LoginPage LoginPage lpobj = new LoginPage(driver);
		 * 
		 * // Use the webElement from POM class
		 * 
		 * // Perform Login // Enter UserName in UserName Textfield
		 * lpobj.getusernametextfield().sendKeys(username);
		 * 
		 * // Enter UserName in UserName Textfield
		 * lpobj.getpasswordtextfield().sendKeys(password);
		 * 
		 * // Enter UserName in UserName Textfield lpobj.getloginbutton().click();
		 */

		Reporter.log("Login successfully", true);

	}

	@AfterMethod
	public void Logout() {
		
		//Wait Statement
    	WebDriverLibrary.WaitStatement();
    	
    	//Create an Object For LogoutPage
    	  CheckoutCompletePage logoutobj = new CheckoutCompletePage(driver);
    	
    	
    	//Validate the Logout Menu
    	Assert.assertTrue(logoutobj.getmenubar().isDisplayed());	
     	
    	 
    	
    	//Click on Logout Menu
    	WebDriverLibrary.elementClick(logoutobj.getmenubar());
    	
    	
    	//Validate the Logout Link
    	// Assert.assertTrue(logoutobj.getlogout().isDisplayed());	
     	
    	
    	//Click on Logout Button
    	WebDriverLibrary.elementClick(logoutobj.getlogout());
		
		
		

		/*
		 * // Create an object for CheckoutCompletePage 
		 * CheckoutCompletePage logoutobj =new CheckoutCompletePage(driver);
		 * 
		 * // Perform Action logoutobj.getmenubar().click();
		 * 
		 * logoutobj.getlogout().click();
		 */
		Reporter.log("Logout is done", true);

	}

	@AfterClass
	public void broserTerminate() {
		
		
		//Close the Browser
		WebDriverLibrary.closeAllWindow();

		/*
		 * // Close the Browser driver.quit();
		 */
	}
	
	@DataProvider
	public Object[][] CheckoutInfo()
	{
		Object[][] data = new Object[1][3];
		
		data[0][0]=ExcelLibrary.readSingledata("CheckoutInfo", 1, 0);
		
		data[0][1]=ExcelLibrary.readSingledata("CheckoutInfo", 1, 1);
		
		data[0][2]=ExcelLibrary.readSingledata("CheckoutInfo", 1, 2);
		
		return data;
		
	}
	
	
	

}