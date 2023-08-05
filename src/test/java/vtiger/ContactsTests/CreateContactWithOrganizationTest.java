package vtiger.ContactsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass {
	
	@Test(groups = "SmokeSuite")
	public void createContactWithOrgTest() throws IOException, InterruptedException {
		
		/*Create Organization*/
		
		/*Read data from Excel*/
		String LASTNAME = eUtil.getDataFromExcel("Contact", 4, 2);
		String ORGNAME = eUtil.getDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
		
		//Step 5: Click on Organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		Reporter.log("Organization link is clicked");
		
		//Step 6: Click on Create Organization Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("Create Organization look up image is clicked");
		
		//Step 7: Create organization with mandatory fields and save it
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.CreateOrganization(ORGNAME);
		Reporter.log("Organization is created");
		
		//Step 9: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		
		/*Create Contact using Organization*/
		//Step 10: Click on Contacts link
		hp.clickOnContactsLink();
		Reporter.log("Contact link is clicked");
		
		//Step 11: Click on Create Contacts look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateConLookUpImg();
		Reporter.log("Create contact look up image is clicked");
		
		//Step 12: Create contact with mandatory fields
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(driver, LASTNAME, ORGNAME);
		Reporter.log("Contact is created");
		
		//Step 17: Validate for contacts
		ContactInfoPage cip = new ContactInfoPage(driver);
		String conHeader = cip.getContactHeader();
		Assert.assertTrue(conHeader.contains(LASTNAME));
		System.out.println(conHeader);
		
	}
	
	@Test
	public void demoTest()
	{
		//Assert.fail();
		System.out.println("demo");
	}
}
