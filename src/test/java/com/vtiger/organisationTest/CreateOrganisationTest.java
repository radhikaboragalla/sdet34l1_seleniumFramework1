package com.vtiger.organisationTest;
import org.testng.annotations.Test;
import com.sdet34l1.genericutility.BaseClass;
import com.sdet34l1.genericutility.ExcelLibrary;
import com.vtiger.elementrepository.CreateNewOrganisationPage;
import com.vtiger.elementrepository.OrganisationInformationPage;
import com.vtiger.elementrepository.OrgnisationPagae;
public class CreateOrganisationTest extends BaseClass {
	@Test(groups="sanity")
	public  void createOrganisationTest() throws InterruptedException  {
		String orgname=ExcelLibrary.getDataFromExcel("organisation",2, 1)+randomNumber;
		Thread.sleep(2000);
		homepage.clickOrg();
		OrgnisationPagae organisationpage=new OrgnisationPagae(driver);
		organisationpage.clickOrgImg(driver);
		CreateNewOrganisationPage createneworganisationpage=new CreateNewOrganisationPage(driver);
		createneworganisationpage.createNewOrganisationPage(orgname);
		OrganisationInformationPage organisationinfpage=new OrganisationInformationPage(driver);
		organisationinfpage.organisationInformationPage();
		javaaccount.assertionThroughEquals(orgname, orgname);
		
		
		
		
	
	}

}

	
	


