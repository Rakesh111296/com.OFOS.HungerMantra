package com.HangarMantra_TestScript_BASSCLASS;

import org.testng.annotations.Test;

import com.GenricUtilities.Admin_Bass_Class;
import com.GenricUtilities.IpathConstants;

import PageObjectRepo.Admin_Add_Menu_Page;
import PageObjectRepo.Admin_Dashboard_page;


public class Menu_To_Dashboard_Test extends Admin_Bass_Class{
	
	@Test
	public void menuToDashBoard () throws Throwable {
		
		Admin_Dashboard_page adp = new Admin_Dashboard_page(driver);
		String DishCountBeforeAdding = adp.getDishesCount().getText(); 
		int DishCount = Integer.parseInt(DishCountBeforeAdding);
		System.out.println("Dish Count in Dashboard Before Adding Menu ------------>"+ DishCount);
		Thread.sleep(3000);
		
		adp.getMenuLink().click();
		adp.getAddMenuLink().click();
		
		
		String DishName = eUtil.readFromExcel("MenuInput", 0, 1);
		String Discription = eUtil.readFromExcel("MenuInput", 1, 1);
		String Price = eUtil.readFromExcel("MenuInput", 2, 1);
		String ResValue = eUtil.readFromExcel("DD1", 0, 0);
		String Image = IpathConstants.Image_Path;
		
		
		Admin_Add_Menu_Page aamp = new Admin_Add_Menu_Page(driver);
		
		aamp.addMenu(DishName, Discription, Price, Image, wUtil, ResValue);
		
		
		String ExpText = "New Dish Added Successfully.";
		
		
		//aamp.checkConfirm(ExpText);
		
		aamp.clickOnCancelBtn();
		
		adp.getDashboardLink().click();
		
		String DishCountAfterAdding = adp.getDishesCount().getText();
		int DishCountAfter = Integer.parseInt(DishCountAfterAdding);
		System.out.println("Dish Count After Adding menu------------>"+DishCountAfter);
		
	}

}
