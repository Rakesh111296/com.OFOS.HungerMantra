package com.GenricUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import PageObjectRepo.Admin_Dashboard_page;
import PageObjectRepo.Admin_Login_Page;
import PageObjectRepo.Home_Page;
import PageObjectRepo.Login_Page;

public class Admin_Bass_Class {

	public DataBaseutilities dUtil = new DataBaseutilities();
	public ExcelUtilities eUtil = new ExcelUtilities();
	public FileUtilities fUtil = new FileUtilities();
	public JavaUtilities jUtil = new JavaUtilities();
	public WebdriverUtilities wUtil = new WebdriverUtilities();
	
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite
	public void confif_BS () throws Throwable {
		
		dUtil.createConnection();
		System.out.println("--Creating The Connection to DB--");
	}
	
	//@Parameters("BROWSER") 
	//public void config_BC (String BROWSER) throws Throwable
	@BeforeClass
	public void config_BC () throws Throwable {
		
		String BROWSER = fUtil.readDataFromProperty("browser");
		
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver= new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else {
			System.err.println("Invalide Browser Name");
		}
		sdriver = driver;
		wUtil.maximizeWindow(driver);
	
		System.out.println("--"+BROWSER+"---Browser Launched----");
	}
	
	
	@BeforeMethod
	public void config_BM () throws Throwable {
		String URL = fUtil.readDataFromProperty("adminurl");
		String USERNAME = fUtil.readDataFromProperty("adminusername");
		String PASSWORD = fUtil.readDataFromProperty("adminpassword");
		driver.get(URL);
		wUtil.implicitWait(driver, 30);
		
		Admin_Login_Page alp = new Admin_Login_Page(driver);
		alp.AdminLogin(USERNAME, PASSWORD);
		System.out.println("Logged in Successfully");
		
	}
	
	@AfterMethod
	public void config_AM () {
		Admin_Dashboard_page adp = new Admin_Dashboard_page(driver);
		adp.LogOut();
		
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
