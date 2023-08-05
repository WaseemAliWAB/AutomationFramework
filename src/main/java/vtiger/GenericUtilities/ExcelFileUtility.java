package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to Excel file
 * @author WASEEM ALI BHAT
 *
 */
public class ExcelFileUtility {
	/**
	 * This method will read the data from Excel sheet based on sheet name, row no and cell no given by caller
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return value
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetName,int rowNo,int celNo) throws IOException
	{
		FileInputStream fise = new FileInputStream(IConstants.excelfilePath);
		Workbook wb = WorkbookFactory.create(fise);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
		return value;
	}
	
	/**
	 * This method will write data into excel sheet
	 * @throws Throwable
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo, int celNo, String data) throws Throwable, IOException
	{
		FileInputStream fise = new FileInputStream(IConstants.excelfilePath);
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.createSheet(sheetName);
		Row rw = sh.createRow(rowNo);
		Cell cl = rw.createCell(celNo);
		cl.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(IConstants.excelfilePath);
		wb.write(fos);
		
	}
	
	/**
	 * This method will read all the data inside a sheet to used in data provider
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstants.excelfilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCel = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCel];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCel;j++)
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
		
	}	
}
