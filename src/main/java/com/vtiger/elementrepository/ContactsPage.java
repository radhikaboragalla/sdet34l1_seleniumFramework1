package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement contactsImg;
	
	//Constructor
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 * This method is used to click on contactsImg
	 */
	public void clickcontactsImg()
	{
		contactsImg.click();
	}
	
	

}
