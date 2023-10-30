package ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import GenericUtilities.baseClass;
import ObjectRepositary.ContactInformationPage;
import ObjectRepositary.ContactPage;
import ObjectRepositary.CreateNewContactPage;
import ObjectRepositary.HomePage;
import ObjectRepositary.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(GenericUtilities.ListenersImplementationClass.class)
public class createContactTest extends baseClass {
	
	//ContactTests.createContactTest--right click on class name copy qualifed name 
	//and paste to get package name with class name
	@Test(groups= {"SmokeSuite","RegressionSuite"})
	public void createContactTest() throws Throwable
	{
		
				String ORGNAME=eUtil.ReadDataFromExcelFile("Contacts", 7, 3)+jUtil.getRandomNumber();
				String LASTNAME = eUtil.ReadDataFromExcelFile("Contacts", 7, 2);
				
				//Step 5:clicl on contacts
				HomePage hp=new HomePage(driver);
				hp.clickOnContacts();
				Reporter.log("clik on contacts");
				
				//step 6:click on create contact img
				ContactPage cp=new ContactPage(driver);
				cp.clickOnCreatecontactLookupImg();
				Reporter.log("CreatecontactLookupImg");
				
				//step 7:create contats
				CreateNewContactPage cncp=new CreateNewContactPage(driver);
				cncp.CreateNewContact(LASTNAME);
				Reporter.log("CreateNewContact");
				
				//step 8:validation
				ContactInformationPage cip= new ContactInformationPage(driver);
				String contactHeader = cip.getHeaderText();
				Reporter.log("HeaderText captured");
				
				//Assert.fail();
				Assert.assertTrue(contactHeader.contains(LASTNAME));
				Reporter.log("HeaderText validation");
				System.out.println(contactHeader);
	}
				
				@Test
				public void demo()
				{
					System.out.println("demo");
				}
}
