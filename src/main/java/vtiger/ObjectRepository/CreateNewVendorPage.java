package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewVendorPage extends WebDriverUtility {
	
	//Declaration
	@FindBy(name = "vendorname")
	private WebElement VendorNameEdt;
	
	@FindBy(name = "glacct")
	private WebElement GlAccountDrpDwn;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement SaveBtn;
	
	//Initialisation
	public CreateNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getVendorName() {
		return VendorNameEdt;
	}

	public WebElement getGlAccountDrpDwn() {
		return GlAccountDrpDwn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Library
	/**
	 * This method will provide vendor name and save it
	 * @param VENDNAME
	 */
	public void createVendor(String VENDNAME)
	{
		VendorNameEdt.sendKeys(VENDNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will provide vendor name, Gl account drop down and save it
	 * @param VENDNAME
	 * @param GLACCOUNT
	 */
	public void createVendor(String VENDNAME, String GLACCOUNT)
	{
		VendorNameEdt.sendKeys(VENDNAME);
		handleDropDown(GLACCOUNT, GlAccountDrpDwn);
	}
	
}
