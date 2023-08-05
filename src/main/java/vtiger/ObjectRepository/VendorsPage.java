package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	
	//Declaration
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement CreateVenLookUpImg;
	
	//Initialisation
	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateVenLookUpImg() {
		return CreateVenLookUpImg;
	}
	
	//Business Library
	/**
	 * This method will click on create vendor look up image
	 */
	public void clickOnCreateVenLookUpImg()
	{
		CreateVenLookUpImg.click();
	}
	
	
}
