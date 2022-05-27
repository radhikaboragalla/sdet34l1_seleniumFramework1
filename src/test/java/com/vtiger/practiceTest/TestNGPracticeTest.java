package com.vtiger.practiceTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPracticeTest extends TestNGBasicconfigAnnotatPractice1Test {
	
   @Test(groups="sanity")
   public void practice1Test()
   {
	   System.out.println("method1 is running");
	   Assert.fail();
   }
   @Test(groups="regression")
   public void practice2Test()
   {
	   System.out.println("method2 is running");
	   Assert.assertEquals("54", "76");
   }
   @Test(groups={"sanity","regression"})
   public void practice3Test()
   {
	   System.out.println("method3 is running");
   }

}
