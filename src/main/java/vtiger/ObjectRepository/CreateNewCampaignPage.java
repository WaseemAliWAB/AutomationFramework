package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewCampaignPage extends WebDriverUtility{
	
	//declaration
	@FindBy(name = "campaignname")
	private WebElement CampaignNameEdt;
	
	@FindBy(name = "campaigntype")
	private WebElement CampTypeDrpDwn;
	
	@FindBy(name = "campaignstatus")
	private WebElement CampStatusDrpDwn;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement ProductLink;
	
	@FindBy(id = "search_txt")
	private WebElement SearchEdt;
	
	@FindBy(name = "search")
	private WebElement SearchBtn;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement SaveBtn;
	
	//Initialisation
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCampaignNameEdt() {
		return CampaignNameEdt;
	}

	public WebElement getCampTypeDrpDwn() {
		return CampTypeDrpDwn;
	}

	public WebElement getCampStatusDrpDwn() {
		return CampStatusDrpDwn;
	}

	public WebElement getAddProductDrpDwn() {
		return ProductLink;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Library
	/**
	 * This method will provide Campaign name and save it
	 * @param CAMPNAME
	 */
	public void createCampaign(String CAMPNAME)
	{
		CampaignNameEdt.sendKeys(CAMPNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will provide Campaign name, campaign type drop down and save it
	 * @param CAMPNAME
	 * @param CAMPTYPE
	 */
	public void createCampaign(String CAMPNAME, String CAMPTYPE)
	{
		CampaignNameEdt.sendKeys(CAMPNAME);
		handleDropDown(CAMPTYPE, CampTypeDrpDwn);
		SaveBtn.click();
	}
	
	/**
	 * This method will provide Campaign name, camp status, camp type, product and save it
	 * @param driver
	 * @param CAMPNAME
	 * @param CAMPTYPE
	 * @param CAMPSTATUS
	 * @param PRODUCT
	 */
	public void createCampaign(WebDriver driver,String CAMPNAME, String CAMPTYPE, String CAMPSTATUS, String PRODUCT)
	{
		CampaignNameEdt.sendKeys(CAMPNAME);
		handleDropDown(CAMPTYPE, CampTypeDrpDwn);
		handleDropDown(CAMPSTATUS, CampStatusDrpDwn);
		ProductLink.click();
		switchToWindow(driver, "Products");
		SearchEdt.sendKeys(PRODUCT);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+PRODUCT+"']")).click();
		switchToWindow(driver, "Campaigns");
		SaveBtn.click();
		
	}
	
}
