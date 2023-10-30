package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	
	public static void main(String[] args) throws Throwable {
		
		//Step 1: open the document in java readable format
		FileInputStream fs= new FileInputStream(".\\src\\test\\java\\commonData.properties");
		
		//step 2:create object of properties for java.util package
		Properties p= new Properties();
		
		//step 3: load the file input stream into properties
		p.load(fs);
		
		//step 4:provide the key and read the value
		String value = p.getProperty("browser");
		
		System.out.println(value);
	}

}
