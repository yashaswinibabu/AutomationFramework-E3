package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consistes of all generic methods related to web driver actions
 * @author Admin
 *
 */

public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		
		driver.manage().window().maximize();
		
	}
	/**
	 * This method will manimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		
		driver.manage().window().minimize();//browser launched and maximise
		
	}
	/**
	 * This method will wait for the page to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	/**
	 * This method will wait for a particular element to be visible in the DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for a particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will handle dropdown by value
	 * @param driver
	 * @param element
	 * @param value
	 */

	public void HandleDropDown(WebElement element,String value)
	{
		Select sel= new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void HandleDropDown(WebElement element,int index)
	{
		Select sel =new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will handle dropdown by visible text
	 * @param element
	 * @param index
	 */
	public void HandleDropDown(String text,WebElement element)
	{
		Select sel =new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will perform mouseover action
	 * @param driver
	 */
	public void MouseOverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will move the cursor based on offset and click on web page
	 * @param driver
	 */
	public void MoveAndClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
	}
	/**
	 * This method will perform right click
	 * @param driver
	 */
	public void RightClickAction(WebDriver driver)
	{
		Actions actions=new Actions(driver);	
		actions.contextClick().perform();
	}
	/**
	 * This method will perform double click 
	 * @param driver
	 */
	public void DoubleClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method will perform drag and drop
	 * @param driver
	 * @param srcEle
	 * @param dstEle
	 */
	public void DragAndDropAction(WebDriver driver,WebElement srcEle,WebElement dstEle)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcEle, dstEle);
	}
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param index
	 */
	public void SwitchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method will handle frame by Name or ID
	 * @param driver
	 * @param index
	 */
	public void SwitchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method will handle frame by Webelement
	 * @param driver
	 * @param index
	 */
	public void SwitchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method will scroll down by 500 units
	 * @param driver
	 */
	public void ScrollDownAction(WebDriver driver)
	{
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,500);", "");
	}
	/**
	 * This method will scroll up by 500 units
	 * @param driver
	 */
	public void ScrollUpAction(WebDriver driver)
	{
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,-500);", "");
	}
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void AcceptAllert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will cancel the alert popup
	 * @param driver
	 */
	public void CancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will fetch the alert text and return it to caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method will take screenshot and return the dst path
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws Throwable
	 */
	public String CaptureScreenshot(WebDriver driver,String ScreenShotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);// temporory location
		File dst = new File("C:\\Selenium workspace\\Vtiger_Framework\\screenshot"+ ScreenShotName+".png");//scenerio1.png
		
		Files.copy(src, dst);
		return dst.getAbsolutePath();// used for extent reports
	}
	/**
	 * This method will switch from one window to another window based on window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		//Step 1:get all the window ID
		Set<String> allWindow = driver.getWindowHandles();
		
		//Step 2:navigate thru each window
		for(String winID:allWindow)
		{
			//Step 3: switch to each window and capture the title
			String actTitle = driver.switchTo().window(winID).getTitle();
			
			//Step 4:Compare act title with expected partial title
			if(actTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	
}
