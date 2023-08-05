package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	//Declaration
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement CreateOppLookUpImg;
	
	//Initialisation
	public OpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateOppLookUpImg() {
		return CreateOppLookUpImg;
	}
	
	//Business Library
	/**
	 * This method will click on Create Opportunity look up image
	 */
	public void clickOnCreateOppLookUpImg()
	{
		CreateOppLookUpImg.click();
	}
	
}
