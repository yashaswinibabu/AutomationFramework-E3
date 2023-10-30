package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

//comment
/*multi line comment*/
/**
 * This class consisits of generic methods to read data from
 * propert file
 * @author Admin
 *
 */
public class PropertyFileUtility {
	/**
	 * This method will read data from property file and return the value caller 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile( String key) throws Throwable
	{
		FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p=new Properties();
		p.load(fs);
		String value = p.getProperty(key);
		 return value;
		
	}
	
	

}
