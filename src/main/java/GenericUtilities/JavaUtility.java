package GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * This method will generate a random number for every run and return it to caller
	 * @return
	 */
	public int getRandomNumber()
	{
	
		Random ran=new Random();
		int r = ran.nextInt(1000);
		return r;
	
	}
	/**
	 * This method will capture the current system date is required format
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String date = formatter.format(d);
		return date;
	}
}
