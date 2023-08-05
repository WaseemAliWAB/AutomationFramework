package vtiger.CompaignsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CampaignInfoPage;
import vtiger.ObjectRepository.CampaignsPage;
import vtiger.ObjectRepository.CreateNewCampaignPage;
import vtiger.ObjectRepository.CreateNewProductPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.ProductInfoPage;
import vtiger.ObjectRepository.ProductsPage;

public class CreateCampaignWithCampTypeCampStatusAndProductTest extends BaseClass {

		@Test
		public void createCamWithCampTypeStatusAndProductTest() throws IOException {
			
			//Step 1: Read all the necessary data
			/*Read data from Excel Sheet*/
			String CAMPNAME = eUtil.getDataFromExcel("Campaign", 1, 2);
			String CAMPTYPE = eUtil.getDataFromExcel("Campaign", 1, 3);
			String CAMPSTATUS = eUtil.getDataFromExcel("Campaign", 1, 4);
			String PRODUCT = eUtil.getDataFromExcel("Campaign", 1, 5);
						
			/*Create Product*/
			//Step 5: Click on product link
			HomePage hp = new HomePage(driver);
			hp.clickOnProductsLink();
			
			//Step 6: Click on Create product look up image
			ProductsPage pp = new ProductsPage(driver);
			pp.clickOnCreateProLookUpImg();
			
			//Step 7: Create product with mandatory fields and save
			CreateNewProductPage cnpp = new CreateNewProductPage(driver);
			cnpp.createProduct(PRODUCT);
			
			//Step 9: Verify product
			ProductInfoPage pip = new ProductInfoPage(driver);
			String prodHeader = pip.getHeaderText();
			Assert.assertTrue(prodHeader.contains(PRODUCT));
			System.out.println(prodHeader);
			
			/*Create Campaign*/
			//Step 10: Click on Campaigns Link
			hp.clickOnCampaignsLink(driver);
			
			//Step 11: Click on Create Campaign look up image
			CampaignsPage cp = new CampaignsPage(driver);
			cp.clickOnCreateCamLookUpImg();
			
			//Step 12: Create Camapign with mandatory fields
			CreateNewCampaignPage cncp = new CreateNewCampaignPage(driver);
			cncp.createCampaign(driver, CAMPNAME, CAMPTYPE, CAMPSTATUS, PRODUCT);
			
			//Step 18: Validate Campaign
			CampaignInfoPage cip = new CampaignInfoPage(driver);
			String campHeader = cip.getCampHeaderText();
			Assert.assertTrue(campHeader.contains(CAMPNAME));
			System.out.println(campHeader);
			
		}
}
