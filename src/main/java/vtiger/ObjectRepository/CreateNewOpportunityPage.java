package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOpportunityPage extends WebDriverUtility{
	
	//Declaration
	@FindBy(name = "potentialname")
	private WebElement OppNameEdt;
	
	@FindBy(id = "related_to_type")
	private WebElement RelatedToDropDown;
	
	@FindBy(xpath = "//input[@id=\"related_to_display\"]/following-sibling:: img [@title=\"Select\"]")
	private WebElement ContactImg;
	
	@FindBy(id = "search_txt")
	private WebElement SearchEdt;
	
	@FindBy(name = "search")
	private WebElement SearchBtn;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement SaveBtn;
	
	//Initialization
	public CreateNewOpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOppNameEdt() {
		return OppNameEdt;
	}

	public WebElement getRelatedToDropDown() {
		return RelatedToDropDown;
	}

	public WebElement getContactImg() {
		return ContactImg;
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
	 * This method will provide Opportunity name and save it
	 * @param OPPNAME
	 */
	public void createOpportunity(String OPPNAME)
	{
		OppNameEdt.sendKeys(OPPNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will provide opportunity name, related to drop down, contact and save it
	 * @param driver
	 * @param OPPNAME
	 * @param RELATEDTO
	 * @param CONTNAME
	 */
	public void createOpportunity(WebDriver driver,String OPPNAME, String RELATEDTO, String LASTNAME)
	{
		OppNameEdt.sendKeys(OPPNAME);
		handleDropDown(RelatedToDropDown, RELATEDTO);
		ContactImg.click();
		switchToWindow(driver, "Contacts");
		SearchEdt.sendKeys(LASTNAME);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()=' "+LASTNAME+"']")).click();
		switchToWindow(driver, "Potentials");
		SaveBtn.click();
	}
	
}
