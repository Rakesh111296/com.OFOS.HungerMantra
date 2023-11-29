package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class goibibo_calander_Popup_test {
	
	

	public static void main(String[] args) {
		
		String MonthNYear = "January 2024";
		int date = 25;
		//launch the browser
		WebDriver driver = new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		//enter the url
		driver.get("https://www.goibibo.com/");
		//wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//close the login popup
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		//select the date from departure
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		
		for(;;) {
			try {
				
				driver.findElement(By.xpath("//div[text()='"+MonthNYear+"']/ancestor::div[@class='DayPicker-Month']//div[contains(@aria-label,'"+date+"')]")).click();
				break;
			} 
			catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		
		//click on done
		driver.findElement(By.xpath("//span[.='Done']")).click();
		

		
	}
}
