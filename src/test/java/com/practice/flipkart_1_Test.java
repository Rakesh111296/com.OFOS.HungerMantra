package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkart_1_Test {

	  public static void main(String[] args) {
	        
	        WebDriver driver = new ChromeDriver();
	        // Navigate to the Flipkart homepage
	        driver.get("https://www.flipkart.com/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.findElement(By.xpath("//span[@class='_30XB9F']")).click();
	        List<WebElement> productElements = driver.findElements(By.xpath("//div[@class='_2L0uxW']"));
	        
	        for (WebElement productElement :productElements)
	        {
	        	
	        	WebElement productNameElement = productElement.findElement(By.xpath("//div[@class='_58bkzq62 _3n8fnaug _3n8fnamv _3n8fnaf9 _3n8fna1 _3n8fna7n _58bkzq2 _1i2djtb9 _1i2djt0']"));
	        	WebElement productPriceElement = productElement.findElement(By.xpath("//div[@class='_58bkzq62 _3n8fnaug _3n8fnamv _3n8fnaf9 _3n8fna1 _3n8fna7n _58bkzqd _1i2djtb9 _1i2djt0 _1i2djt4i _1i2djt90 _1i2djt70']"));
	        	
	        	String productName = productNameElement.getText();
	            String productPrice = productPriceElement.getText();

	            System.out.println("Product: " + productName);
	            System.out.println("Price: " + productPrice);
	        }
	        
	  }
}
