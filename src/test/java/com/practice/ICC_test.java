package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICC_test {
	
	public static void main(String[] args) {
		//launch the browser
		WebDriver driver = new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		//enter the url
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String findingCountry = "South Africa";
		List<WebElement> countryName = driver.findElements(By.xpath("//tbody/tr/td[2]/span[2]"));
		
		for (WebElement lv:countryName) {
			
			String eachCountryName = lv.getText();
			System.out.println(eachCountryName);
			
			if(eachCountryName.equals(findingCountry)) 
			{
				System.out.println("South Africa is present");
				
				break;
			}
			
		}
		
		
	}
}
