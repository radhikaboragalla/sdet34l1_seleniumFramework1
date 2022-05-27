package com.vtiger.practiceTest;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGBasicconfigAnnotatPractice1Test  {
	
	@BeforeSuite(groups="baseClass")
	public void beforeresult1Test()
	{
		Reporter.log("beforeresuite1"+Thread.currentThread().getId(),true);
	}
	@AfterSuite(groups="baseClass")
	public void afterresult1Test()
	{
        Reporter.log("aftersuite1"+Thread.currentThread().getId(), true);		
	}
	@Parameters("browser")
	@BeforeClass(groups="baseClass")
	public void beforeClass1Test()
	{
		Reporter.log("beforeClass1Test"+Thread.currentThread().getId(), true);
	}
	@AfterClass(groups="baseClass")
	public void afterClass1Test()
	{
		Reporter.log("afterClass1Test"+Thread.currentThread().getId(), true);
	}
	@BeforeTest(groups="baseClass")
	public void beforeTest1Test()
	{
		Reporter.log("beforeTest1Test"+Thread.currentThread().getId(), true);
	}
	@AfterTest(groups="baseClass")
	public void afterTest1Test()
	{
		Reporter.log("afterTest1Test"+Thread.currentThread().getId(), true);
	}
	@BeforeMethod(groups="baseClass")
	public void beforeMethod1Test()
	{
		Reporter.log("beforeMethod1Test"+Thread.currentThread().getId(), true);
	}
	@BeforeMethod(groups="baseClass")
	public void beforeMethod2Test()
	{
		Reporter.log("beforeMethod2Test"+Thread.currentThread().getId(), true);
	}
	@AfterMethod(groups="baseClass")
	public void afterMethod1Test()
	{
		Reporter.log("afterMethod1Test"+Thread.currentThread().getId(), true);
	}

}
