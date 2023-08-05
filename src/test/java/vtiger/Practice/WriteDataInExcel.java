package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		        //Step 1: Open the file in Java Readable format
				FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				
				//Step 2: Create a Workbook Factory
				Workbook wb = WorkbookFactory.create(fise);
				
				
				//Step 3: get control of Sheet
				Sheet sh = wb.createSheet("Minsa");
				
				//Step 4: Get Control of Row
			    Row rw = sh.createRow(0);
				  
				//Step 5: Get Control of Cell
				Cell ce = rw.createCell(0);
				  
				//Step 6: Set the Cell value
				ce.setCellValue("Minsaa");
				  
				//Step 7: Open the file in Java Write Format
				FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");  
				
				//Step 8: Write the data into the file
				wb.write(fos);
				System.out.println("data writtn");
				wb.close();
				  
				  

	}

}
