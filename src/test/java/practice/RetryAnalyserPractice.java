package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.RetryAnalyserImplementation;


public class RetryAnalyserPractice  {
	
	@Test(retryAnalyzer= GenericUtilities.RetryAnalyserImplementation.class)
	public void retryAnalyser()
	{
		Assert.fail();
		System.out.println("hello");
	}

}
