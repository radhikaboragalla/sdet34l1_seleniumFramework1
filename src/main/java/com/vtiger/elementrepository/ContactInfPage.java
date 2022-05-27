package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfPage {
	@FindBy(xpath="//span[@id='dtlview_Last Name']")
	private WebElement validateLastnameTxt;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement expOrgname;
	
	
	public ContactInfPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String getLastName()
	{
		return validateLastnameTxt.getText();
	}
	public String getOrgName()
	{
		return expOrgname.getText();
		
	}
	
	

}
