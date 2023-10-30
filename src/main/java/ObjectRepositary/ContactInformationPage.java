package ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	//buisness logic
	/**
	 * This method will capture the header and return it to caller
	 * @return
	 */
	public String getHeaderText()
	{
		return ContactHeaderText.getText();
	}
	

}
