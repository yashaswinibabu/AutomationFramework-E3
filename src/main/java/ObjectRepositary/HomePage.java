package ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//declation--dropdown,frames,windows,textfields,popoups
	@FindBy(linkText="Organizations")
	private WebElement organisationLink;
	
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement imageIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement logoutBtn;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganisation() {
		return organisationLink;
	}

	public WebElement getContacts() {
		return contactsLink;
	}

	public WebElement getImageIcon() {
		return imageIcon;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	//buisness librarey
	/**
	 * this mthod will click on organisation link
	 */
	public void clickOnOrganisation()
	{
		organisationLink.click();
	}
	/**
	 * this method will click on contact
	 */
	public void clickOnContacts()
	{
		contactsLink.click();
	}
	/**
	 * this method will signout the application
	 * @param driver
	 * @throws Throwable
	 */
	public void logoutofApp(WebDriver driver) throws Throwable
	{
		MouseOverAction(driver, imageIcon);
		Thread.sleep(3000);
		logoutBtn.click();
	}

}
