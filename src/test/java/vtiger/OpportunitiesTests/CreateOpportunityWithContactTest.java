package vtiger.OpportunitiesTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOpportunityPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OpportunitiesPage;
import vtiger.ObjectRepository.OpportunityInfoPage;

public class CreateOpportunityWithContactTest extends BaseClass {
	
	@Test
	public void createOpportunityWithContactTest() throws IOException {
		
		//Step 1: Read all the necessary data
		
		/*Read data from Excel Sheet*/
		String LASTNAME = eUtil.getDataFromExcel("Opportunities", 1, 4);
		String OPPORTNAME = eUtil.getDataFromExcel("Opportunities", 1, 2);
		String RELATEDTO = eUtil.getDataFromExcel("Opportunities", 1, 3);
		
		/*Create Contact*/
		//Step 5: Click on Contacts link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		
		//Step 6: Click on Create Contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateConLookUpImg();
		
		//Step 7: Create contact with mandatory fields and Save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(LASTNAME);
		
		//Step 9: Validate Contact
		ContactInfoPage cip = new ContactInfoPage(driver);
		String conHeader = cip.getContactHeader();
		Assert.assertTrue(conHeader.contains(LASTNAME));
		System.out.println(conHeader);
		
		/*Create Opportunity*/
		//Step 10: Click on Opportunities link
		hp.clickOnOpportunitiesLink();
		
		//Step 11: Click on Create Opportunity look up image
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.clickOnCreateOppLookUpImg();
		
		//Step 12: Create Opportunity with mandatory fields and save it
		CreateNewOpportunityPage cnop = new CreateNewOpportunityPage(driver);
		cnop.createOpportunity(driver, OPPORTNAME, RELATEDTO, LASTNAME);
				
		//Step 16: Validate Opportunity
		OpportunityInfoPage oip = new OpportunityInfoPage(driver);
		String oppHeader = oip.getHeaderText();
		Assert.assertTrue(oppHeader.contains(OPPORTNAME));
		System.out.println(oppHeader);
		
	}
}
