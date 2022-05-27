package com.vtiger.productTest;
import org.testng.annotations.Test;
import com.sdet34l1.genericutility.BaseClass;
import com.sdet34l1.genericutility.ExcelLibrary;
import com.vtiger.elementrepository.CreateNewProductPage;
import com.vtiger.elementrepository.ProductInformationPage;
import com.vtiger.elementrepository.ProductPage;

public class CreateProductTest extends BaseClass {
	@Test(groups="regression")
	public  void createProductTest(){
	String prodname=ExcelLibrary.getDataFromExcel("organisation",2, 1)+randomNumber;
	ProductPage productpage=new ProductPage(driver);
	CreateNewProductPage createnewproductpage=new CreateNewProductPage(driver);
	homepage.clickProduct(driver);
	productpage.clickProductImg();
	createnewproductpage.createNewProductPage(prodname);
	ProductInformationPage productinformationpage=new ProductInformationPage(driver);
	productinformationpage.validateProductInformationPage();
	javaaccount.assertionThroughEquals(prodname, prodname);
		 
	 }
	

}

