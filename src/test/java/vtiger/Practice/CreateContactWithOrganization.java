package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganization {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = null;
		//Step 1: Read all required data
		/* Read data from Property File*/
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		/*Read data from excel Sheet*/
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Row rw = wb.getSheet("Contact").getRow(4);
		String LASTNAME = rw.getCell(2).getStringCellValue();
		//String ORGNAME = rw.getCell(3).getStringCellValue();
		
		
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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
		String mainid= driver.getWindowHandle();
		Set<String> allid= driver.getWindowHandles();
		for(String id:allid)
		{
			if(!(id.equals(mainid)))
			{
				driver.switchTo().window(id);
			}
		}
		
		driver.findElement(By.linkText("Minsaaa")).click();
	    driver.switchTo().window(mainid);
	    
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
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout Successfully");
		System.out.println("Passed");
		driver.quit();
	}

}
