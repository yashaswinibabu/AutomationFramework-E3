package saturdaysClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calenderpopoup2 {

public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		for(;;)//1,2,3
		{
		try {
			//not visible - exception - visible -click()
			driver.findElement(By.xpath("//div[@aria-label='Sat Feb 03 2024']")).click();
			break;
		} catch (Exception e) {
			//click on next month
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			Thread.sleep(1000);
		}
		}
}
}