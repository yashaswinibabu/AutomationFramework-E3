package saturdaysClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepositary.ContactInformationPage;
import ObjectRepositary.ContactPage;
import ObjectRepositary.CreateNewContactPage;
import ObjectRepositary.CreateNewOrganisationPage;
import ObjectRepositary.HomePage;
import ObjectRepositary.LoginPage;
import ObjectRepositary.OrganisationInformationPage;
import ObjectRepositary.OrganisationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganisation2 {
	
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
	JavaUtility jutil=new JavaUtility();
	ExcelFileUtility Eutil=new ExcelFileUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	
	
	String BROWSER = putil.readDataFromPropertyFile("browser");
	String URL = putil.readDataFromPropertyFile("url");
	String USERNAME = putil.readDataFromPropertyFile("username");
	String PASSWORD = putil.readDataFromPropertyFile("password");
	
	String LASTNAME = Eutil.ReadDataFromExcelFile("Contacts", 7, 2);
	String ORGNAME = Eutil.ReadDataFromExcelFile("Contacts", 7, 3)+jutil.getRandomNumber();
	
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("chrome launched");
	}
	else if(BROWSER.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		System.out.println("edge launched");
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		System.out.println("firefox launched");
	}
	
	wutil.maximizeWindow(driver);
	wutil.waitForPageLoad(driver);
	driver.get(URL);
	
	LoginPage lp= new LoginPage(driver);
	HomePage hp=new HomePage(driver);
	OrganisationPage op=new OrganisationPage(driver);
	CreateNewOrganisationPage cp=new CreateNewOrganisationPage(driver);
	OrganisationInformationPage oip=new OrganisationInformationPage(driver);
	ContactPage cop=new ContactPage(driver);
	CreateNewContactPage ccp=new CreateNewContactPage(driver);
	ContactInformationPage cip=new ContactInformationPage(driver);
		
	lp.loginToApp(USERNAME, PASSWORD);
	hp.getOrganisation();
	op.getCreateOrganisationBtn().click();
	cp.getOrgnameEdt();
	cp.getSavebtn().click();
	
	Thread.sleep(3000);
	hp.getContacts().click();
	cop.getCreateContactBtn().click();
	ccp.getLastnameBox().sendKeys(LASTNAME);
	ccp.getAddOrgIcon();
	wutil.switchToWindow(driver, "Accounts");
	ccp.getSearchbox().sendKeys(ORGNAME);
	driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
	ccp.getSearchBtn().click();
	wutil.switchToWindow(driver, "Contacts");
	ccp.getSaveBtn().click();
	}

}
