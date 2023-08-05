package vtiger.GenericUtilities;


import java.util.Date;
import java.util.Random;

/**
 * This Class consists of all generic methods related to java
 * @author WASEEM ALI BHAT
 */
public class JavaUtility {
	
	/**
	 * This method will generate random number
	 * @return
	 */
	
	public int getRandomNumber()
	{
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
	}
	
	/**
	 * This method will generate the system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	/**
	 * This method will generate the system date in particular format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String[] date = d.toString().split(" ");
		String currentDate = date[2];
		String month = date[1];
		String year = date[5];
		String time = date[3].replace(":", "-");
		String dateInFormat = currentDate+"_"+month+"_"+year+"_"+time;
		return dateInFormat;
	}
	
}

