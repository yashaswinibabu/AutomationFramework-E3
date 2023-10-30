package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScenerioWithDDT {
	
	public static void main(String[] args) throws Throwable {
		/*read data from property file common data*/
		FileInputStream fs= new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fs);
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		/*Read data from excel file*/
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\practiseexcel.xlsx");
		Workbook book = WorkbookFactory.create(fise);
		String LASTNAME = book.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		
		
		WebDriver driver=null;
		//Step 2:Launch the browser://Runtime polymorphism-driver
		
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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Step 3:Load the application
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
    	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
    	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
    	driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
    	
    	String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    	if(ContactHeader.contains(LASTNAME))
    	{
    		System.out.println("pass");
    	}
    	else {
    		System.out.println("fail");
    	}
    	WebElement logout = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		 Actions a = new Actions(driver);
		 a.moveToElement(logout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
