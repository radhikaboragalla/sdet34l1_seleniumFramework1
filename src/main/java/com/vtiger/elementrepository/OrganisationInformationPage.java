package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInformationPage {
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement exporgnameText;
	
	
	public OrganisationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public String organisationInformationPage()
	{
		return exporgnameText.getText();
	}
	

}
