package vtiger.OrganizationTests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateMultipleOrgWithIndustry extends BaseClass{
	
	@Test(dataProvider = "getData")
	public void createMultipeOrg(String ORG, String INDUSTRY) throws IOException
	{
		
		//Step1: Read all the required data
		/*Read data from Excel sheet*/
		String ORGNAME = ORG + jUtil.getRandomNumber();
		
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
		if(orgHeader.contains(ORGNAME)) {
			System.out.println(orgHeader);
			System.out.println("Test Script Passed");
		}
		else
		{
			
			System.out.println("Test Script Failed");
		}
	    
	}

	@DataProvider	
	public Object[][] getData() throws Throwable, IOException
	{
		 return eUtil.readMultipleData("MultipleOrg");// getting nullPointerException
	}
}
