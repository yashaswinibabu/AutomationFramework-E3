package ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInformationPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
    
	
	public OrganisationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
   
	//buisness library
	/**
	 * this method will capture the header and return it to caller
	 * @return
	 */
	public String getHeaderText()
	{
		return OrgHeaderText.getText();
	}
}
