package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {
	
	    public static void main(String[] args) throws IOException {

	//Step1: Open the file in Java Readable format
	FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");

	//Step 2: Create Object of Properties class from java.util
	Properties pobj = new Properties();
	
	//Step 3: Load the file into properties
	pobj.load(fisp);
	
	//Step 4: give the key and read the value
	String value = pobj.getProperty("browser");
	System.out.println(value);//it will print chrome
	
	String value1= pobj.getProperty("url");
	System.out.println(value1);
	
	    }
}
