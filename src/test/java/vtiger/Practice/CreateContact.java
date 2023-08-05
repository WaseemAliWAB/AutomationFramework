package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws IOException  {
		
		WebDriver driver=null;
		//Step1: Read all the necessary data
		
		/*Read data from PropertyFile*/
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		/*Read data from Excel Sheet - Test data*/
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Row rw = wb.getSheet("Contact").getRow(1);
		String LASTNAME = rw.getCell(2).getStringCellValue();
		
		
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
	   	Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout Successfully");
		System.out.println("The Test Case is Passed");
		driver.quit();
	}

}
