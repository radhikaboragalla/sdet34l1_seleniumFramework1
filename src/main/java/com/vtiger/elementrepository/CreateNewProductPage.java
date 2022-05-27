package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	@FindBy(xpath="//input[@name='productname']")
	private WebElement prodnameTxt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void createNewProductPage(String productname)
	{
		prodnameTxt.sendKeys(productname);
		saveBtn.click();
	}

}
