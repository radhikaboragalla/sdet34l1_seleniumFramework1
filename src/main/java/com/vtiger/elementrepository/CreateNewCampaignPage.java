package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement createCampaignTxt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void createCampaign(String campaignname)
	{
		createCampaignTxt.sendKeys(campaignname);
		saveBtn.click();
	}
	

}
