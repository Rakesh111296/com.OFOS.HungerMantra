package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICC_2_Test {

	
	public static void main(String[] args) {
		//launch the browser
		WebDriver driver = new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> countryName = driver.findElements(By.xpath("//tbody/tr/td[2]/span[2]"));
		List<WebElement> Matches = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		List<WebElement> points = driver.findElements(By.xpath("//tbody/tr/td[4]"));
		
		 // Check if the lists have the same number of elements
        int listSize = Math.min(countryName.size(), Math.min(Matches.size(), points.size()));
		
        for (int i = 0; i < listSize; i++) {
            String concatenated = countryName.get(i).getText() +"---"+ Matches.get(i).getText() +"---"+ points.get(i).getText();
            System.out.println(concatenated);
        }
        driver.quit();
	}
	
}
