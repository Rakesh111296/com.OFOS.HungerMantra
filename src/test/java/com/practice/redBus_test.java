package com.practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class redBus_test {

	public static void main(String[] args) {
		//launch the browser
		
		WebDriver driver = new EdgeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		//enter the url
		driver.get("https://www.redbus.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		driver.findElement(By.className("sc-kAzzGY llxTcS")).click();
		
	
	
	
	
	
	}
}
