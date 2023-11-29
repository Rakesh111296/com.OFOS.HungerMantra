package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjectRepo.Restaurants_Page;

public class p1 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		
		
		
		
		Restaurants_Page RP = new Restaurants_Page(driver);
		
		List<WebElement> list = driver.findElements((By) RP.getRestaurantText());
		
		for(WebElement lv:list) {
			
			System.out.println(lv.getText());
		}
	}

}
