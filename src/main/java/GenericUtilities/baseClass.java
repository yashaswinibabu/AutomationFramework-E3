package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
/**
 * This class consistes of all basic configuration annotations of testNg
 */
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import ObjectRepositary.HomePage;
import ObjectRepositary.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver= null;
	
	//used in listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"SmokeSuite","RegressionSuite"})//(alwaysRun=true)
	public void bsConfig() {
		System.out.println("----DB connectionsuccesfull------");
	}
//	@Parameters("browser")
//	@BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String BROWSER*/) throws Throwable {
		
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
	
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER+"launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(BROWSER+"launched");
		}
		else if(BROWSER.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(BROWSER+"launched");
		}
		else
		{
			System.out.println("invalid browser name");
		}
		
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		//used in listeners
		sdriver=driver;
		//step 4:load url
		driver.get(URL);
	}
	@BeforeMethod(alwaysRun=true)
	
	public void bmConfig() throws Throwable
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("------login success-----");
	}
	
	@AfterMethod(alwaysRun=true)
	public void amconfig() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.logoutofApp(driver);
		
		System.out.println("----logout success-----");
	}
//	@AfterTest
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
	}
	
	@AfterSuite(alwaysRun=true)
	public void asConif()
	{
		System.out.println("-----DB Connectionclose-----");
	}
	

}
