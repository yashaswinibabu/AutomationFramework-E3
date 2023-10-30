package GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of TestNG
 * @author Admin
 *
 */

public class ListenersImplementationClass implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"==== test script execution started======");
		
		//create a tesr script-recognise each @Test
		test=report.createTest(testScriptName);
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"====Passed====");
		
		//log the success
		test.log(Status.PASS, testScriptName+"===PASS====");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		//screenshot
		//exception for failure
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"====failed====");
		
		//exception for failure
		System.out.println(result.getThrowable());
		
		//Log for failure
		test.log(Status.FAIL, testScriptName+"======FAILED====");
		test.log(Status.INFO, result.getThrowable());
		
		//screenshot
		String ScreenShotName = testScriptName +new JavaUtility().getSystemDate();
		WebDriverUtility web=new WebDriverUtility();
		try {
			String path = web.CaptureScreenshot(baseClass.sdriver, ScreenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"====skipped====");
		
		//exception for failure
		System.out.println(result.getThrowable());
		
		//log for skip
		test.log(Status.SKIP, testScriptName+"====SKIPPED=====");
		test.log(Status.INFO, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("=====suite execution started====");
		
		//basic report configeration// report-17-10-2023-20-04-20.html
		ExtentSparkReporter html=new ExtentSparkReporter(".\\ExtentReport\\Report-"+new JavaUtility().getSystemDate()+".html");
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Execution Report");
		html.config().setReportName("vtiger execution report");
		
		report=new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("base browser", "edge");
		report.setSystemInfo("base platform", "Windows");
		report.setSystemInfo("base environment", "testing");
		report.setSystemInfo("Reporter name", "yashu");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("=====suite execution finished====");
		
		//report generation
		report.flush();
	}
	
	

}
