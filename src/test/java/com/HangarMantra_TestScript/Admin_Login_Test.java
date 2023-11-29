package com.HangarMantra_TestScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Admin_Login_Test {

	
	public static void main(String[] args) throws Throwable {
		
		String Title = "Admin Login";
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Login_common_Data.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String ADMINURL = pObj.getProperty("adminurl");
		String ADMINUSERNAME = pObj.getProperty("adminusername");
		String ADMINPASSWORD = pObj.getProperty("adminpassword");
		System.out.println(ADMINURL +"   " +ADMINUSERNAME + "  "+ADMINPASSWORD);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get(ADMINURL);
		
		driver.findElement(By.name("username")).sendKeys(ADMINUSERNAME);
		driver.findElement(By.name("password")).sendKeys(ADMINPASSWORD);
		driver.findElement(By.name("submit")).click();
		
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
