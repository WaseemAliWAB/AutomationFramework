package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	
	//Declaration
	@FindBy(className = "lvtHeaderText")
	private WebElement ProHeaderText;
	
	//Initialisation
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getProHeaderText() {
		return ProHeaderText;
	}
	
	//Business Library
	/**
	 * This method will capture Product header and return it
	 * @return
	 */
	public String getHeaderText()
	{
		return ProHeaderText.getText();
	}
	
	
}
