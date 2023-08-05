package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustryType {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = null;
		Random r= new Random();
		int rndm= r.nextInt(10000);
		//Step 1: Read all the required data
		/*Read data from Property File*/
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
        Properties p = new Properties();
        p.load(fisp);
        String BROWSER = p.getProperty("browser");
        String URL = p.getProperty("url");
        String USERNAME = p.getProperty("username");
        String PASSWORD = p.getProperty("password");
        
        /*Read data from Excel Sheet*/
        FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
        Workbook wb = WorkbookFactory.create(fise);
        Row rw = wb.getSheet("Organization").getRow(7);
        String ORGNAME = rw.getCell(2).getStringCellValue()+rndm;
        String INDUSTRY = rw.getCell(3).getStringCellValue();
        String TYPE = rw.getCell(4).getStringCellValue();
       
        
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
		WebElement element=driver.findElement(By.name("industry"));
		Select s=new Select(element);
		s.selectByVisibleText(INDUSTRY);
		
		//Step 8: Select Customer in the Type Drop Down
		WebElement elm=driver.findElement(By.name("accounttype"));
		Select s1=new Select(elm);
		s1.selectByVisibleText(TYPE);
		
		//Step 9: Save
		driver.findElement(By.className("crmbutton")).click();
		
		//Step 10: Validate
		String val=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(val.contains(ORGNAME)) {
			System.out.println(val);
			System.out.println("Test Script Passed");
		}
		else
		{
			System.out.println("Test Script Failed");
		}
		
		//Step 11: Logout to Application
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout Successfully");
		System.out.println("Passed the Script");
		driver.quit();

	}

}
