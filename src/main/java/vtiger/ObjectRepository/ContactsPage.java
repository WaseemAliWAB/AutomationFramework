package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//Declaration
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement CreateConLookUpImg;
	
	//Initialisation
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateConLookUpImg() {
		return CreateConLookUpImg;
	}
	
	//Business Library/**
	/**
	 * This method will click on Create contact look up image
	 */
	public void clickOnCreateConLookUpImg()
	{
		CreateConLookUpImg.click();
	}
	
	
}
