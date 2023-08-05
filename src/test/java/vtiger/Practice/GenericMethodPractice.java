package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericMethodPractice {
	public static void main(String[] args) throws IOException {
		
			
		int result1 = add(20,20);
		System.out.println(result1);
		
		String result2 = getSystemDate();
		System.out.println(result2);
		
		String result3 = getSystemDateInFormat();
		System.out.println(result3);
		
		String result4 = getDataFromExcel("Contact",4,1);
		System.out.println(result4);
	}
	
	public static int add(int a, int b)
	{
		int c = a+b;
		return c;
	}

	public static String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	
	public static String getSystemDateInFormat()
	{
		Date d = new Date();
		String[] date = d.toString().split(" ");
		String currentDate = date[2];
		String month = date[1];
		String year = date[5];
		String time = date[3].replace(":", "-");
		String dateInFormat = currentDate+"-"+month+"-"+year+"-"+time;
		return dateInFormat;
	}
	
	public static String getDataFromExcel(String sheet,int row,int cell) throws IOException
	{
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String result = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return result;
	}

}
