package com.vtiger.contactTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sdet34l1.genericutility.BaseClass;
import com.sdet34l1.genericutility.ExcelLibrary;
import com.sdet34l1.genericutility.FileProfit;
import com.sdet34l1.genericutility.IConstantPath;
import com.sdet34l1.genericutility.JavaAccount;
import com.sdet34l1.genericutility.WebDriverCentre;
import com.vtiger.elementrepository.CreateNewContactPage;
import com.vtiger.elementrepository.ContactInfPage;
import com.vtiger.elementrepository.ContactsPage;
import com.vtiger.elementrepository.CreateNewOrganisationPage;
import com.vtiger.elementrepository.HomePage;
import com.vtiger.elementrepository.LoginPage;
import com.vtiger.elementrepository.OrgnisationPagae;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithorgTest extends BaseClass {
	@Test(groups="regression")
	public void createContactWithorgTest() throws InterruptedException
	{
		
		String orgname=ExcelLibrary.getDataFromExcel("organisation",2, 1)+randomNumber;
		String lastname=ExcelLibrary.getDataFromExcel("organisation",2, 2)+randomNumber;
		
		
		OrgnisationPagae organisationpage=new OrgnisationPagae(driver);
		CreateNewOrganisationPage createneworganisationpage=new CreateNewOrganisationPage(driver);
		ContactsPage contactspage=new ContactsPage(driver);
		CreateNewContactPage createnewcontactpage=new CreateNewContactPage(driver);
		ContactInfPage contactinfpage=new ContactInfPage(driver);
		
		homepage.clickOrg();
        
		organisationpage.clickOrgImg(driver);
        
		createneworganisationpage.createNewOrganisationPage1(orgname);
        
       //WebElement vv = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		//WebDriverWait wait=new WebDriverWait(driver,1000);
		//wait.until(ExpectedConditions.visibilityOf(vv));  
		//webDriverCentre.waitUntillElementVisible(headerText1);
		WebDriverCentre.waitUntillElementVisible(homepage.getHeaderText());
        homepage.clickContactsLink();
       
        contactspage.clickcontactsImg();
       
        createnewcontactpage.createContactWithOrg(lastname,driver,orgname);
        String exporg=contactinfpage.getOrgName();
        javaaccount.assertionThroughEquals(orgname, lastname);
        
      
	}
}
        
        


