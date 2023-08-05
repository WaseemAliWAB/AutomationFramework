package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {
	
	@FindBy(className = "lvtHeaderText")
	private WebElement VenHeaderText;
	
	public VendorInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getVenHeaderText() {
		return VenHeaderText;
	}
	
	//Business Library
	/**
	 * This method will capture vendor header and return it
	 * @return
	 */
	public String getHeaderText()
	{
		return VenHeaderText.getText();
	}
	
}
