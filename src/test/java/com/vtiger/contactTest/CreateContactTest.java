package com.vtiger.contactTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sdet34l1.genericutility.BaseClass;
import com.sdet34l1.genericutility.ExcelLibrary;
import com.vtiger.elementrepository.ContactInfPage;
import com.vtiger.elementrepository.ContactsPage;
import com.vtiger.elementrepository.CreateNewContactPage;
public class CreateContactTest extends BaseClass{
	@Test(groups="sanity")
	
	public  void createContactTest() throws InterruptedException
	{
	
		String orgname=ExcelLibrary.getDataFromExcel("organisation",2, 1)+randomNumber;
		String lastname=ExcelLibrary.getDataFromExcel("organisation",2, 2)+randomNumber;
		homepage.clickContactsLink();
		ContactsPage contactspage=new ContactsPage(driver);
		
		contactspage.clickcontactsImg();
		CreateNewContactPage createnewcontactpage=new CreateNewContactPage(driver);
		createnewcontactpage.createNewContactPage(lastname);
		
		ContactInfPage contactinfpage=new ContactInfPage(driver);
		
		
		String expname=contactinfpage.getLastName();
		javaaccount.assertionThroughEquals(lastname, expname);
		
	}
        }
        
        
        	
        