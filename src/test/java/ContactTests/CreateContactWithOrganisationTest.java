package ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import GenericUtilities.baseClass;
import ObjectRepositary.ContactInformationPage;
import ObjectRepositary.ContactPage;
import ObjectRepositary.CreateNewContactPage;
import ObjectRepositary.CreateNewOrganisationPage;
import ObjectRepositary.HomePage;
import ObjectRepositary.LoginPage;
import ObjectRepositary.OrganisationInformationPage;
import ObjectRepositary.OrganisationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganisationTest extends baseClass {
	
	@Test(groups="RegressionSuite")
	public void CreateContactWithOrgTest()   throws Throwable
	{
	
			
			String ORGNAME=eUtil.ReadDataFromExcelFile("Contacts", 7, 3)+jUtil.getRandomNumber();
			String LASTNAME = eUtil.ReadDataFromExcelFile("Contacts", 7, 2);
			
			//Step 6:click on organisatiion
			HomePage hp=new HomePage(driver);
			hp.clickOnOrganisation();;
			
			//step 7:click on organisation
			OrganisationPage op=new OrganisationPage(driver);
			op.clickOnOrganisationLookUpImg();
			
			//step 8:create new organisation with mandatory fields
			CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
			cnop.createNewOrganisation(ORGNAME);
			
			//Step 9:validate for organisation
			OrganisationInformationPage oip=new OrganisationInformationPage(driver);
			 String orgheader = oip.getHeaderText();
			 Assert.assertTrue(orgheader.contains(ORGNAME));
			 System.out.println(orgheader);
			 
			 //step 10:click on contact link
			 
			hp.clickOnContacts();
	
			//step 11:click on create contact look up image
			ContactPage cp=new ContactPage(driver);
			cp.clickOnCreatecontactLookupImg();
			
			//step 12:create contact with organisation
			CreateNewContactPage cncp=new CreateNewContactPage(driver);
			cncp.CreateNewContact(driver, LASTNAME, ORGNAME);
			
			//step 13:validation
			ContactInformationPage cip=new ContactInformationPage(driver);
			String contactHeader = cip.getHeaderText();
			Assert.assertTrue(contactHeader.contains(LASTNAME));
			System.out.println(contactHeader);
		
			
			
			
		
}
}