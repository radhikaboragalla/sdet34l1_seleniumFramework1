package com.rmgyantra.projectTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;
import com.sdet34l1.genericutility.DatabaseService;
import com.sdet34l1.genericutility.ExcelLibrary;
import com.sdet34l1.genericutility.FileProfit;
import com.sdet34l1.genericutility.IConstantPath;
import com.sdet34l1.genericutility.JavaAccount;
import com.sdet34l1.genericutility.WebDriverCentre;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectTest {
	public static void main(String[] args) 
	{
		
		
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		//driver.get("http://localhost:8084");
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		JavaAccount ja=new JavaAccount();
		try {
			FileProfit.openPropertyFile(IConstantPath.RMGYANTRA_PROPERTYFILE_PATH);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
			ExcelLibrary.openExcel(IConstantPath.RMGYANTRA_EXCELFILE_PATH);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long longTimeOut=ja.StringToLong(FileProfit.getDataFromPropertyFile("timeout"));
		int num=ja.getRandomNumber(1000);
		//Random r=new Random();
		//int num=r.nextInt(100);
		//String projectname="Abc"+num;
		String projectname=ExcelLibrary.getDataFromExcel("rmgProject", 2, 1)+num;
		String createdBy=ExcelLibrary.getDataFromExcel("rmgProject", 2, 2)+num;
		try {
			ExcelLibrary.closeExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriver driver=null;
		switch(FileProfit.getDataFromPropertyFile("browser"))
		{
		 case "chrome" :
		        WebDriverManager.chromedriver().setup();
		        driver=new ChromeDriver();
		        break;
		        case "firefox" :
		        WebDriverManager.firefoxdriver().setup();
		        driver=new FirefoxDriver();
		        break;
		        default :
		        	System.out.println("please specify proper browser");
		        	WebDriverManager.chromedriver().setup();
		        	driver=new ChromeDriver();
		        	break; 
		}
		WebDriverCentre.navigateApp(driver, FileProfit.getDataFromPropertyFile("url"));
		WebDriverCentre.maximizeBrowser(driver);
		WebDriverCentre.browserSetting(longTimeOut, driver);
		//driver.findElement(By.id("usernmae")).sendKeys(FileProfit.getDataFromPropertyFile("UserName");
		//driver.findElement(By.id("usernmae")).sendKeys(FileProfit.getDataFromPropertyFile("UserName");
		//FileProfit.getDataFromPropertyFile("Password"));
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.className("material-icons")).click();
		driver.findElement(By.cssSelector("[name='projectName']")).sendKeys(projectname);
		driver.findElement(By.name("createdBy")).sendKeys("Radhika");
				
		WebElement projectstatus=driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select"));
		WebDriverCentre.initializeSelect(projectstatus);
		WebDriverCentre.dropdownByVisibleText("Created");
		
		//Select s=new Select(projectstatus);
		//s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		try {
			FileProfit.openPropertyFile(IConstantPath.RMGYANTRA_PROPERTYFILE_PATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DatabaseService.openDBConnection(IConstantPath.DATABASEURL+FileProfit.getDataFromPropertyFile("dbUserName"),FileProfit.getDataFromPropertyFile("dbPassword"), createdBy);
		DatabaseService.getDataFromDataBase("select * from project;", "projectname");
		boolean status=DatabaseService.validateDataInDatabase("select * from project;", "projectname",projectname);
		if(status==true)
		{
			System.out.println("TC Passed");
		}
		else
		{
			System.out.println("TC Failed");
		}
		
		/*Connection connection=null;
		//try
		//{
			Driver driver1 = null;
			try {
				driver1 = new Driver();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				DriverManager.registerDriver(driver1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement statement = null;
			try {
				statement = connection.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ResultSet result = null;
			try {
				result = statement.executeQuery("select * from project;");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while(result.next())
				{
					if(projectname.equals(result.getString(4)))
						System.out.println("project created successfully");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		finally
				
				{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//driver.close();*/
		DatabaseService.closeDBConnection();
		WebDriverCentre.quitBrowser(driver);
		}
	
				
				
			
		}


