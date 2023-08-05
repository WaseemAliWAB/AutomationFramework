package vtiger.ProductsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewProductPage;
import vtiger.ObjectRepository.CreateNewVendorPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.ProductInfoPage;
import vtiger.ObjectRepository.ProductsPage;
import vtiger.ObjectRepository.VendorInfoPage;
import vtiger.ObjectRepository.VendorsPage;

public class CreateProductWithVendorTest extends BaseClass {
	
	@Test
	public void cteateProductWithvendortest() throws IOException {
				
		//Step 1: Read all the necessary data
		/*Read data from Excel Sheet*/
		String PRODNAME = eUtil.getDataFromExcel("Products", 1, 2);
		String VENDNAME = eUtil.getDataFromExcel("Products", 1, 3);
		String GLACCOUNT = eUtil.getDataFromExcel("Products", 1, 4);
		
		/*Create Vendor*/
		//Step 5: navigate to more and click on Vendors Link
		HomePage hp = new HomePage(driver);
		hp.clickOnVendorsLink(driver);
		
		//Step 7: Click on Create Vendor look up image
		VendorsPage vp = new VendorsPage(driver);
		vp.clickOnCreateVenLookUpImg();
		
		//Step 8: Create Vendor with mandatory fields and save it
		CreateNewVendorPage cnvp = new CreateNewVendorPage(driver);
		cnvp.createVendor(VENDNAME);
		
		//Step 10: Validate Vendor
		VendorInfoPage vip = new VendorInfoPage(driver);
		String venHeader = vip.getHeaderText();
		Assert.assertTrue(venHeader.contains(VENDNAME));
		System.out.println(venHeader);
		
		/*Create product with a Vendor*/
		//Step 11: Click on Products link
		hp.clickOnProductsLink();
		
		//Step 12: Click on Create Product look up image
		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnCreateProLookUpImg();
		
		//Step 13: Create product with mandatory fields
		CreateNewProductPage cnpp = new CreateNewProductPage(driver);
		cnpp.createProduct(driver, PRODNAME, VENDNAME, GLACCOUNT);
		
		//Step 19: Validate Product
		ProductInfoPage pip = new ProductInfoPage(driver);
		String proHeader = pip.getHeaderText();
		Assert.assertTrue(proHeader.contains(PRODNAME));
		System.out.println(proHeader);
		
	}
}		
		
		
		
		
		
		
		
		