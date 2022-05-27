package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericutility.WebDriverCentre;

public class CreatingNewCampaignPage {
	@FindBy(name="campaignname")
	private WebElement campnameTxt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//img[@style='cursor:hand;cursor:pointer']")
	private WebElement prodImg;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchTxt;
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private WebElement selectedProdname;
	
	public CreatingNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void createingNewCampaignPage(String campaignname, WebDriver driver, String prodname)
	{
		campnameTxt.sendKeys(campaignname);
		
		prodImg.click();
		WebDriverCentre.switchToWindowBasedOnTitle(driver, "Products");
		searchTxt.sendKeys(prodname);
		searchBtn.click();
		selectedProdname.click();
		WebDriverCentre.switchToWindowBasedOnTitle(driver, "Campaigns");
		saveBtn.click();
	}

}
