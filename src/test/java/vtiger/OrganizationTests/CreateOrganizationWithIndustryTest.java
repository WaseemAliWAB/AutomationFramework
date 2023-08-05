package vtiger.OrganizationTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrganizationWithIndustryTest extends BaseClass {
	
	@Test
	public void createOrgwithIndustryTest() throws IOException{

		//Step1: Read all the required data
		/*Read data from Excel Sheet*/
		String ORGNAME = eUtil.getDataFromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.getDataFromExcel("Organization", 4, 3);
		
		//Step 4: Click on Organization Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		//Step 5: Click on Create Organization Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 6: Create Organization with mandatory fields and choose Chemicals on industry drop down and save it
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.CreateOrganization(ORGNAME, INDUSTRY);
		
		//Step 9: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
	    
	}

		
}
