package com.vtiger.campaignsTest;
import org.testng.annotations.Test;
import com.sdet34l1.genericutility.BaseClass;
import com.sdet34l1.genericutility.ExcelLibrary;
import com.vtiger.elementrepository.CampaignPage;
import com.vtiger.elementrepository.CreateNewCampaignPage;
public class CreateCampaignsTest extends BaseClass {
	@Test(groups="regression")
	 public  void createCampaignsTest() throws InterruptedException {
		
		String campaignname=ExcelLibrary.getDataFromExcel("campaigns",2, 1)+randomNumber;
		CampaignPage campaignpage=new CampaignPage(driver);
		CreateNewCampaignPage createnewcampaignpage=new CreateNewCampaignPage(driver);
	    homepage.moreMouseoveraction(webDriverCentre);
	    homepage.clickmoreDropown(driver);
		//Thread.sleep(2000);
		homepage.clickCampaign(driver);
		campaignpage.clickCampaign();
		createnewcampaignpage.createCampaign(campaignname);
		javaaccount.assertionThroughEquals(campaignname, campaignname);
		

	}
}


