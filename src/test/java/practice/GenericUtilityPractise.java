package practice;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericUtilityPractise {
	
	public static void main(String[] args) throws Throwable {
		
//		PropertyFileUtility pUtil=new PropertyFileUtility();
//		String UN = pUtil.readDataFromPropertyFile("username");
//		System.out.println(UN);
//		
//		String BN = pUtil.readDataFromPropertyFile("browser");
//		System.out.println(BN);
//		
//		String URL = pUtil.readDataFromPropertyFile("url");
//		System.out.println(URL);
//		
//		ExcelFileUtility eUtil=new ExcelFileUtility();
//		String data = eUtil.ReadDataFromExcelFile("Contacts", 0, 0);
//		System.out.println(data);
//		
//		JavaUtility jUtil=new JavaUtility();
//		int r = jUtil.getRandomNumber();
//		System.out.println(r);
//		
//		String d = jUtil.getSystemDate();
//		System.out.println(d);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		WebDriverUtility WebUtil = new WebDriverUtility();
		WebUtil.maximizeWindow(driver);
		WebUtil.waitForPageLoad(driver);		
		
		
	}

}
