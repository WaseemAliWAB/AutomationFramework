package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {   //Rule 1: Create a separate pom class for every web page
	
	//Rule 2: Identify the web elements using @FindBy, @FindBys, @FindAll
	@FindBy(xpath = "//a[@href=\"index.php?module=Accounts&action=index\"]")
	private WebElement OrganizationsLink;
	
	@FindBy(xpath = "//a[@href=\"index.php?module=Contacts&action=index\"]")
	private WebElement ContactsLink;
	
	@FindBy(xpath = "//a[@href=\"index.php?module=Potentials&action=index\"]")
	private WebElement OpportunitiesLink;
	
	@FindBy(xpath = "//a[@href=\"index.php?module=Products&action=index\"]")
	private WebElement ProductsLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/menuDnArrow.gif\"]")
	private WebElement MoreLink;
	
	@FindBy(name = "Vendors")
	private WebElement VendorsLink;
	
	@FindBy(name = "Campaigns")
	private WebElement CampaignsLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;
	
	//Rule 3: Create a constructor to initialize the web elements
		public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	//Rule 4: Provide getters to access these web elements
	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}
	
	public WebElement getContactsLink() {
		return ContactsLink;
	}
		
	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}
	
	public WebElement getProductsLink() {
		return ProductsLink;
	}
	
	
	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}
		
	public WebElement getMoreLink() {
		return MoreLink;
	}

	public WebElement getVendorsLink() {
		return VendorsLink;
	}

	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}
	
	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	//Business Library
	/**
	 * This method will click on the organization link
	 */
	public void clickOnOrganizationsLink()
	{
		OrganizationsLink.click();
	}
			
	/**
	 * This method will click on Contacts link
	 */
	public void clickOnContactsLink()
	{
		ContactsLink.click();
	}
	
	/**
	 * This method will click on Opportunities link
	 */
	public void clickOnOpportunitiesLink()
	{
		OpportunitiesLink.click();
	}
	
	/**
	 * This method will click on Products Link
	 */
	public void clickOnProductsLink()
	{
		ProductsLink.click();
	}
	
	/**
	 * This method will click on vendors link
	 * @param driver
	 */
	public void clickOnVendorsLink(WebDriver driver)
	{
		mouseHoverAction(driver, MoreLink);
		VendorsLink.click();
	}
	
	/**
	 * This method will click on campaigns link
	 * @param driver
	 */
	public void clickOnCampaignsLink(WebDriver driver)
	{
		mouseHoverAction(driver, MoreLink);
		CampaignsLink.click();
	}
			
	/**
	 * This method will logout of Application
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void logoutToApp(WebDriver driver)// throws InterruptedException
	{
		mouseHoverAction(driver,AdministratorImg);
		//Thread.sleep(1000);
		SignOutLink.click();
				
	}
		
		
	}
