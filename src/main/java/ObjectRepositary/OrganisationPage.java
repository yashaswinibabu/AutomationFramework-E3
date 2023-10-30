package ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement CreateOrglookUpImg;
		
		public OrganisationPage(WebDriver driver) {
		    PageFactory.initElements(driver, this);
		}

		public WebElement getCreateOrganisationBtn() {
			return CreateOrglookUpImg;
		}
		
		//business login
		/**
		 * This method will click on create org look up image
		 */
		public void clickOnOrganisationLookUpImg()
		{
			CreateOrglookUpImg.click();
		}
		
		
}
