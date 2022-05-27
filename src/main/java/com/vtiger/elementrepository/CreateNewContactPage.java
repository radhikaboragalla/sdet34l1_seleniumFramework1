package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericutility.WebDriverCentre;

public class CreateNewContactPage {
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastnameTxt;
	
	@FindBy(xpath="//td[contains(.,'Organization Name') and @class='dvtCellLabel']/following-sibling::td[@class='dvtCellInfo']/img")
	private WebElement orgnameImg;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchOrgTxt;
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchOrgBtn;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private WebElement selectedOrgnName;
	
	
			
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement expOrgname;
	
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	

	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void createNewContactPage(String lastname)
	{
		lastnameTxt.sendKeys(lastname);
		saveBtn.click();
	}
	
	
	
	public String createContactWithOrg(String lastname,WebDriver driver, String orgname)
	{
		lastnameTxt.sendKeys(lastname);
		orgnameImg.click();
		  
		WebDriverCentre.switchToWindowBasedOnTitle(driver, "Organisations");
		searchOrgTxt.sendKeys(orgname);
		searchOrgBtn.click();
		selectedOrgnName.click();
		
		WebDriverCentre.switchToWindowBasedOnTitle(driver,"Contacts");
		
		saveBtn.click();
		WebDriverCentre.explicitlyWait(driver, 10);
		WebDriverCentre.waitUntillElementVisible(headerText);
		return expOrgname.getText();
		
         
	}

	
	
}
