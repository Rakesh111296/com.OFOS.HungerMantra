package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteDataAndGetDatafromPropertyFile_test {
	/**
	 * This code is to write a data to property file and getiing the data from property file
	 */
	public static void main(String[] args) throws Throwable {
		
		
		//creating object for property file
		
		Properties pObj = new Properties();
		pObj.setProperty("browser", "Chrome");
		pObj.setProperty("url", "http://localhost:8888");
		pObj.setProperty("username", "admin");
		pObj.setProperty("password", "admin");
		
		//creating object for fileoutput stream
		
		FileOutputStream fOut = new FileOutputStream(".\\src\\test\\resources\\commonData.properties");
		pObj.store(fOut, "Write Data");
		
		//getting the data from property file
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		pObj.load(fi);
		
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		System.out.println(BROWSER + "   "+URL + "   "+ USERNAME+ "  "+PASSWORD );
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	
	
	}

}
