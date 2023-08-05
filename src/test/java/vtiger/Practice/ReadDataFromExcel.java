package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: Open the file in Java Readable format
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create a Workbook Factory
		Workbook wb = WorkbookFactory.create(fise);
	
		
		//Step 3: get control of Sheet
		Sheet sh = wb.getSheet("Organization");
		
		//Step 4: Get Control of Row
		  Row rw =sh.getRow(1);
		  
	    //Step 5: get Control of Cell
		  Cell ce = rw.getCell(2);

		//Step 6: Capture the Information inside the cell
		  String value = ce.getStringCellValue();
		  System.out.println(value);
	}

}
