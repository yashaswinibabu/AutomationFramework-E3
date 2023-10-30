package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise {
	
	@Test(dataProvider="getData")
	public void addProductToCart(String name,int price,int qty,String model)
	{
		System.out.println("phone name is "+name+", price is "+price+", qty is "+qty+", model is"+model);
	}
	
	@DataProvider
	public Object[][] getData()
	{                              //row col
		Object[][] data=new Object[3][4];//3 sets of data with 4 details in each set
		
		data[0][0] = "samsung";
		data[0][1] = 10000;
		data[0][2] = 20;
		data[0][3] = "A20";
		
		data[1][0] = "mi";
		data[1][1] = 15000;
		data[1][2] = 10;
		data[1][3] = "s10";
		
		data[2][0] = "iphome";
		data[2][1] = 20000;
		data[2][2] = 30;
		data[2][3] = "D50";
		
		return data;
	}

}
