package com.vtiger.practiceTest;

import org.testng.annotations.Test;

import com.sdet34l1.genericutility.BaseClass;
import com.sdet34l1.genericutility.ExcelLibrary;
import com.vtiger.elementrepository.CampaignPage;
import com.vtiger.elementrepository.CreateNewCampaignPage;
import com.vtiger.elementrepository.CreateNewProductPage;
import com.vtiger.elementrepository.CreatingNewCampaignPage;
import com.vtiger.elementrepository.ProductPage;

public class TestngCampaignTest extends BaseClass {
	@Test(groups="regression")
	 public  void createCampaignsTest() {
		
		String campaignname=ExcelLibrary.getDataFromExcel("campaigns",2, 1)+randomNumber;
		CampaignPage campaignpage=new CampaignPage(driver);
		CreateNewCampaignPage createnewcampaignpage=new CreateNewCampaignPage(driver);
		homepage.clickCampaign(driver);
		campaignpage.clickCampaign();
		createnewcampaignpage.createCampaign(campaignname);
		javaaccount.assertionThroughEquals(campaignname, campaignname);
		

}
	  
		@Test(groups="sanity")
		public void createProductFromMoreCampaignTest() throws InterruptedException
		{
			String campaignname=ExcelLibrary.getDataFromExcel("products", 4, 1)+randomNumber;
			 String productname=ExcelLibrary.getDataFromExcel("products", 4, 2)+randomNumber;

			ProductPage productpage=new ProductPage(driver);
			CreateNewProductPage createnewproductpage=new CreateNewProductPage(driver);
			CampaignPage campaignpage=new CampaignPage(driver);
			CreatingNewCampaignPage createnewcampaignpage=new CreatingNewCampaignPage(driver);
					
			Thread.sleep(1000);
			
			homepage.clickProduct(driver);
			productpage.clickProductImg();
			createnewproductpage.createNewProductPage(productname);
			
			homepage.clickCampaign(driver);
			campaignpage.clickCampaign();
			createnewcampaignpage.createingNewCampaignPage(campaignname, driver, productname);
			
			
			
		}
		

	}


