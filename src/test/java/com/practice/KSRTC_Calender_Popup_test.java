package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KSRTC_Calender_Popup_test {

	public static void main(String[] args) {
		//launch the browser
		WebDriver driver = new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		//enter the url
		driver.get("https://www.ksrtc.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.findElement(By.name("fromPlaceName")).sendKeys("Bengaluru");
		//driver.findElement(By.name("toPlaceName")).sendKeys("Mysuru");
		
		driver.findElement(By.name("txtJourneyDate")).click();
		
		driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/ancestor::div[@id='ui-datepicker-div']/descendant::a[text()='7']")).click();
		
		driver.findElement(By.name("txtReturnJourneyDate")).click();
		driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/ancestor::div[@id='ui-datepicker-div']/descendant::a[text()='7']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Search for Bus')]")).click();
		
		System.out.println("Pass");
		

		
	}
}
