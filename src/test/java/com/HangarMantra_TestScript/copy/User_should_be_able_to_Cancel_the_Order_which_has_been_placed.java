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

import PageObjectRepo.Checkout_Page;
import PageObjectRepo.Home_Page;
import PageObjectRepo.Login_Page;
import PageObjectRepo.Menu_Page;
import PageObjectRepo.My_Orders_page;
import PageObjectRepo.Restaurants_Page;

public class User_should_be_able_to_Cancel_the_Order_which_has_been_placed {

	public static void main(String[] args) throws Throwable {

		FileUtilities fUtil = new FileUtilities();
		ExcelUtilities eUtil = new ExcelUtilities();
		JavaUtilities jUtil = new JavaUtilities();
		WebdriverUtilities wUtil = new WebdriverUtilities();

		String RestName = eUtil.readFromExcel("input", 0, 2);
		String DishName = eUtil.readFromExcel("input", 0, 3);

		String URL = fUtil.readDataFromProperty("url");
		String USERNAME = fUtil.readDataFromProperty("username");
		String PASSWORD = fUtil.readDataFromProperty("password");

		WebDriver driver = new ChromeDriver();
		wUtil.maximizeWindow(driver);
		wUtil.implicitWait(driver, 30);

		driver.get(URL);

		Login_Page lp = new Login_Page(driver);
		lp.logintoapp(USERNAME, PASSWORD);

		System.out.println("Login Successfull");

		Home_Page hp = new Home_Page(driver);
		hp.getRestaurantsLink().click();

		Restaurants_Page rp = new Restaurants_Page(driver);
		rp.clickPaticularRestaurant(driver, RestName);

		Menu_Page mp = new Menu_Page(driver);
		mp.clear_Add_Qty_And_Add_Cart(driver, DishName);

		mp.clickCheckOut();

		Checkout_Page cp = new Checkout_Page(driver);
		cp.clickOrderNow();

		String ExpConText = "Thank you";

		wUtil.acceptAlertPop(driver);
		String actConText = wUtil.getTextFromAlertPop(driver);
		wUtil.acceptAlertPop(driver);

		if (actConText.contains(ExpConText)) {
			System.out.println("Order has been Placed From Two Different Resto");
		} else {
			System.out.println("Order has been not placed");
		}

		String ExpTitle = "My Orders";

		String ActTitle = lp.getTitleLnk().getText();
		if (ActTitle.contains(ExpTitle)) {
			System.out.println("Navigated To Orders Page");
		} else {
			System.err.println("Not Navigated To orders Page");
		}

		My_Orders_page mop = new My_Orders_page();
		int BeforeDeletOrderCount = mop.getCountOfOrders(driver);

		mop.cancleParticularDish(driver, DishName);

		wUtil.acceptAlertPop(driver);

		int AfterDeletingCount = mop.getCountOfOrders(driver);

		if (BeforeDeletOrderCount > AfterDeletingCount) {

			System.out.println("Order Has Been Cancelled");
		}

		else {
			System.err.println("Order Has not been Cancelled");
		}

		hp.LogOut();

		String ExpPagetitle = "Login";
		String ActPageTitle = lp.getTitleLnk().getText();

		if (ExpPagetitle.contains(ActPageTitle)) {
			System.out.println("Successfully logged out");
		} else {
			System.err.println("Log out failed");
		}

	}

}
