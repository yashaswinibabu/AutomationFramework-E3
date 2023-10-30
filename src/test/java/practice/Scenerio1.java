package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenerio1 {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
    	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		 WebElement firstname = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		 Select s= new Select(firstname);
		 s.selectByValue("Ms.");
		 driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("yashu");
		 driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("babu");
		 driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys("Qspider");
		 WebElement leadSource = driver.findElement(By.xpath("//select[@name='leadsource']"));
		 Select S=new Select(leadSource);
		 S.selectByValue("Employee");
		 driver.findElement(By.xpath("//input[@id='title']")).sendKeys("Eclipse");
		 driver.findElement(By.xpath("//input[@id='department']")).sendKeys("oracle");
		 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");
		 driver.findElement(By.xpath("//input[@id='assistant']")).sendKeys("somm");
		 driver.findElement(By.xpath("//input[@id='assistantphone']")).sendKeys("452148555");
		 driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("5147852");
		 driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("4852859854");
		 driver.findElement(By.xpath("//input[@id='homephone']")).sendKeys("54545455");
		 driver.findElement(By.xpath("//input[@id='otherphone']")).sendKeys("7412585236");
		 driver.findElement(By.xpath("//input[@id='fax']")).sendKeys("45415");
		 driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("1993-01-18");
		 driver.findElement(By.xpath("//input[@name='contact_name']")).sendKeys("lead");
		 driver.findElement(By.xpath("//input[@name='secondaryemail']")).sendKeys("cbb@gmail.com");
		 driver.findElement(By.xpath("//input[@name='donotcall']")).click();
		 driver.findElement(By.xpath("//input[@name='emailoptout']")).click();
		 driver.findElement(By.xpath("//input[@name='reference']")).click();
		 driver.findElement(By.xpath("//input[@name='notify_owner']")).click();
		WebElement assigneTo = driver.findElement(By.xpath("//select[@name='assigned_user_id']"));
		 Select AS=new Select(assigneTo);
		 AS.selectByValue("1");
		 driver.findElement(By.xpath("(//input[@name='assigntype'])[1]")).click();
		 driver.findElement(By.xpath("(//input[@name='support_start_date'])[1]")).sendKeys("2023-05-18");
		 driver.findElement(By.xpath("//input[@name='support_end_date']")).sendKeys("2024-03-18");
		 driver.findElement(By.xpath("//input[@name='portal']")).click();
		 driver.findElement(By.xpath("(//input[@name='cpy'])[2]")).click();
		 driver.findElement(By.xpath("//textarea[@name='mailingstreet']")).sendKeys("anandnagar");
		 driver.findElement(By.xpath("//input[@id='mailingpobox']")).sendKeys("57002");
		 driver.findElement(By.xpath("//input[@id='mailingcity']")).sendKeys("Bangalore");
		 driver.findElement(By.xpath("//input[@id='mailingstate']")).sendKeys("Karnataka");
		 driver.findElement(By.xpath("//input[@id='mailingzip']")).sendKeys("41525");
		 driver.findElement(By.xpath("//input[@id='mailingcountry']")).sendKeys("Bharath");
		 driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("okokokokokokoko");
		 driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		 WebElement logout = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		 Actions a = new Actions(driver);
		 a.moveToElement(logout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			
	}

}
