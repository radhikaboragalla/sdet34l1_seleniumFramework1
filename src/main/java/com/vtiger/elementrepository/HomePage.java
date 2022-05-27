package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.sdet34l1.genericutility.WebDriverCentre;

public class HomePage {
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreDropown;
	
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaignTab;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrationDropdown;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutLink;
	
	@FindBy(linkText="Products")
	private WebElement productTab;
	
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	private WebElement orgLink;
	
	//@FindBy(xpath="//span[@class='dvHeaderText']")
	//private WebElement headerText1;
	
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactsLink;
	
	@FindBy(xpath="//a[text()='Documents']")
	private WebElement documentLink;
	
	@FindBy(xpath="//span[@class='small']")
	private WebElement headerText;
	
	@FindBy(xpath = "//a[contains(.,'Home')]")
	private WebElement homepageHeaderText;
	
	public void clickDocumentLink()
	{
		documentLink.click();
	}
	public WebElement getHeaderText() {
		return headerText;
	}
	
	/**
	 * This method is used to click on contacts link
	 * @throws InterruptedException 
	 */
	public void clickContactsLink() throws InterruptedException 
	{
		
		contactsLink.click();
	}
	/**
	 * This method is used to click on organisation
	 */
	public void clickOrg()
	{
		orgLink.click();
	}
	
	
	public void clickProduct(WebDriver driver)
	{
		WebDriverCentre.explicitlyWait(driver, 10);
		WebDriverCentre.waitUntillElementVisible(homepageHeaderText);
		productTab.click();
	}
	//constructor
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	/**
	 * This method is used to click on campaign module
	 */
	public void clickCampaign(WebDriver driver)
	{
		campaignTab.click();
	}
	/**
	 * This method is used to 
	 */
	/**z
	 * This method is used to logout from application
	 * @param driver 
	 * @param longTimeOut 
	 * @param driver 
	 * @param driver
	 * @param longTimeOut 
	 * @throws InterruptedException 
	 */
	public void signOutAction(WebDriverCentre webDriverCentre)  
	{
	WebDriverCentre.waitUntillElementVisible(headerText);
		webDriverCentre.mouseHoverOntheElement(administrationDropdown);
		signoutLink.click();
		
	}
	
	
	public WebElement homepageHeaderText() {
		return homepageHeaderText;
	}
	public void clickmoreDropown(WebDriver driver)
	{
		WebDriverCentre.explicitlyWait(driver, 10);
		WebDriverCentre.waitUntillElementVisible(moreDropown);
		
	}
	public void moreMouseoveraction(WebDriverCentre webDriverCentre) {
		webDriverCentre.mouseHoverOntheElement(moreDropown);
	}

	 
	
	

}
