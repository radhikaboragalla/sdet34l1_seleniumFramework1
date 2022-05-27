package com.vtiger.practiceTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateVtigerOrganisationDBTest {
	public static void main(String[] args) throws Throwable
	{
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
	Statement statement= connection.createStatement();
	ResultSet result=statement.executeQuery("select * from organisation");
	while(result.next())
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver1=new ChromeDriver();
		driver1.get("http://localhost:8888");
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.findElement(By.name("user_name")).sendKeys(result.getString(1));
		driver1.findElement(By.name("user_password")).sendKeys(result.getString(2));
		driver1.findElement(By.id("submitButton")).click();
		driver1.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver1.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		
	}
	

	}
}
