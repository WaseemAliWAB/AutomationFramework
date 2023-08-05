package vtiger.Practice;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;


public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable {
		
		JavaUtility jUtil = new JavaUtility();
		int value = jUtil.getRandomNumber();
		System.out.println(value);
		
		String date = jUtil.getSystemDate();
		System.out.println(date);
		
		String value1 = jUtil.getSystemDateInFormat();
		System.out.println(value1);
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value2 = pUtil.getDataFromPropertyFile("url");
		System.out.println(value2);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String value3 = eUtil.getDataFromExcel("Organization", 7, 1);
		System.out.println(value3);
		
		eUtil.writeDataIntoExcel("Sample1", 3, 4, "SpiderMan");
		System.out.println("data added");
	}
}
