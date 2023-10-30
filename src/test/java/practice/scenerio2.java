package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scenerio2 {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("yashu");
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("www.wipro.in");
		driver.findElement(By.xpath("//input[@name='tickersymbol']")).sendKeys("fn");
		driver.findElement(By.xpath("//input[@id='employees']")).sendKeys("50");
		driver.findElement(By.xpath("//input[@id='email2']")).sendKeys("ysh@gmail.com");
		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
		Select s=new Select(industry);
		s.selectByValue("Construction");
		WebElement type = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select ss=new Select(type);
		ss.selectByValue("Competitor");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("454152");
		driver.findElement(By.xpath("//input[@name='fax']")).sendKeys("51515");
		driver.findElement(By.xpath("//input[@name='otherphone']")).sendKeys("81857778");
		driver.findElement(By.xpath("//input[@name='email1']")).sendKeys("abf@gmail.com");
		driver.findElement(By.xpath("//input[@name='ownership']")).sendKeys("yesf");
		WebElement rating = driver.findElement(By.xpath("//select[@name='rating']"));
		Select sr=new Select(rating);
		sr.selectByValue("Active");
		driver.findElement(By.xpath("//input[@name='siccode']")).sendKeys("45151");
		driver.findElement(By.xpath("//input[@name='notify_owner']")).click();
		driver.findElement(By.xpath("(//input[@name='cpy'])[2]")).click();
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys("anandnagar");
		driver.findElement(By.xpath("//input[@id='bill_pobox']")).sendKeys("25155");
		driver.findElement(By.xpath("//input[@id='bill_city']")).sendKeys("hubli");
		driver.findElement(By.xpath("//input[@id='bill_state']")).sendKeys("karnataka");
		driver.findElement(By.xpath("//input[@id='bill_code']")).sendKeys("48545");
		driver.findElement(By.xpath("//input[@id='bill_country']")).sendKeys("India");
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		WebElement logout = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		 Actions a = new Actions(driver);
		 a.moveToElement(logout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
	}

}
