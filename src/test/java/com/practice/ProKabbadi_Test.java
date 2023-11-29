package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabbadi_Test {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        // Navigate to the Flipkart homepage
        driver.get("https://www.prokabaddi.com/standings");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String teamName= "Bengaluru Bulls";
        List<WebElement> scores = driver.findElements(By.xpath("//div[@class='team-name']/p[.='"+teamName+"']/ancestor::div[@class='row-head']/descendant::p[@class='count']"));

	for(WebElement lv:scores) {
		
		System.out.println(lv.getText());
	}
	
	}
}
