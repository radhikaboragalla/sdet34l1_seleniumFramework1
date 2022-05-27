package com.sdet34l1.genericutility;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import com.vtiger.elementrepository.HomePage;
import com.vtiger.elementrepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public int randomNumber;
	public long longTimeOut;
	public  WebDriver driver=null;
	public LoginPage loginpage;
	public  HomePage homepage;
	public JavaAccount javaaccount;
	public WebDriverCentre webDriverCentre;
	public static WebDriver staticDriver;
	/**
	 * This annotation is used to open the ExcelFile,get connection of Database,property file
	 */
	@BeforeSuite(groups="baseClass")
	public void beforeSuiteTest(){
	//open database if it is required
		try {
			FileProfit.openPropertyFile(IConstantPath.PROPERTYPATH);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 try {
			ExcelLibrary.openExcel(IConstantPath.EXCELFILEPATH);
		} catch (EncryptedDocumentException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}	 
	}
	/**
	 * This annotation is used to launch the browser
	 */
	//@Parameters("browser")
	@BeforeClass(groups="baseClass")
	public void beforeClassTest(/*String browser*/)
	{
		javaaccount = new JavaAccount();
		webDriverCentre=new WebDriverCentre();
		
		String url=System.getProperty("URL");
		System.out.println(url);
		
		String browser=System.getProperty("BROWSER");
		System.out.println(browser);
		
		String username=System.getProperty("USERNAME");
		System.out.println(username);
		
		String password=System.getProperty("PASSWORD");
		System.out.println(password);
		
		//String url = FileProfit.getDataFromPropertyFile("url");
		//String browser =FileProfit.getDataFromPropertyFile("browser");
		String timeouts =FileProfit.getDataFromPropertyFile("timeout");
		longTimeOut=javaaccount.StringToLong(timeouts);
		randomNumber=javaaccount.getRandomNumber(1000);
		switch(browser) {
			 case "chrome":
				 WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
				 break;
			 case "firefox":
				 WebDriverManager.firefoxdriver().setup();
				 driver = new FirefoxDriver();
				 break;}
		staticDriver=driver;
		WebDriverCentre.navigateApp(driver,url);
		WebDriverCentre.browserSetting(longTimeOut, driver);
		webDriverCentre.initializeActions(driver);
		
		WebDriverCentre.explicitlyWait(driver, longTimeOut);
		
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
	}
	/**
	 * This annotation is used to do login Action
	 */
	@BeforeMethod(groups="baseClass")
	public void beforeMethodTest()
	{
		loginpage.loginAction(FileProfit.getDataFromPropertyFile("userName"),FileProfit.getDataFromPropertyFile("password"));
	}
	/**
	 * This annotation is used to do signout Actions
	 */
	@AfterMethod(groups="baseClass")
	public void afterMethodTest()
	{
		
			homepage.signOutAction(webDriverCentre);
		
	}
	/**
	 * This annotation will close the browser instance
	 */
	@AfterClass(groups="baseClass")
	public void afterClassTest()
	{
		
		try {
			ExcelLibrary.writeDatatoExcel(IConstantPath.EXCELFILEPATH);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		WebDriverCentre.quitBrowser(driver);
	}
	/** 
	 * This annotation will close the database
	 * close the excelsheet
	 * @throws IOException
	 */
	@AfterSuite(groups="baseClass")
	public void afterSuiteTest() throws IOException
	{
		ExcelLibrary.closeExcel();
	}
}
	
	


