package com.vtiger.practiceTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDatafromPropertyTest {
	public static void main(String[]args) throws EncryptedDocumentException, IOException {
FileInputStream fis=new FileInputStream("./src/test/resources/ttt.xlsx");
Workbook wb=WorkbookFactory.create(fis);
Sheet sh=wb.getSheet("Multiple");
for(int i=0;i<sh.getLastRowNum();i++)
{
	for(int j=0;j<sh.getRow(0).getLastCellNum();j++)
	{
		System.out.println(sh.getRow(i).getCell(j).getStringCellValue()+" ");
	}
		System.out.println();
}
}
}


