package ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNewOrganisationPage extends WebDriverUtility{
	
	@FindBy(xpath="//input[@name=\"accountname\"]")
	private WebElement OrgnameEdt;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement IndustryDropDown;

	@FindBy(xpath="//input[@class=\"crmbutton small save\"]")
	private WebElement Savebtn;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	public CreateNewOrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrgnameEdt() {
		return OrgnameEdt;
	}

	public WebElement getSavebtn() {
		return Savebtn;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	
	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}


	//buisness libraries
	/**
	 * This method will create organisation with mandatary fields
	 * @param ORGNAME
	 */
	public void createNewOrganisation(String ORGNAME)
	{
		OrgnameEdt.sendKeys(ORGNAME);
		Savebtn.click();
	}
	/**
	 * This method will create new organisation with industry dropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void CreateNewOrganisation(String ORGNAME, String INDUSTRY)
	{
		OrgnameEdt.sendKeys(ORGNAME);
		HandleDropDown(IndustryDropDown, INDUSTRY);
		Savebtn.click();
		
	}
	/**
	 * This method will create the organisation with industry and type drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param TYPE
	 */
	public void CreateNewOrganisation(String ORGNAME, String INDUSTRY,String TYPE)
	{
		OrgnameEdt.sendKeys(ORGNAME);
		HandleDropDown(IndustryDropDown, INDUSTRY);
		HandleDropDown(typeDropDown, TYPE);
		Savebtn.click();
		
	}
}
