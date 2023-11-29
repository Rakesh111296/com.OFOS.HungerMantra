package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTC_Popup_test {
	
	public static void main(String[] args) {
		//launch the browser
				WebDriver driver = new ChromeDriver();
				//maximize the browser
				driver.manage().window().maximize();
				//enter the url
				driver.get("https://www.irctc.co.in/");
				//wait for page to load
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				//close the login popup
				//driver.findElement(By.xpath
	}

}
