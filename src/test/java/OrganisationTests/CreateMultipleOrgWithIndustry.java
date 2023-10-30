package OrganisationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

public class CreateMultipleOrgWithIndustry extends baseClass {
	
	ExcelFileUtility eUtil=new ExcelFileUtility();
	JavaUtility jUtil= new JavaUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	
	@Test(dataProvider="getdata")
	
	public void createMultipleOrg(String ORG,String INDUSTRYNAME) throws Throwable
	{
	
		String ORGNAME=ORG+jUtil.getRandomNumber();
		
		//Step 6:click on organisatiion
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganisation();;
		
		//step 7:click on organisation
		OrganisationPage op=new OrganisationPage(driver);
		op.clickOnOrganisationLookUpImg();
		
		//step 8:create new organisation with mandatory fields
		CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
		cnop.CreateNewOrganisation(ORGNAME, INDUSTRYNAME);
		
		//Step 9:validate for organisation
		OrganisationInformationPage oip=new OrganisationInformationPage(driver);
		 String orgheader = oip.getHeaderText();
		 Assert.assertTrue(orgheader.contains(ORGNAME));
		 System.out.println(orgheader);
	
	}
	
	@DataProvider
	public Object[][] getdata() throws Throwable, IOException
	{
		return eUtil.readMultipleDate("multipleOrganisationOrgName");
	}

}
