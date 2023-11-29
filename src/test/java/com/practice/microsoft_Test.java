package com.practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class microsoft_Test{
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.microsoft.com/en-in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		
		
		
	}

}
