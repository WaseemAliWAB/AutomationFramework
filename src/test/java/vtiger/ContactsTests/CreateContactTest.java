package vtiger.ContactsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;


public class CreateContactTest extends BaseClass {
	
			@Test
			public void createContactTest() throws IOException, InterruptedException  {
		
			//Step1: Read all the necessary data
			
			/*Read data from Excel Sheet - Test data*/
			String LASTNAME = eUtil.getDataFromExcel("Contact", 1, 2);		
			
			//Step 4: Click on Contact Link
			HomePage hp = new HomePage(driver);
			hp.clickOnContactsLink();
			
			//Step 5: Click on Create Contact Look Up Image
			ContactsPage cp = new ContactsPage(driver);
			cp.clickOnCreateConLookUpImg();
			
			//Step 6: Create Contact with mandatory fields and save it
			CreateNewContactPage cncp = new CreateNewContactPage(driver);
			cncp.createContact(LASTNAME);
			
			//Step 8: Validation
			ContactInfoPage cip = new ContactInfoPage(driver);
			String conHeader = cip.getContactHeader();
			Assert.assertTrue(conHeader.contains(LASTNAME));
			System.out.println(conHeader);
		
		}
	
}
