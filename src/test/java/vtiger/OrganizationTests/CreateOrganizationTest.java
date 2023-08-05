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
public class CreateOrganizationTest extends BaseClass {
	
	@Test
	public void createOrganizationTest() throws InterruptedException, IOException {
		
		//Step 1: Read all the required data
		/*Read data from Excel Sheet*/
		String ORGNAME = eUtil.getDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		//Step 4: Click On Organization Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		//Step 5:  Click on Organization Look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 6: Create Organization with Mandatory Fields and save
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.CreateOrganization(ORGNAME);
		        
        //Step 8: Validate
        OrganizationInfoPage oip = new OrganizationInfoPage(driver);
        String orgHeader= oip.getHeaderText();
        Assert.assertTrue(orgHeader.contains(ORGNAME));
        System.out.println(orgHeader);
       
      	}
	
}
