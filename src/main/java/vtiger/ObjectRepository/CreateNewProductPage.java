package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewProductPage extends WebDriverUtility {
	
	//Declaration
	@FindBy(name = "productname")
	private WebElement ProNameEdt;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement VendorLink;
	
	@FindBy(id = "search_txt")
	private WebElement SearchEdt;
	
	@FindBy(name = "search")
	private WebElement SearchBtn;
	
	@FindBy(name = "glacct")
	private WebElement GlAccDropDown;
	
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement SaveBtn;
	
	//Initialisation
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getProNameEdt() {
		return ProNameEdt;
	}

	public WebElement getVendorLink() {
		return VendorLink;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getGlAccDropDown() {
		return GlAccDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Library
	/**
	 * This method will provide product name and save it
	 * @param PRONAME
	 */
	public void createProduct(String PRONAME)
	{
		ProNameEdt.sendKeys(PRONAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will provide product name and Gl acc drop down
	 * @param PRONAME
	 * @param GLACCOUNT
	 */
	public void createProduct(String PRONAME, String GLACCOUNT)
	{
		ProNameEdt.sendKeys(PRONAME);
		handleDropDown(GlAccDropDown, "GLACCOUNT");
		SaveBtn.click();
	}
	
	/**
	 * This method will provide product name, vendor name, gl account drop down and save it
	 * @param driver
	 * @param PRONAME
	 * @param VENNAME
	 * @param GLACCOUNT
	 */
	public void createProduct(WebDriver driver, String PRONAME, String VENNAME, String GLACCOUNT)
	{
		ProNameEdt.sendKeys(PRONAME);
		VendorLink.click();
		switchToWindow(driver, "Vendors");
		SearchEdt.sendKeys(VENNAME);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+VENNAME+"']")).click();
		switchToWindow(driver, "Products");
		SaveBtn.click();
	}
	
}
