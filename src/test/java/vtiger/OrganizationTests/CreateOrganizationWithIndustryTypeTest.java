package vtiger.OrganizationTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateOrganizationWithIndustryTypeTest extends BaseClass {
	
	@Test(groups = "RegressionSuite")
	public void createOrgWithIndustryTypeTest() throws IOException {
		
		//Step 1: Read all the required data
	    /*Read data from Excel Sheet*/
	    String ORGNAME = eUtil.getDataFromExcel("Organization", 7, 2)+jUtil.getRandomNumber();
	    String INDUSTRY = eUtil.getDataFromExcel("Organization", 7, 3);
	    String TYPE = eUtil.getDataFromExcel("Organization", 7, 4);
	    
		//Step 4: Click on Organization Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		//Step 5: Click on Create Organization Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 6: Create Organization with Mandatory Fields and select energy in industry drop down 
		//and customer in type drop down and save it
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.CreateOrganization(ORGNAME, INDUSTRY, TYPE);
		
		//Step 10: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		
	}	
	
	@Test
	public void sampleTest()
	{
		System.out.println("sample");
	}

}
