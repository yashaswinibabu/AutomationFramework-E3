package practice;

import org.testng.annotations.Test;

public class TestNGpractrise {
	
	@Test(enabled=false)
	public void createCustomer()
	{
		System.out.println("create");
	}
	
	@Test(priority=0)
	public void modifyCustomer()
	{
		System.out.println("modify");
	}
	
	@Test(priority=2)
	public void deleteCustomer()
	{
		System.out.println("delete");
	}

}
