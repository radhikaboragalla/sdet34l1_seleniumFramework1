package com.vtiger.documentsTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sdet34l1.genericutility.BaseClass;
import com.sdet34l1.genericutility.ExcelLibrary;
import com.vtiger.elementrepository.CreateNewDocumentPage;
import com.vtiger.elementrepository.DocumentsPage;
public class CreateDocumentsTest extends BaseClass {
	@Test(groups={"sanity","regression"})
	public  void createDocumentsTest() throws InterruptedException
	{
		String titlename=ExcelLibrary.getDataFromExcel("documents", 2, 1);
		String description=ExcelLibrary.getDataFromExcel("documents", 2, 3);
		String path=ExcelLibrary.getDataFromExcel("documents", 2, 2);
	    homepage.clickDocumentLink();
        DocumentsPage documentspage=new DocumentsPage(driver);
		documentspage.clickdocumentImg();
        CreateNewDocumentPage createnewdocumentpage=new CreateNewDocumentPage(driver);
 		
        // Thread.sleep(2000);
        String exptitle=createnewdocumentpage.createnewDocument(titlename, driver, description,path);
       
        javaaccount.assertionThroughEquals(titlename, exptitle);
       
	}
	
        }

   
        
        