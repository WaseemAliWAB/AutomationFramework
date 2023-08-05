package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	//Declaration
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement CreateProLookUpImg;
	
	//Initialization
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilisation
	public WebElement getCreateProLookUpImg() {
		return CreateProLookUpImg;
	}
	
	//Business Library
	/**
	 * This method will click on Create Product look up image
	 */
	public void clickOnCreateProLookUpImg()
	{
		CreateProLookUpImg.click();
	}
	
}
