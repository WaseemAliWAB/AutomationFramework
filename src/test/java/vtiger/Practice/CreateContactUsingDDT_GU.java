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

public class CreateContactUsingDDT_GU {

public static void main(String[] args) throws IOException  {
		
	   //Create object of required utilities
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		WebDriver driver=null;
		//Step1: Read all the necessary data
		
		/*Read data from PropertyFile*/
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");
		
		/*Read data from Excel Sheet - Test data*/
		String LASTNAME = eUtil.getDataFromExcel("Contact", 1, 2);		
		
		//Step 2: Launch the Browser driver is acting based runtime data
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			System.out.println(BROWSER+"------Browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(BROWSER+"-----Browser launched");
		}
		else
		{
			System.out.println("Invalid Browser name");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoad(driver);
		driver.get(URL);
		
		//Step 3: Login to the Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		System.out.println("Login Successfully");
		
		//Step 4: Click on Contact Link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 5: Click on Create Contact Look Up Image
		driver.findElement(By.cssSelector("[title=\"Create Contact...\"]")).click();
		
		//Step 6: Create Contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//Step 7: Save
		driver.findElement(By.className("crmButton")).click();
		
		//Step 8: Validation
		String conHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(conHeader.contains(LASTNAME))
		{
			System.out.println(conHeader);
			System.out.println("Test Script Passed");
		}
		else
		{
			System.out.println("Test Script Failed");
		}
		
		//Step 9: Logout
	  	WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout Successfully");
		System.out.println("The Test Case is Passed");
		driver.quit();
	}

}
