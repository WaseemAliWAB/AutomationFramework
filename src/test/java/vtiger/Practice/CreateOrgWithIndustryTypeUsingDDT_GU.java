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

public class CreateOrgWithIndustryTypeUsingDDT_GU {

	public static void main(String[] args) throws IOException {
		
	//Create object of all the required utilities
	JavaUtility jUtil = new JavaUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	WebDriver driver = null;
	
	//Step 1: Read all the required data
	/*Read data from Property File*/
	String BROWSER = pUtil.getDataFromPropertyFile("browser");
	String URL = pUtil.getDataFromPropertyFile("url");
	String USERNAME = pUtil.getDataFromPropertyFile("username");
	String PASSWORD = pUtil.getDataFromPropertyFile("password");
	
    /*Read data from Excel Sheet*/
    String ORGNAME = eUtil.getDataFromExcel("Organization", 7, 2)+jUtil.getRandomNumber();
    String INDUSTRY = eUtil.getDataFromExcel("Organization", 7, 3);
    String TYPE = eUtil.getDataFromExcel("Organization", 7, 4);
    
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
		System.out.println("Invalid Browser name");
	}
	wUtil.maximizeWindow(driver);
	wUtil.waitForElementsToLoad(driver);
	driver.get(URL);
	
	//Step 3: Login to Application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	System.out.println("Login Successfully");
	
	//Step 4: Click on Organization Link
	driver.findElement(By.linkText("Organizations")).click();
	
	//Step 5: Click on Create Organization Look Up Image
	driver.findElement(By.cssSelector("[title=\"Create Organization...\"]")).click();
	
	//Step 6: Create Organization with Mandatory Fields
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	
	//Step 7: Select Energy in the Industry Drop Down
	WebElement element1 = driver.findElement(By.name("industry"));
	wUtil.handleDropDown(INDUSTRY, element1);
	
	//Step 8: Select Customer in the Type Drop Down
	WebElement element2 = driver.findElement(By.name("accounttype"));
	wUtil.handleDropDown(TYPE, element2);
	
	//Step 9: Save
	driver.findElement(By.className("crmbutton")).click();
	
	//Step 10: Validate
	String val = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(val.contains(ORGNAME)) {
		System.out.println(val);
		System.out.println("Test Script Passed");
	}
	else
	{
		System.out.println("Test Script Failed");
	}
	
	//Step 11: Logout to Application
	WebElement element3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wUtil.mouseHoverAction(driver, element3);
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("Logout Successfully");
	System.out.println("Passed the Script");
	driver.quit();
	}

}
