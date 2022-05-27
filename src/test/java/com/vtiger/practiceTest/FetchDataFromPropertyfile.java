package com.vtiger.practiceTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromPropertyfile {
	public static void main(String[] args) throws IOException, InterruptedException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties property=new Properties();
		property.load(fis);
		
		String url=property.getProperty("url");
		String timeout=property.getProperty("timeout");
		String userName=property.getProperty("userName");
		String password=property.getProperty("password");
		String browser=property.getProperty("browser");
		long longTimeOut = Long.parseLong(timeout); 
		WebDriver driver=null;
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
		default :
			System.out.println("please specify proper browser");
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
			}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		Random r=new Random();
		int num=r.nextInt(100);
		String orgname="DELL"+num;
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		WebElement wb= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act= new Actions(driver);
		act.moveToElement(wb).perform();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		driver.close();
	}
		

	}


