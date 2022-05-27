package com.vtiger.organisationTest;
import org.testng.annotations.Test;
import com.sdet34l1.genericutility.BaseClass;
import com.sdet34l1.genericutility.ExcelLibrary;
import com.vtiger.elementrepository.CreateNewOrganisationPage;
import com.vtiger.elementrepository.OrganisationInformationPage;
import com.vtiger.elementrepository.OrgnisationPagae;

public class CreateOrganisationWithIndustryTest extends BaseClass {
	@Test(groups= {"sanity","regression"})
	public  void createOrganisationWithIndustryTest() throws InterruptedException { 
	String orgname=ExcelLibrary.getDataFromExcel("organisation",2, 1)+randomNumber;
	OrgnisationPagae organisationpage=new OrgnisationPagae(driver);
	CreateNewOrganisationPage createneworganisationpage=new CreateNewOrganisationPage(driver);
	OrganisationInformationPage organisationinfpage=new OrganisationInformationPage(driver);
	homepage.clickOrg();
	organisationpage.clickOrgImg(driver);
	createneworganisationpage.createNewOrganisationPage1(orgname);
	String exporgname=organisationinfpage.organisationInformationPage();
	javaaccount.assertionThroughEquals(orgname, exporgname);
				
				
				
				
				
					


}
}



