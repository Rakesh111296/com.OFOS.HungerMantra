package com.HangarMantra_TestScript.copy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenricUtilities.ExcelUtilities;
import com.GenricUtilities.FileUtilities;
import com.GenricUtilities.JavaUtilities;
import com.GenricUtilities.WebdriverUtilities;

import PageObjectRepo.Admin_Login_Page;

public class Admin_Login_Test {

	
	public static void main(String[] args) throws Throwable {
		
		String Title = "Admin Login";
		
		FileUtilities fUtil = new FileUtilities();
		ExcelUtilities eUtil = new ExcelUtilities();
		JavaUtilities jUtil = new JavaUtilities();
		WebdriverUtilities wUtil = new WebdriverUtilities();
		
		String ADMINURL = fUtil.readDataFromProperty("adminurl");
		String ADMINUSERNAME = fUtil.readDataFromProperty("adminusername");
		String ADMINPASSWORD = fUtil.readDataFromProperty("adminpassword");
		System.out.println(ADMINURL + "   " + ADMINUSERNAME + "  " + ADMINPASSWORD);

		WebDriver driver = new ChromeDriver();
		wUtil.maximizeWindow(driver);
		wUtil.implicitWait(driver, 30);
		
		driver.get(ADMINURL);
		Admin_Login_Page ap = new Admin_Login_Page(driver);
		ap.AdminLogin(ADMINUSERNAME, ADMINPASSWORD);
		
		String Actual = driver.getTitle();
		
		System.out.println(Actual);
		
		if (Title.equals(Actual)) {
			
			System.out.println("Admin Login Successfull");
		}
		
		else {
			System.err.println("Admin Login Failed");
		}
		
		
		
	}
}
