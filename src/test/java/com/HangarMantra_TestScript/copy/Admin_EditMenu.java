package com.HangarMantra_TestScript.copy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.GenricUtilities.ExcelUtilities;
import com.GenricUtilities.FileUtilities;
import com.GenricUtilities.JavaUtilities;
import com.GenricUtilities.WebdriverUtilities;

import PageObjectRepo.Admin_Add_Menu_Page;
import PageObjectRepo.Admin_Dashboard_page;
import PageObjectRepo.Admin_Edit_Menu_Page;
import PageObjectRepo.Admin_Login_Page;

public class Admin_EditMenu {

	public static void main(String[] args) throws Throwable {
		
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
		
		Admin_Dashboard_page adp = new Admin_Dashboard_page(driver);
		
		adp.getMenuLink().click();
		adp.getAddMenuLink().click();
		
		String DishName = eUtil.readFromExcel("MenuInput", 0, 1);
		String Discription = eUtil.readFromExcel("MenuInput", 1, 1);
		String Price = eUtil.readFromExcel("MenuInput", 2, 1);
		String ResValue = eUtil.readFromExcel("DD1", 0, 0);
		String Image = "C:\\Users\\Raki\\eclipse-workspace\\com.ofos.HangerMantra\\src\\test\\resources\\2023-02-21.jpg";
		
		Admin_Add_Menu_Page aamp = new Admin_Add_Menu_Page(driver);
		
		aamp.addMenu(DishName, Discription, Price, Image, wUtil, ResValue);
		
		String ExpText = "New Dish Added Successfully";
		
		String ConText = aamp.getConfirmationMessageTxt().getText();
		
		if (ExpText.contains(ConText)) {
			System.out.println("Menu Added");
		}
		else {
			System.out.println("Menu Not Added");
		}
		
		adp.LogOut(); 
		
		
		System.out.println("Logged out Succesfullty");
		
		//loggin again 
		ap.AdminLogin(ADMINUSERNAME, ADMINPASSWORD);
		
		adp.getMenuLink().click();
		adp.getAllMenuesLink().click();
		
		
		String DishName1 = eUtil.readFromExcel("MenuInput", 0, 2);
		
		Admin_Edit_Menu_Page aemp = new Admin_Edit_Menu_Page(driver);
		
		aemp.EditMenu(DishName1, Discription, Price, Image, wUtil, ResValue);
		
		String ExpetEdtConfMesg = "Record Updated";
		
		String UpdateConfMesg = aemp.getUpdateMessageTxt().getText();
		
		if (UpdateConfMesg.contains(ExpetEdtConfMesg)) {
			System.out.println("Record Updated successfully");
		}
		else {
			System.out.println("Record Not Updated");
		}
		
		aemp.clickOnCancelBtn();
		
		String EdtDishName = aemp.getEditedDishName(driver, DishName);
		
		System.out.println(EdtDishName);
		
		if (EdtDishName.contains("123")) {
			System.out.println("Record updated with 123 at last and Updated Dish Name------------->"+EdtDishName);
		}
		else 
		{
			System.out.println("Not Updated");
		}
		
		
		
		adp.LogOut(); 
		System.out.println("Logged out Succesfullty");
		
		driver.quit();
	}
}
