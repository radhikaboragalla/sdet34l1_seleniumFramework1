package com.vtiger.practiceTest;

import org.testng.annotations.Test;
import com.sdet34l1.genericutility.BaseClass;
import com.sdet34l1.genericutility.ExcelLibrary;
import com.vtiger.elementrepository.CampaignPage;
import com.vtiger.elementrepository.CreateNewCampaignPage;

public class CreateCampaignTestPractice extends BaseClass{
	@Test
public  void createCampaignTest() {
		String campaignname=ExcelLibrary.getDataFromExcel("campaigns",2, 1)+randomNumber;
		CampaignPage campaignpage=new CampaignPage(driver);
		CreateNewCampaignPage createnewcampaignpage=new CreateNewCampaignPage(driver);
		homepage.clickCampaign(driver);
		campaignpage.clickCampaign();
		createnewcampaignpage.createCampaign(campaignname);
		
	}
}
		 
		
		
		
