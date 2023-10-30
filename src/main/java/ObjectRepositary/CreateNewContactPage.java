package ObjectRepositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement LastnameEdt;
	
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement OrgLookupImg;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement OrgsearchEdt;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement OrgsearchBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement SaveBtn;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnameBox() {
		return LastnameEdt;
	}

	public WebElement getAddOrgIcon() {
		return OrgLookupImg;
	}

	public WebElement getSearchbox() {
		return OrgsearchEdt;
	}

	public WebElement getSearchBtn() {
		return OrgsearchBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	//buisness logic
	/**
	 * this method will create contact with mandatory field
	 * @param LASTNAME
	 */
	public void CreateNewContact(String LASTNAME)
	{
		LastnameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	/**
	 * This method will create contact with organisation
	 * @param driver
	 * @param LASTNAME 
	 * @param ORGNAME 
	 */
	public void CreateNewContact(WebDriver driver, String LASTNAME, String ORGNAME)
	{
		LastnameEdt.sendKeys(LASTNAME);
		OrgLookupImg.click();
		switchToWindow(driver, "Accounts");
		OrgsearchEdt.sendKeys(ORGNAME);
		OrgsearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
	}
	
}
