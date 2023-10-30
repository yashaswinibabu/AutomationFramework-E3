package OrganisationTests;

import org.openqa.selenium.WebDriver;
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
import ObjectRepositary.CreateNewOrganisationPage;
import ObjectRepositary.HomePage;
import ObjectRepositary.LoginPage;
import ObjectRepositary.OrganisationInformationPage;
import ObjectRepositary.OrganisationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationTest extends baseClass {
	
@Test
public void createOrgTest() throws Throwable
{
	
				
				String ORGNAME=eUtil.ReadDataFromExcelFile("Contacts", 7, 3)+jUtil.getRandomNumber();
				String LASTNAME = eUtil.ReadDataFromExcelFile("Contacts", 7, 2);
				
		
				//Step 5:clicl on organisation
				HomePage hp=new HomePage(driver);
				hp.clickOnOrganisation();
				
				//step 6:click on organisation look up img
				OrganisationPage op=new OrganisationPage(driver);
				op.clickOnOrganisationLookUpImg();
				
				//Step 7:create organisation
				CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
				cnop.createNewOrganisation(ORGNAME);
				
				//Step 8:validation
				OrganisationInformationPage oip=new OrganisationInformationPage(driver);
				String orgHeader = oip.getHeaderText();
				Assert.assertTrue(orgHeader.contains(ORGNAME));
				System.out.println(orgHeader);
			
}
}