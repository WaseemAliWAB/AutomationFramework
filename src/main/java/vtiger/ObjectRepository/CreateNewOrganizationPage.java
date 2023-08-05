package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{   //Rule 1: Create a separate  pom class for every web page
	
	//Rule 2: Identify the web elements using @FindBy, @FindBys, @FindAll
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement IndustryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement TypeDropDown;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement SaveBtn;
	
	//Rule 3: Create a constructor to initialise the web elements 
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4: Provide getters to access these web elements
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	
	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getTypeDropDown() {
		return TypeDropDown;
	}	
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Libraray - project specific generic method
	/**
	 * This method will provide organization name and save it
	 * @param ORGNAME
	 */
	public void CreateOrganization(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will provide Organization name, Industry drop down and save it
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void CreateOrganization(String ORGNAME, String INDUSTRY)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDown, INDUSTRY);
		SaveBtn.click();
	}
	
	/**
	 * This method will provide Organization name, Industry and Type drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param TYPE
	 */
	public void CreateOrganization(String ORGNAME, String INDUSTRY, String TYPE)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDown, INDUSTRY);
		handleDropDown(TypeDropDown, TYPE);
		SaveBtn.click();
	}
}
