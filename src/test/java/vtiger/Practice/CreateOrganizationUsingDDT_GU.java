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

public class CreateOrganizationUsingDDT_GU {
	                                                                                                            
	public static void main(String[] args) throws InterruptedException, IOException {
		//create object of all the required Utilities
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil =new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		WebDriver driver = null;
		
		//Step 1: Read all the required data
		
		/*Read data from Property File*/
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");
		
		/*Read data from Excel Sheet*/
		String ORGNAME = eUtil.getDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		
		//Step 2: Launch Browser
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
			System.out.println(BROWSER+"--------Browser launched");
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
		
		//Step 4: Click On Organization Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 5:  Click on Organization Look up image
		driver.findElement(By.cssSelector("[title=\"Create Organization...\"]")).click();
		
		//Step 6: Create Organization with Mandatory Fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//Step 7: Save
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
        //Step 8: Validate
        String validate=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        if(validate.contains(ORGNAME))
        {
        	System.out.println(validate);
        	System.out.println("Test Script Passed");
        }
        else
        {
        	System.out.println("Test Script Failed");
        }

        //Step 9: Logout to Application
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout Susscessfully");
		System.out.println("Test Case is Passed");
		driver.quit();
	}

}
