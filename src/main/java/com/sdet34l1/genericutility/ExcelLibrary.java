package com.sdet34l1.genericutility;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to open the excel sheet
 * @author CSC
 *
 */
public class ExcelLibrary {
 static Workbook wb;
 
 
 public static void openExcel(String filepath) throws EncryptedDocumentException, IOException 
 {
	 FileInputStream fis1=new FileInputStream(filepath);
	 wb=WorkbookFactory.create(fis1);
 }
 /**
  * This method is used to fetch the data from excel sheet
  * @param filepath
  * @param sheetName
  * @param rowNumber
  * @param cellNumber
  * @return
  * @throws EncryptedDocumentException
  * @throws IOException
  */
 
 public static String getDataFromExcel(String sheetName, int rowNumber, int cellNumber )
 {
	 String data=wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	 return (data);
 }
 /**
  * This method is used to get multiple data from excel sheet
  * @param sheetName
  * @return
  */
 public static Object[][] getMultipleDataFromExcel(String sheetName)
 {
	 Sheet sh=wb.getSheet(sheetName);
	 Object[][] arr=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	 for(int i=0;i<sh.getLastRowNum();i++)
	 {
		 for(int j=0;j<sh.getRow(i).getLastCellNum();j++)
		 {
		 arr[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		 }
	 }
	 return arr;
 }
	
 
 /**
 * This method is used to store the data to the excel sheet
  * 
  */
 public static void setDatatoExcel(String sheetName, int rowNumber, int cellNumber, String value)
 {
	 
	wb.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(value);
 }
 
 /**
  * This method is used to save/write the data to excel
 * @throws IOException
  */
 public static void writeDatatoExcel(String path) throws IOException
 {
	 FileOutputStream fos=new FileOutputStream(path);
	 wb.write(fos);
 }
 /**
  * This method is used to close the excel
  * @throws IOException
  */
public static void closeExcel() throws IOException 
{
	
	// TODO Auto-generated method stub
	wb.close();
}
 
 }
