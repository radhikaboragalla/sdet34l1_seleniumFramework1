package com.vtiger.elementrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericutility.WebDriverCentre;

public class CreateNewDocumentPage {
	@FindBy(xpath="//input[@name='notes_title']")
	private WebElement titleTxt;
	
	@FindBy(xpath="//iframe[@title='Rich text editor, notecontent, press ALT 0 for help.']")
	private WebElement createDocumentDescriptionTxt;
	
	@FindBy(xpath="//body[@class='cke_show_borders']")
	private WebElement descriptionTxt;
	
	@FindBy(xpath="//a[@id='cke_5']")
	private WebElement clickBold;
	
	@FindBy(xpath="//a[@id='cke_6']")
	private WebElement clickItalics;
		
	@FindBy(xpath="//input[@name='filename']")
	private WebElement createUploadFile;
	
	@FindBy(xpath="//b[text()='File Information']/../../following-sibling::tr[4]//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//span[@id='dtlview_Title']")
	private WebElement exp_title;
	
	
	
	
public 	CreateNewDocumentPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public String createnewDocument(String titlename, WebDriver driver, String description,String path)
{
	titleTxt.sendKeys(titlename);
	WebDriverCentre.switchToFrameByElement(driver,createDocumentDescriptionTxt);
	descriptionTxt.sendKeys(description,Keys.CONTROL+"ac");
	WebDriverCentre.switchToFrameByDefaultContent(driver);
	clickBold.click();
	clickItalics.click();
	createUploadFile.sendKeys(path);
	saveBtn.click();
	return exp_title.getText();
	
	
	

	
}
}
