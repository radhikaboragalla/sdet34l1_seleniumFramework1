package com.vtiger.practiceTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdet34l1.genericutility.ExcelLibrary;
import com.sdet34l1.genericutility.IConstantPath;

public class PracticeDataProvider1Test {

	@Test(dataProvider="loginData")
		public void practiceDataProviderTest(String username,String password) {
			Reporter.log(username+"  ---------->   "+ password,true);
		}
	@DataProvider
	public Object[][] loginData()
	{
		try {
			ExcelLibrary.openExcel(IConstantPath.EXCELFILEPATH);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ExcelLibrary.getMultipleDataFromExcel("Multiple");
	}
	

}
