package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to Property File
 * @author WASEEM ALI BHAT
 *
 */
public class PropertyFileUtility {

	/**
	 * This method reads Data from property file based on given key
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fisp = new FileInputStream(IConstants.propertyfilePath);
		Properties p = new Properties();
		p.load(fisp);
		String value = p.getProperty(key);
		return value;
	}
}
