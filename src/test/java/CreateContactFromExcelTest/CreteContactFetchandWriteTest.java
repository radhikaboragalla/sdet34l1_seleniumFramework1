package CreateContactFromExcelTest;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.sdet34l1.genericutility.FileProfit;
import com.sdet34l1.genericutility.IConstantPath;
import com.sdet34l1.genericutility.JavaAccount;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreteContactFetchandWriteTest {
	public static void main(String[] args) throws IOException, Throwable
	{
		JavaAccount ja=new JavaAccount();
		FileProfit.openPropertyFile(IConstantPath.PROPERTYPATH);
		Long longTimeOut=ja.StringToLong(FileProfit.getDataFromPropertyFile("timeout"));
		//fetch from common data 
FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		
	    Properties pobj= new Properties();
        pobj.load(fis);
        String url=pobj.getProperty("url");
        String uname=pobj.getProperty("userName");
        String pwd=pobj.getProperty("password");
        String timeout=pobj.getProperty("timeout");
        String browser=pobj.getProperty("browser");
        long longTimeout=Long.parseLong(timeout);
        
        //fetch from workbook
        FileInputStream fis1= new FileInputStream("./src/test/resources/ttt.xlsx");
        Workbook wb= WorkbookFactory.create(fis1);
        Sheet sh= wb.getSheet("contacts");
        Row row= sh.getRow(1);
        Cell cel= row.getCell(4);
        //Cell cel1=row.getCell(2);
       // String orgname= cel.getStringCellValue()+num;
        String lastName=cel.getStringCellValue();
        WebDriverManager.chromedriver().setup();
        
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
        Random r=new Random();
        int num=r.nextInt();
        driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB, "root", Keys.ENTER);
        if(driver.getTitle().contains("Home"))
        {
        	wb.getSheet("contacts").getRow(1).createCell(7).setCellValue("Homepage Displayed");
        	wb.getSheet("contacts").getRow(1).createCell(8).setCellValue("pass");
        }
        driver.findElement(By.xpath("//a[text()='Contacts']")).click();
        if(driver.getTitle().contains("Contacts"))
        {
        	wb.getSheet("contacts").getRow(3).createCell(7).setCellValue("contactpage Displayed");
        	wb.getSheet("contacts").getRow(3).createCell(8).setCellValue("pass");
        }
        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
        if(driver.getTitle().contains("contacts"))
        {
        	wb.getSheet("contacts").getRow(4).createCell(7).setCellValue("contactpage Displayed");
        	wb.getSheet("contacts").getRow(4).createCell(8).setCellValue("pass");
        }
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        wb.getSheet("contacts").getRow(5).createCell(7).setCellValue(lastName);
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        if(driver.getCurrentUrl().contains("DetailView"))
       	{
        	wb.getSheet("contacts").getRow(6).createCell(7).setCellValue("lastname page displayed");
        	wb.getSheet("contacts").getRow(6).createCell(8).setCellValue("lastname page pass");
       	}
        String expname=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
        if(lastName.equals(expname))
        
        	System.out.println("Contact created successfully");
        	else
        		System.out.println("Contact created failed");
        	Actions act=new Actions(driver);
        	WebElement img=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        	act.moveToElement(img).perform();
        	WebElement logout=driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']"));
        	act.moveToElement(logout).click().perform();
        	if(driver.getTitle().contains("vtiger CRM"))
        	{
        		wb.getSheet("contacts").getRow(7).createCell(7).setCellValue("Home page displayed");
        		wb.getSheet("contacts").getRow(7).createCell(8).setCellValue("pass");
        	}
        	Thread.sleep(2000);
        	FileOutputStream fos=new FileOutputStream("./src/test/resources/ttt.xlsx");
        	wb.write(fos);
        	wb.close();
        
        	
        
        	
        
     
        }
   
        
        
        
}


