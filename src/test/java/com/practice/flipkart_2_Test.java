package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkart_2_Test {

	public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        // Navigate to the Flipkart homepage
        driver.get("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        driver.findElement(By.xpath("//span[@class='_30XB9F']")).click();
        
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Apple iPhone");
        driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();
        
         List<WebElement> productElements = driver.findElements(By.xpath("//div[@class='_2kHMtA']"));
         
         System.out.println("All Apple iPhones:");
         
         
         for (WebElement productElement : productElements) {
             WebElement productNameElement = productElement.findElement(By.xpath("//div[@class='_4rR01T']"));
             WebElement productPriceElement = productElement.findElement(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));

             String productName = productNameElement.getText();
             String productPrice = productPriceElement.getText();

             System.out.println("Product: " + productName);
             System.out.println("Price: " + productPrice);
             System.out.println();
         }

         // Filter for iPhones with a price less than 80000
        
         for (WebElement productElement : productElements) {
             WebElement productPriceElement = productElement.findElement(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
             String productPrice = productPriceElement.getText();

             // Remove any commas and extract the price as an integer
             int price = Integer.parseInt(productPrice.replaceAll("[^0-9]", ""));

             if (price < 80000) {
                 WebElement productNameElement = productElement.findElement(By.xpath("//div[@class='_4rR01T']"));
                 String productName = productNameElement.getText();


                 System.out.println("Product: " + productName);
                 System.out.println("Price: " + productPrice);
                 System.out.println();
             }
         }
        
        
        
	}
	
}
