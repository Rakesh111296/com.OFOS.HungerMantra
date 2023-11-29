package com.GenricUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This File contains the Methods for Reading the Data From Property Files
 * @author Raki
 *
 */
public class FileUtilities {

	public String readDataFromProperty (String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(IpathConstants.File_Path);
		Properties p =new Properties();
		p.load(fis);
		
		String Value = p.getProperty(key);
		return Value;
	}
	
}
