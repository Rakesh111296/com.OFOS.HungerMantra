package com.HangarMantra_TestScript_BASSCLASS;

import org.testng.annotations.Test;

import com.GenricUtilities.Admin_Bass_Class;
import com.GenricUtilities.IpathConstants;
import PageObjectRepo.Admin_Add_Menu_Page;
import PageObjectRepo.Admin_Dashboard_page;
import PageObjectRepo.Admin_Edit_Menu_Page;

public class Admin_EditMenuTest extends Admin_Bass_Class {

	@Test
	public void admin_EditMenu() throws Throwable {
		
		Admin_Dashboard_page adp = new Admin_Dashboard_page(driver);
		
		adp.getMenuLink().click();
		adp.getAddMenuLink().click();
		
		String DishName = eUtil.readFromExcel("MenuInput", 0, 1);
		String Discription = eUtil.readFromExcel("MenuInput", 1, 1);
		String Price = eUtil.readFromExcel("MenuInput", 2, 1);
		String ResValue = eUtil.readFromExcel("DD1", 0, 0);
		String Image = IpathConstants.Image_Path;
		Admin_Add_Menu_Page aamp = new Admin_Add_Menu_Page(driver);
		
		aamp.addMenu(DishName, Discription, Price, Image, wUtil, ResValue);
		
		String ExpText = "New Dish Added Successfully";
		//aamp.checkConfirm(ExpText);
		
		aamp.clickOnCancelBtn();
		
		
		adp.getAllMenuesLink().click();
		
		
		String DishName1 = eUtil.readFromExcel("MenuInput", 0, 2);
		
		
		Admin_Edit_Menu_Page aemp = new Admin_Edit_Menu_Page(driver);
		
		aemp.clickOnEditParticularDish(driver, DishName);
		
		aemp.EditMenu(DishName1, Discription, Price, Image, wUtil, ResValue);
		
		String ExpetEdtConfMesg = "Record Updated";
		//aemp.checkUpdateMessage(ExpetEdtConfMesg);
		
		aemp.clickOnCancelBtn();
		
		
		
	}
}
