package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnisationPagae {
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorgImg;
	
	public  OrgnisationPagae(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 * This method is used to click on create Organisation Img
	 * @param driver
	 */
	public void clickOrgImg(WebDriver driver)
	{
		createorgImg.click();
	}
	
	

}
