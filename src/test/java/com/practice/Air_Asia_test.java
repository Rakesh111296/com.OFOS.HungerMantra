package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Air_Asia_test {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.airpaz.com/en/airlines/I5-AirAsia-India");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[.='Mumbai']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[.='Bangalore']")).click();
		
		driver.findElement(By.xpath("//div[@class='text-base font-bold']")).click();
		System.out.println("clicking departure");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[.='November 2023']/ancestor::div[@id='calendar_0']/descendant::div[contains(@aria-label,'26')]")).click();
		driver.findElement(By.xpath("//button[.='Done']")).click();
		//driver.findElement(By.xpath("//button[@data-testid='flightSearch-searchFlight-button']")).click();		
	
		System.out.println("Successfull");
		
		
	}

}
