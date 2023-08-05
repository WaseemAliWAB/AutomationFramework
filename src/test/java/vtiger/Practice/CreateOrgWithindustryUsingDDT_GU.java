package vtiger.Practice;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateOrgWithindustryUsingDDT_GU {
	
	
	public static void main(String[] args) throws IOException{

	//Create object of required utilities
	JavaUtility jUtil = new JavaUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	WebDriver driver = null;
	//Step1: Read all the required data
	/*Read data from Property File*/
	String BROWSER = pUtil.getDataFromPropertyFile("browser");
	String URL = pUtil.getDataFromPropertyFile("url");
	String USERNAME = pUtil.getDataFromPropertyFile("username");
	String PASSWORD = pUtil.getDataFromPropertyFile("password");
	
	/*Read data from Excel Sheet*/
	String ORGNAME = eUtil.getDataFromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
	String INDUSTRY = eUtil.getDataFromExcel("Organization", 4, 3);

	//Step 2: Launch the Browser - driver is acting based run time data
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
	}
	else
	{
		System.out.println("Invalid Browser name");
	}
	
	wUtil.maximizeWindow(driver);
	wUtil.waitForElementsToLoad(driver);
	driver.get(URL);
	
	//Step 3: Login to Application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	System.out.println("Login Successful");
	
	//Step 4: Click on Organization Link
	driver.findElement(By.linkText("Organizations")).click();
	
	//Step 5: Click on Create Organization Look Up Image
	driver.findElement(By.cssSelector("[title=\"Create Organization...\"]")).click();
	
	//Step 6: Create Organization with mandatory fields
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	
	//Step 7: Choose 'Chemicals' on Industry drop down
	WebElement element=driver.findElement(By.name("industry"));
	wUtil.handleDropDown(element, INDUSTRY);
	
	//Step 8: Save
	driver.findElement(By.className("crmbutton")).click();
	
	//Step 9: Validate
	String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(orgHeader.contains(ORGNAME)) {
		System.out.println(orgHeader);
		System.out.println("Test Script Passed");
	}
	else
	{
		
		System.out.println("Test Script Failed");
	}
		
	//Step 10: Logout	
	WebElement adImg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wUtil.mouseHoverAction(driver, adImg);
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("Logout Successfully");
	System.out.println("Test Case Passed");
    driver.quit();
}

}
