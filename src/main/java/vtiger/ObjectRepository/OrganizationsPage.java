package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {   //Rule 1: Create a separate pom class for every web page
	
	//Rule 2: Identify the web elements using @FindBy, @FindBys, @FindAll
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement CreateOrgLookUpImg;
	
	//Rule 3: Create a constructor to initialize the web elements
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4: Provide getters to access these web elements
	public WebElement getOrgLink() {
		return CreateOrgLookUpImg;
	}
	
	//Business Library
	/**
	 * This method will click on Create organization look up image
	 */
	public void clickOnCreateOrgLookUpImg()
	{
		CreateOrgLookUpImg.click();
	}
	

	
	
}
