package com.HangarMantra_TestScript.copy;

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
import PageObjectRepo.Admin_Edit_Restaurant_Page;
import PageObjectRepo.Admin_Login_Page;

public class Admin_EditDashboard_to_AllRestaurants_Intigration_Test {

	public static void main(String[] args) throws Throwable {

		//Calling all the Utility Files
		FileUtilities fUtil = new FileUtilities();
		ExcelUtilities eUtil = new ExcelUtilities();
		JavaUtilities jUtil = new JavaUtilities();
		WebdriverUtilities wUtil = new WebdriverUtilities();

		String Title = "Admin Login";
		
		//Reading the data from property file
		String ADMINURL = fUtil.readDataFromProperty("adminurl");
		String ADMINUSERNAME = fUtil.readDataFromProperty("adminusername");
		String ADMINPASSWORD = fUtil.readDataFromProperty("adminpassword");
		//printing the Retrived Data
		System.out.println(ADMINURL + "   " + ADMINUSERNAME + "  " + ADMINPASSWORD);
		//launching the Chrome Browser
		WebDriver driver = new ChromeDriver();
		wUtil.maximizeWindow(driver);
		wUtil.implicitWait(driver, 30);
		driver.get(ADMINURL);
		//calling Login_page POM
		Admin_Login_Page ap = new Admin_Login_Page(driver);
		ap.AdminLogin(ADMINUSERNAME, ADMINPASSWORD);
		
		//click on to Res
		Admin_Dashboard_page adp = new Admin_Dashboard_page(driver);
		adp.getRestaurantLink().click();
		adp.getAddRestaurantLink().click();
		
		Admin_Add_Restaurant_Page aarp = new Admin_Add_Restaurant_Page(driver);

		// eUtil.readMultipleDataFromExcel("input", driver, 0, 1);

		String rest_Name = eUtil.readFromExcel("input", 0, 1);
		String email = eUtil.readFromExcel("input", 1, 1);
		String phone = eUtil.readFromExcel("input", 2, 1);
		String url = eUtil.readFromExcel("input", 3, 1);
		String address = eUtil.readFromExcel("input", 4, 1);

		String Hours = eUtil.readFromExcel("DD", 0, 0);
		String ClosingHours = eUtil.readFromExcel("DD", 4, 1);
		String OpenDays = eUtil.readFromExcel("DD", 3, 2);
		String Category = eUtil.readFromExcel("DD", 3, 3);
		System.out.println(Hours + ClosingHours + OpenDays + Category);

		String Image_Path = "C:\\Users\\Raki\\eclipse-workspace\\com.ofos.HangerMantra\\src\\test\\resources\\2023-02-21.jpg";

		Thread.sleep(2000);

		aarp.Add_Restaurant(rest_Name, email, phone, url, wUtil, Hours, ClosingHours, OpenDays, Category, Image_Path,
				address);

		String NewResAdd = aarp.getConfermationMessge();

		System.out.println(NewResAdd);

		String ExpNewResAdd = "New Restaurant Added Successfully";

		if (NewResAdd.contains(ExpNewResAdd)) {
			System.out.println("Restaurant Added Successfully");
		} else {
			System.err.println("Restaurant Not Added");
		}

		aarp.clickOnCancelBtn();

		adp.getAllRestaurantLink().click();

		aarp.clickEditRestBtn(driver, rest_Name);

		String New_rest_Name = rest_Name + "Edit";

		Admin_Edit_Restaurant_Page aerp = new Admin_Edit_Restaurant_Page(driver);

		String OpenDaysEdt = "mon-fri";
		aerp.Edit_Restaurant(New_rest_Name, email, phone, url, wUtil, Hours, ClosingHours, OpenDaysEdt, Category,
				Image_Path, address);

		String ActualEdt = aerp.getConfirmMessage().getText();
		System.out.println(ActualEdt);
		String ExpetEdt = "Record Updated";

		if (ActualEdt.contains(ExpetEdt)) {

			System.out.println("Record Updated");
		} else {
			System.err.println("Record not updtaed");
		}

		aarp.clickOnCancelBtn();

		adp.LogOut();
		System.out.println("Logged out Succesfullty");
	}

}
