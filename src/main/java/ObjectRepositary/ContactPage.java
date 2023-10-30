package ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class ContactPage {
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateContactLookupImg;
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactBtn() {
		return CreateContactLookupImg;
	}
	//buisness library
	/**
	 * This method will click on contact image icon
	 */
	public void clickOnCreatecontactLookupImg()
	{
		CreateContactLookupImg.click();
	}
   
}
