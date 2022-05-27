package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericutility.WebDriverCentre;

public class CreateNewOrganisationPage {
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgnameTxt;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industry;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement type;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	
	/**
	 * This method is used to validate the orgname with exporgname
	 * @param exporgnameTxt 
	 * @param driver
	 */
	public String exporgname()
	{
		return orgnameTxt.getText();
	}
	
	
	public CreateNewOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void createNewOrganisationPage(String orgname)
	{
		orgnameTxt.sendKeys(orgname);
		saveBtn.click();
	}
  public void createNewOrganisationPage1(String orgname) throws InterruptedException
  {
	  orgnameTxt.sendKeys(orgname);
	  WebDriverCentre.initializeSelect(industry);
	  WebDriverCentre.dropdownByValue("Education");
	 
	  WebDriverCentre.initializeSelect(type);
	  WebDriverCentre.dropdownByValue("Press");
	  WebDriverCentre.waitUntilElementClickable(saveBtn);
	
	  saveBtn.click();
  }
}
