package com.vtiger.campaignsTest;

import org.testng.annotations.Test;

import com.sdet34l1.genericutility.BaseClass;
import com.sdet34l1.genericutility.ExcelLibrary;
import com.vtiger.elementrepository.CampaignPage;
import com.vtiger.elementrepository.CreateNewProductPage;
import com.vtiger.elementrepository.CreatingNewCampaignPage;
import com.vtiger.elementrepository.ProductPage;

public class CreateProductFromMoreCampaignTest extends BaseClass {
	@Test(groups="sanity")
	public void createProductFromMoreCampaignTest() throws InterruptedException
	{
		String campaignname=ExcelLibrary.getDataFromExcel("products", 4, 1)+randomNumber;
		 String productname=ExcelLibrary.getDataFromExcel("products", 4, 2)+randomNumber;

		ProductPage productpage=new ProductPage(driver);
		CreateNewProductPage createnewproductpage=new CreateNewProductPage(driver);
		CampaignPage campaignpage=new CampaignPage(driver);
		CreatingNewCampaignPage createnewcampaignpage=new CreatingNewCampaignPage(driver);
		
		homepage.clickProduct(driver);
		productpage.clickProductImg();
		createnewproductpage.createNewProductPage(productname);
		homepage.moreMouseoveraction(webDriverCentre);
		homepage.clickCampaign(driver);
		campaignpage.clickCampaign();
		createnewcampaignpage.createingNewCampaignPage(campaignname, driver, productname);
		javaaccount.assertionThroughEquals(campaignname, productname);
		
		
	}
	

}

