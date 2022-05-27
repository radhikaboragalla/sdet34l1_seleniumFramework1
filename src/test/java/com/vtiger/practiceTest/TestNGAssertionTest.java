package com.vtiger.practiceTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGAssertionTest extends TestNGBasicconfigAnnotatPractice1Test {
	@Test
	public void practice1Test()
	{
		Reporter.log("a.practice1",true);
		Reporter.log("b.practice1",true);
		Reporter.log("c.practice1",true);
		Assert.fail();
		Reporter.log("d.practice1",true);
		Reporter.log("e.practice1",true);
		Reporter.log("f.practice1",true);
	}
	@Test
	public void practice2Test()
	{
		Reporter.log("f.practice1",true);
		Reporter.log("e.practice1",true);
		Reporter.log("d.practice1",true);
		Assert.fail();
		Reporter.log("c.practice1",true);
		Reporter.log("b.practice1",true);
		Reporter.log("a.practice1",true);
	}
	@Test
	public void practice3Test()
	{
		Reporter.log("a.practice1",true);
		Reporter.log("b.practice1",true);
		Reporter.log("c.practice1",true);
		
		Reporter.log("d.practice1",true);
		Assert.fail();
		Reporter.log("e.practice1",true);
		Reporter.log("f.practice1",true);
	}
	@Test
	public void practice4Test()
	{
		Reporter.log("a.practice1",true);
		Reporter.log("b.practice1",true);
		Reporter.log("c.practice1",true);
		
		Reporter.log("d.practice1",true);
		Assert.fail();
		Reporter.log("e.practice1",true);
		Reporter.log("f.practice1",true);
	}
	
	
		
	
	

}
