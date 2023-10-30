package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepositary.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createOrganisation {
	
	public static void main(String[] args) throws Throwable {
		
		//Step 1:create all the required objects
		JavaUtility jUtil=new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		WebDriver driver=null;
		
		//step 2:Read the required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME=eUtil.ReadDataFromExcelFile("organization", 1, 2)+jUtil.getRandomNumber();
		//Step 3: Launch the browser
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
		
		//step 4:load url
		driver.get(URL);
		
		//Step 5:login to application
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
//		lp.getUserNameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
		
		//Step 6:navigate to organisation link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 7:create organisation with mandatory information
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 8:create organisation with mandatory information
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//Step 9:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(3000);
		
		//Step 10:validate
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader);
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		//Step 11:Logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.MouseOverAction(driver, element);
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("logout successfull");
	}

}
