package com.practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlink_Test {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://careers.infosys.com/placementportal/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		System.out.println(alllinks.size());
		ArrayList<String> array = new ArrayList<String>();

		for(int i=0; i<alllinks.size();i++) {
			
			String eachlink = alllinks.get(i).getAttribute("href");
			URL url = null;
			int statuscode = 0;
			
			try {
				url = new URL(eachlink);
				HttpURLConnection http = (HttpURLConnection)url.openConnection();
				statuscode= http.getResponseCode();
				
				if (statuscode>=400) {
					array.add(eachlink);
					System.out.println(eachlink +"-------->"+statuscode);
					
				}
			} 
			catch (Exception e) {
				
			}
			
		}
		
		
	}
}
