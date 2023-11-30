package com.HangarMantra_TestScript_BASSCLASS;

import org.testng.annotations.Test;

import com.GenricUtilities.Admin_Bass_Class;
import com.GenricUtilities.IpathConstants;
import PageObjectRepo.Admin_Add_Restaurant_Page;
import PageObjectRepo.Admin_Dashboard_page;
import PageObjectRepo.Admin_Edit_Restaurant_Page;

public class Admin_EditDashboard_to_AllRestaurants_Intigration_Test extends Admin_Bass_Class{

	@Test
	public void admin_Add_Edit_Menu() throws Throwable {

		//click on to Restaurant link
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

		String Image_Path = IpathConstants.Image_Path;
		Thread.sleep(2000);

		aarp.Add_Restaurant(rest_Name, email, phone, url, wUtil, Hours, ClosingHours, OpenDays, Category, Image_Path,
				address);

		String NewResAdd = aarp.getConfermationMessge();

		System.out.println(NewResAdd);

		String ExpNewResAdd = "New Restaurant Added Successfully.";
		
		//aarp.checkConfirmMessage(ExpNewResAdd);

		aarp.clickOnCancelBtn();

		adp.getAllRestaurantLink().click();

		aarp.clickEditRestBtn(driver, rest_Name);

		String New_rest_Name = rest_Name + "Edit";

		Admin_Edit_Restaurant_Page aerp = new Admin_Edit_Restaurant_Page(driver);

		String OpenDaysEdt = "mon-fri";
		aerp.Edit_Restaurant(New_rest_Name, email, phone, url, wUtil, Hours, ClosingHours, OpenDaysEdt, Category,
				Image_Path, address);

		
	
		String ExpetEdt = "Record Updated";

		//aerp.updateConfirmAssert(ExpetEdt);
		
	}

}
