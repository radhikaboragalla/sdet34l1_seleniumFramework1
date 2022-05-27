package com.sdet34l1.genericutility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

/**
 * This class contains only Property file Specific common methods
 * @author CSC
 *
 */

public class FileProfit {
	static Properties property;
	/**
	 * This method is used to open the property file
	 * @throws IOException 
	 * @throws  
	 * @throws IOException
	 */
	public static void openPropertyFile(String filepath) throws IOException  {
		FileInputStream fis=new FileInputStream(filepath);
		property=new Properties();
		property.load(fis);
	}
	/**
	 * This method is used to fetch the data from the Property File
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String getDataFromPropertyFile(String key) {
		String Value=property.getProperty(key);
		return Value;
	}
	
	
	
	
	
	

}
