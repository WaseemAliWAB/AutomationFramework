package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage {
	
	//Declaration
	@FindBy(className = "dvHeaderText")
	private WebElement OppHeaderText;
	
	//Initialisation
	public OpportunityInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOppHeaderText() {
		return OppHeaderText;
	}
	
	//Business Library
	/**
	 * This method will capture the Opportunity header text and return it
	 * @return
	 */
	public String getHeaderText()
	{
		return OppHeaderText.getText();
	}
		
}
