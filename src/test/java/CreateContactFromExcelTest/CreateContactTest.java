package CreateContactFromExcelTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sdet34l1.genericutility.FileProfit;
import com.sdet34l1.genericutility.IConstantPath;
import com.sdet34l1.genericutility.JavaAccount;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest {
	public static void main(String[] args) throws IOException, InterruptedException
	{
		JavaAccount ja=new JavaAccount();
		FileProfit.openPropertyFile(IConstantPath.PROPERTYPATH);
		Long longTimeOut=ja.StringToLong(FileProfit.getDataFromPropertyFile("timeout"));
		//FileInputStream fis=new FileInputStream("./src/test/resources/ttt.xlsx");
		//Workbook wb=WorkbookFactory.create(fis);
		//Sheet sh=wb.getSheet("contacts");
		//Row row=sh.getRow(2);
		//Cell cel=row.getCell(1);
		//String campaignname=cel.getStringCellValue();
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
        driver.get(FileProfit.getDataFromPropertyFile("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
        Random r=new Random();
        int num=r.nextInt(1000);
        driver.findElement(By.name("user_name")).sendKeys(FileProfit.getDataFromPropertyFile("userName"));
        driver.findElement(By.name("user_password")).sendKeys(FileProfit.getDataFromPropertyFile("password"));
        driver.findElement(By.id("submitButton")).click();
        FileInputStream fis1= new FileInputStream("./src/test/resources/ttt.xlsx");
       Workbook wb1= WorkbookFactory.create(fis1);
       Sheet sh= wb1.getSheet("contacts");
       Row row= sh.getRow(4);
       Cell cel= row.getCell(1);
       Cell cel1=row.getCell(2);
        String orgname= cel.getStringCellValue()+num;
        String lastname=cel1.getStringCellValue()+num;
        //create organization name
        driver.findElement(By.xpath("//a[text()='Organizations']")).click();
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
        //create contact
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
        String currentid=driver.getWindowHandle();
        System.out.println(currentid);
        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
        driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
        Set<String>allid=driver.getWindowHandles();
        for(String id:allid)
        {
        	if(!(id.equals(currentid)))
        	{
        		driver.switchTo().window(id);
        		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(orgname);
        		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
        		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
        		break;
        		        		
        	}
        }
        driver.switchTo().window(currentid);
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        String exporgname=driver.findElement(By.id("mouseArea_Organization Name")).getText();
        if(exporgname.equalsIgnoreCase(orgname))
        {
        	System.out.println("organization name is equal");
        }
        driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
        driver.quit();
	}
        }
        
        
        	
        
        




