package GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class will provide implemengtation to the IRetryAnalyser interface ti TestNg
 * @author Admin
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count =0;
	int retryCount=3;
	public boolean retry(ITestResult result) {
         
		//0<3 1<3 2<3 3<3no
		while(count<retryCount)
		{
			count++;//1 2 3
			return true;//retry retry retry
		}
		return false; //stop retrying
	}
	

}
