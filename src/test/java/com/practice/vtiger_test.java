package com.practice;

import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class vtiger_test {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement> AllLinks = driver.findElements(By.xpath("//a[@href]"));
		
		ArrayList<String> ArrayLink = new ArrayList<String>();
		System.out.println(ArrayLink.size());
		
		for(WebElement lv:AllLinks) {
			String eachLink = lv.getText();
			URL url = null;
			int statuscode = 0;
			
			try {
				url = new URL(eachLink);
				HttpsURLConnection https = (HttpsURLConnection) url.openConnection();
				statuscode = https.getResponseCode();
				
				if (statuscode>=400) {
					ArrayLink.add(eachLink);
					System.out.println(eachLink +"-------->"+statuscode);
					
				}
			} 
			catch (Exception e) {
				
			}
		}
	}
}
