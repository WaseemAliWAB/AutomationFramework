package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	
	@FindBy(className = "dvHeaderText")
	private WebElement OrgHeaderText;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}

	//Business Libraray
	/**
	 * This method will capture Organization  header text and return it
	 * @return
	 */
	public String getHeaderText()
	{
		return OrgHeaderText.getText();
	}
}
