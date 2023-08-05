package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	//Declaration
	@FindBy(className = "dvHeaderText")
	private WebElement ConHeaderText;
	
	//Initialisation
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getConHeaderText() {
		return ConHeaderText;
	}
	
	//Business Libraray
	/**
	 * This method will capture Contact header text and return it
	 * @return
	 */
	public String getContactHeader()
	{
		return ConHeaderText.getText();
	}
	
	
}
