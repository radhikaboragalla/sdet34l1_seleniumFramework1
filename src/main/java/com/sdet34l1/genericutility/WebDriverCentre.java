package com.sdet34l1.genericutility;


import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * This class is used to maintain all web Driver common actions
 * @author CSC
 *
 */
public class WebDriverCentre {
	static WebDriverWait wait;
	 Actions act;
	static Select s;
	static JavascriptExecutor javascriptexecutor;
	static TakesScreenshot ts;
	static JavaAccount javaaccount=new JavaAccount();
	
	

/**
 * This method is used to navigate to the application
 */
	public static void navigateApp(WebDriver driver, String url)
	{
	 driver.get(url);
	 
	}
	/**
	 * This method is used to maximize the browser
	 * 
	 */
	public static void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to maximize the browser and implicit wait
	 */
	public static void browserSetting(long longTimeOut,WebDriver driver)
	{
		maximizeBrowser(driver);
		waitTillPageLoad(longTimeOut,driver);
	}
	/**
	 * This method is used to implicitly wait till page Load
	 * @param longTimeOut
	 */
	public static void waitTillPageLoad(long longTimeOut,WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
	}
	
	/**
	 *  This method is used to initialize Actions class method
	 */
	public   void initializeActions(WebDriver driver)
	{
		act=new Actions(driver);
	}
	/**
	 * This method is used to mouseHover on the element
	 * @param morelink
	 */
	public  void mouseHoverOntheElement(WebElement morelink)	{
		
	
		act.moveToElement(morelink).perform();
	}
	/**
	 * This method is used to quit the browser
	 */
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	/**
	 * This method is used to double click the webelement
	 */
	public  void doubleclickElement(WebElement morelink, WebDriver driver)
	{
		act.doubleClick(morelink).perform();
	}
	
	/**
	 * This method is used to double click the webpage
	 */
	public  void doubleClick(WebDriver driver)
	{
		act.doubleClick();
		
	}
	
	/**
	 * This method is used to wait the control till the particular element is clickable
	 * @param driver
	 * @param timeout
	 * @param element
	 */
	public static void waitUntilElementClickable(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	
	
/**
 * This method is used to wait the control till particular element is clickable
 * @param driver
 * @param timeout
 * @param element
 */
	public static void waitUntillElementVisible(WebElement element)
{
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * This method is used to initialize wait instance
 * @param driver
 * @param timeout
 */
public static void explicitlyWait(WebDriver driver, long timeout)
{
	wait=new WebDriverWait(driver, timeout);
}
/**
 * This method is used to initialize Select class method
 */
public static void initializeSelect(WebElement element)
{
	
	 s=new Select(element);
}
/**
 * This method is used to handle the dropdown by value
 */
public static void dropdownByValue( String value)
{
	s.selectByValue(value);
}
/**
 * This method is used to handle dropdown by index
 */
public static void dropdownByIndex(int index)
{
	s.selectByIndex(index);
}
/**
 * This method is used to handle dropdown by visibleText
 */
public static void dropdownByVisibleText(String visibleText)
{
	s.deselectByVisibleText(visibleText);
}
/**
 * This method is used to perform switch in frame using index
 */
public static void switchToFrameBynameorid(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}

/**
 * This method is used to perform switch in frame using name or id 
 */
public static void switchToFrameBynameorid(WebDriver driver,String nameorid)
{
	driver.switchTo().frame(nameorid);
}
/**
 *  This method is used to perform switch in frame using name webelement 
 */
public static void switchToFrameByElement(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
/**
 * This method is used to perform switch in frame using name defaultcontent
 */
public static void switchToFrameByDefaultContent(WebDriver driver) {
	driver.switchTo().defaultContent();
}
/**
 * This method is used to perform switch in frame using parent
 */
public static void switchToFrameByParent(WebDriver driver) {
	driver.switchTo().parentFrame();
}


/**This method is used to switch the window based on title
 * @param driver
 * @param partialText
 * */

public static void switchToWindowBasedOnTitle(WebDriver driver, String partialText)
{
	Set<String> sessionIDs = driver.getWindowHandles();
	for(String id:sessionIDs)
	{
		driver.switchTo().window(id);
		if(driver.getTitle().contains(partialText))
		{
			break;
		}
	}
}  
	/**
	 * This method is used to initialize the javascript
	 */
	public static void initializejs(WebDriver driver)
	{
		
		javascriptexecutor=(JavascriptExecutor)driver;
	}
	/**
	 * This method is used to enter data through javascript
	 */
	public static void enterDataThroughjs(WebElement element,String data)
	{
		javascriptexecutor.executeScript("arguments[0].value=arguments[1]", element,data);
	}
	/**
	 * This method is used to navigate application through javascript
	 */
	 public static String navigateAppThroughjs(String url)
	{
		 javascriptexecutor.executeScript("window.location=arguments[0]", url);
		return url;
	}
	/**
	 * This metod is used to perform click action through java script
	 */
	 public static void ClickThroughjs(WebElement elemnet)
	 {
		 Object element = null;
		 javascriptexecutor.executeScript("arguments[0].click()", element);
	 }
	 /** 
	  * This method is used to scroll specific height
	  */
	 public static void scrollToSpecificHeight(String Height)
	 {
		 javascriptexecutor.executeScript("window.scrollBy(0,"+Height+")");
	 }
	 /**
	  * This method is used to scroll bottom
	  */
	 public static void scrollToBottom(String Height)
	 {
		 javascriptexecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	 }
	 
	 /**
	  * This method is used to take screenshot
	 * @throws IOException 
	  */
	 public static String  takeScreenShot(String fileName, WebDriver driver) throws IOException
	 {
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File src=ts.getScreenshotAs(OutputType.FILE);
		 File dst=new File("./Screenshot/"+fileName+"_"+javaaccount.getDataTimeInFormt()+".png");
		 System.out.println(dst.getAbsolutePath());
		 FileUtils.copyFile(src, dst);
		 return dst.getAbsolutePath();
		 
	 }
}
	 
	
		

