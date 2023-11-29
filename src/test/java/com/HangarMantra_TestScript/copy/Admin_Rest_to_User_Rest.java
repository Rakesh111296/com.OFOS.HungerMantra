package com.HangarMantra_TestScript.copy;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.GenricUtilities.ExcelUtilities;
import com.GenricUtilities.FileUtilities;
import com.GenricUtilities.JavaUtilities;
import com.GenricUtilities.WebdriverUtilities;

import PageObjectRepo.Admin_Add_Restaurant_Page;
import PageObjectRepo.Admin_Dashboard_page;
import PageObjectRepo.Admin_Login_Page;
import PageObjectRepo.Home_Page;
import PageObjectRepo.Login_Page;

public class Admin_Rest_to_User_Rest {

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

		// Getting the Home Page Title
		String Actual = driver.getTitle();
		// validating the Login
		System.out.println(Actual);
		// Validating the Home Page
		if (Title.equals(Actual)) {

			System.out.println("Admin Login Successfull");
		}

		else {
			System.err.println("Admin Login Failed");
		}

		
		// Click on Restaurant OPtions
		Admin_Dashboard_page adp = new Admin_Dashboard_page(driver);
		adp.getRestaurantLink().click();
		adp.getAddRestaurantLink().click();
		

		// Reading The Values from Excel File
		eUtil.readMultipleDataFromExcel("input", driver, 0, 1);

		String Hours = eUtil.readFromExcel("DD", 0, 0);
		String ClosingHours = eUtil.readFromExcel("DD", 4, 1);
		String OpeningDays = eUtil.readFromExcel("DD", 3, 2);
		String Category = eUtil.readFromExcel("DD", 3, 3);
		String ImgPath = "C:\\Users\\Raki\\eclipse-workspace\\com.ofos.HangerMantra\\src\\test\\resources\\2023-02-21.jpg";

		String restName = eUtil.readFromExcel("input", 0, 1);
		String email = eUtil.readFromExcel("input", 1, 1);
		String phone = eUtil.readFromExcel("input", 2, 1);
		String Website = eUtil.readFromExcel("input", 3, 1);
		String Address = eUtil.readFromExcel("input", 4, 1);
		
		Admin_Add_Restaurant_Page aarp = new Admin_Add_Restaurant_Page(driver);
		aarp.Add_Restaurant(restName, email, phone, Website, wUtil, Hours, ClosingHours, OpeningDays, Category, ImgPath, restName);


		String NewResAdd = aarp.getConfermationMessge();
		
		System.out.println(NewResAdd);

		String ExpNewResAdd = "New Restaurant Added Successfully";

		if (NewResAdd.contains(ExpNewResAdd)) {
			System.out.println("Restaurant Added Successfully");
		} else {
			System.err.println("Restaurant Not Added");
		}

		adp.LogOut();
		
		System.out.println("Admin Logged out Succesfullty");

		// Logging in User
		
		String URL = fUtil.readDataFromProperty("url");
		String USERNAME = fUtil.readDataFromProperty("username");
		String PASSWORD = fUtil.readDataFromProperty("password");
		
		driver.get(URL);
		
		Login_Page lp = new Login_Page(driver);
		lp.logintoapp(USERNAME, PASSWORD);

		System.out.println("User Login Successfull");

		Thread.sleep(3000);
		
		Home_Page hp = new Home_Page(driver);
		hp.getRestaurantsLink().click();

		List<WebElement> ListofRest = driver.findElements(By.xpath("//h5"));

		for (WebElement lv : ListofRest) {

			String ActulRest = lv.getText();
			if (restName.contains(ActulRest)) {
				System.out.println("Restaurant is Being Displayed In User Restauratnt List");
				break;
			}
		}

	}
}
