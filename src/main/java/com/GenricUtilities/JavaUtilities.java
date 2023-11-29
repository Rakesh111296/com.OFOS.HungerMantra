package com.GenricUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This Class contains All the Java Utility Files
 * @author Raki
 *
 */
public class JavaUtilities {

	/**
	 * This Method Will Generate A Random Num and Returns Integer Value 
	 * 	 */
	public int randomNum () {
		Random r = new Random();
		int ran = r.nextInt();
		return ran;
		
	}
	
	/**
	 * This Method will return system Date 
	 */
	public String systemDate () {
		
		Date date = new Date();
		String SystemDate = date.toString();
		return SystemDate;
	}
	
	/**
	 * This method will return System date in required Date Formt
	 * @return
	 */
	
	public String  systemDateFormt () {
		
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		Date date = new Date();
		String systemDateFormt = simple.format(date);
		return systemDateFormt;
	}
	
	
	
	
	
}
