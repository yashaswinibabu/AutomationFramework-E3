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
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganisation {
	
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
		
		String ORGNAME=eUtil.ReadDataFromExcelFile("Contacts", 7, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.ReadDataFromExcelFile("Contacts", 7, 2);
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
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 6:navigate to organisation link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 7:create organisation with mandatory information
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 8:create organisation with mandatory information
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//Step 9:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(3000);
		
		//Step 10:validate for organisation
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader);
			System.out.println("Organisation created successfully");
		}
		else
		{
			System.out.println("fail");
		}
		
	//	step 11:navigate to contacts
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		
	//	step 12:click on create contact look up icon
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
	//step 13:create contact with mandatory fields	
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
		
		//step 14:clik in organisation look up image
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		
		wUtil.switchToWindow(driver, "Accounts");
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		//orgname is dynamic
		//xpath is changing dynamically - dynamic xpath
		//a[text()='"+variablename+"']
		
		wUtil.switchToWindow(driver, "Contacts");
		
	//	step 15:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 16:validate for contacts
				String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(contactHeader.contains(LASTNAME))
				{
					System.out.println(contactHeader);
					System.out.println("CONTACT created successfully");
				}
				else
				{
					System.out.println("fail");
				}
				
				//Step 17:Logout
				WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.MouseOverAction(driver, element);
				
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("logout successfull");
		
	}

}
