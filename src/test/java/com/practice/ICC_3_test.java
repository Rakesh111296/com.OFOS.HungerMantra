package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICC_3_test {

	
	public static void main(String[] args) {
		//launch the browser
		WebDriver driver = new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> Position = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<WebElement> countryName = driver.findElements(By.xpath("//tbody/tr/td[2]/span[2]"));
		List<WebElement> Matches = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		List<WebElement> points = driver.findElements(By.xpath("//tbody/tr/td[4]"));
		
		
		for(WebElement pv:Position) {
			System.out.println(pv.getText());
		}
		for(WebElement lv:countryName) {
			System.out.println(lv.getText());
		}
		
		for(WebElement lv1:Matches) {
			System.out.println(lv1.getText());
		}
		
		for(WebElement lv2:points) {
			System.out.println(lv2.getText());
		}
		
	
}
}
