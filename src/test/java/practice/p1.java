package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class p1{
	
	public static void main(String[] args) throws Throwable {
		
		FileInputStream fs= new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fs);
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		WebDriver driver ;
		//Step 2:Launch the browser://Runtime polymorphism-driver
		
		if(BROWSER.equalsIgnoreCase("c"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER+"launched");
		}
		else if(BROWSER.equalsIgnoreCase("c")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(BROWSER+"launched");
		}
		else if(BROWSER.equalsIgnoreCase("c")) 
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(BROWSER+"launched");
		}
		else
		{
			System.out.println("invalid browser name");
		}
		 //driver.findElement(By.xpath("(//input[@name='assigntype'])[1]")).click();
	}

}
