package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	
	@FindBy(className = "dvHeaderText")
	private WebElement CamHeaderText;
	
	public CampaignInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCamHeaderText() {
		return CamHeaderText;
	}
	
	//Business Library
	/**
	 * This method will capture campaign header text and return it
	 * @return
	 */
	public String getCampHeaderText()
	{
		return CamHeaderText.getText();
	}
	
}
