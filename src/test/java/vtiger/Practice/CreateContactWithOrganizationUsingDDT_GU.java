package vtiger.Practice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateContactWithOrganizationUsingDDT_GU {
public static void main(String[] args) throws IOException {
		
		//create object of all the required utilities
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		WebDriver driver = null;
		//Step 1: Read all required data
		/* Read data from Property File*/
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");
		
		/*Read data from excel Sheet*/
		String LASTNAME = eUtil.getDataFromExcel("Contact", 4, 2);
		
		//Step 2: Launch the Browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+"-------Browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+"------Browser launched");
		}
		else
		{
			System.out.println(" Invalid Browser name");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoad(driver);
		driver.get(URL);
		
		//Step 3: Login To Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		System.out.println("Login Successfully");
		
		//Step 4: Click on Contact Link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 5: Click on Create Contact Look Up Image
		driver.findElement(By.cssSelector("[title=\"Create Contact...\"]")).click();
		
		//Step 6: Create Contact with Mandatory Field
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//Step 7: Select Organization from Organization Look Up Image
		driver.findElement(By.xpath("//input[@name=\"account_name\"]/following-sibling::img")).click();
		wUtil.switchToWindow(driver, "Accounts");
		driver.findElement(By.linkText("Minsaaa")).click();
	    wUtil.switchToWindow(driver, "Contacts");
	    //Step 8: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 9: Validate
		String verify=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(verify.contains(LASTNAME)) {
			System.out.println(verify);
			System.out.println("Test Script Passed");
		}
		else {
			System.out.println("Test Script Failed");
		}
		
		//Step 10: Logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout Successfully");
		System.out.println("Passed");
		driver.quit();
	}

}
