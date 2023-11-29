package com.HangarMantra_TestScript.copy;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenricUtilities.ExcelUtilities;
import com.GenricUtilities.FileUtilities;
import com.GenricUtilities.JavaUtilities;
import com.GenricUtilities.WebdriverUtilities;

import PageObjectRepo.Login_Page;

public class Login_Page_Test {
	
	public static void main(String[] args) throws Throwable {
		
		
		FileUtilities fUtil = new FileUtilities();
		ExcelUtilities eUtil = new ExcelUtilities();
		JavaUtilities jUtil = new JavaUtilities();
		WebdriverUtilities wUtil = new WebdriverUtilities();
		
		String Title = "Login";
		
		String URL = fUtil.readDataFromProperty("url");
		String USERNAME = fUtil.readDataFromProperty("username");
		String PASSWORD = fUtil.readDataFromProperty("password");
		
		WebDriver driver = new ChromeDriver();
		wUtil.maximizeWindow(driver);
		wUtil.implicitWait(driver, 30);

		driver.get(URL);
		
		Login_Page lp = new Login_Page(driver);
		
		lp.logintoapp(USERNAME, PASSWORD);
		
		String ActualTitle = lp.getTitleLnk().getText();
		//Validate Login
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(lp.getTitleLnk()));
		
		if (ActualTitle.contains(Title)) {
			System.out.println("Login Successfull");
		}
		
		else 
		{
			System.out.println("Login Failed");
		}
	}

}
