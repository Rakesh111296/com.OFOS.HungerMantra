package com.GenricUtilities;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import PageObjectRepo.Home_Page;
import PageObjectRepo.Login_Page;

public class Bass_Class {
	
	public DataBaseutilities dUtil = new DataBaseutilities();
	public ExcelUtilities eUtil = new ExcelUtilities();
	public FileUtilities fUtil = new FileUtilities();
	public JavaUtilities jUtil = new JavaUtilities();
	public WebdriverUtilities wUtil = new WebdriverUtilities();
	public WebDriver driver;
	@BeforeSuite
	public void confif_BS () throws Throwable {
		
		dUtil.createConnection();
		System.out.println("--Creating The Connection to DB--");
	}
	
	@Parameters("BROWSER")
	@BeforeClass
	public void config_BC (String BROWSER) throws Throwable {
		
		//String BROWSER = fUtil.readDataFromProperty("browser");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.err.println("Invalide Browser Name");
		}
		wUtil.maximizeWindow(driver);
		
		System.out.println("--"+BROWSER+"---Browser Launched----");
	}
	
	
	@BeforeMethod
	public void config_BM () throws Throwable {
		String URL = fUtil.readDataFromProperty("url");
		String USERNAME = fUtil.readDataFromProperty("username");
		String PASSWORD = fUtil.readDataFromProperty("password");
		driver.get(URL);
		wUtil.implicitWait(driver, 30);
		
		Login_Page lp = new Login_Page(driver);
		lp.logintoapp(USERNAME, PASSWORD);
		System.out.println("Logged in Successfully");
		
	}
	
	@AfterMethod
	public void config_AM () {
		
		Home_Page hp = new Home_Page(driver);
		hp.LogOut();
		System.out.println("Logged Out Successfully");		
		
	}
	
	@AfterClass
	public void config_AC () {
		driver.quit();
		System.out.println("---Browser Closed----");
	
	}
	
	@AfterSuite
	public void config_AS () throws Throwable {
		
		dUtil.closeDB();
		System.out.println("---Closing The DataBase----");
		
	}

}
