package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class assertionPractise {
	
	@Test
	public void practice()
	{
		System.out.println("step-1");
		System.out.println("step-2");   
		
		
		
		Assert.assertEquals(1, 0);//1==1
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
	@Test
	public void practice1()
	{
		System.out.println("step-1");
		System.out.println("step-2");
		
		SoftAssert s= new SoftAssert();
		s.assertEquals(true, false);
		System.out.println("step-3");
		System.out.println("step-4");
		
		Assert.assertEquals(true, false);
		
		s.assertEquals(true, false);
		
		s.assertAll();
	}

}
