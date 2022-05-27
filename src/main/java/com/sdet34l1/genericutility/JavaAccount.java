package com.sdet34l1.genericutility;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

/**
 * This class contains only java specific reusable methods
 * @author CSC
 *
 */
public class JavaAccount {
	/**
	 * This method is used to convert String value to long datatype
	 * @param value
	 * @return
	 */
public long StringToLong(String value) {
	return Long.parseLong(value);
}
/**
 * This method is used to get the random Number
 * @param limit
 * @return
 */
public int getRandomNumber(int limit) {
	Random r=new Random();
	return r.nextInt(limit);
	
}
/**
 * This method is used to print the statement
 */
public void printStatement(String message)
{
	System.out.println(message);
}
/**
 * This method is used to get the date
 */
public String getDataTimeInFormt()
{
	return new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new Date());
}

/**
 * This method is used to wait particular element with polling time
 * @throws InterruptedException 
 */
public void customWait(WebElement element,long pollingTime,int duration) throws InterruptedException
{
	int count=0;
	while(count<=duration) {
		try {
			element.click();
			break;
		}
		catch (Exception e) {
			
				Thread.sleep(pollingTime);
				count++;
			} 
			}
			
		}
	


/**
 * This method is used to compare with if else
 * 
*/
public void assertionThroughIfCondition(String actualResult, String expectedResult, String testCaseName)
{
if(actualResult.equalsIgnoreCase(expectedResult))
{
	System.out.println(testCaseName+" created successfully");
	System.out.println("TC Pass");
}
}
/** 
 * This method is used to compare using equals
 * 
 */
public void assertionThroughEquals(String actualresult, String expectedresult)
{
	if(actualresult.equals(expectedresult))
	{
		System.out.println("Successfully created");
	}
	else
	{
		System.out.println("failed");
	}
		
	}
}

