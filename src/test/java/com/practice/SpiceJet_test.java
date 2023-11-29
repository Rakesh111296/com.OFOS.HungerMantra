package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpiceJet_test {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-geolocation");
        options.addArguments("disable-notifications");
		// Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the Cricbuzz homepage
        driver.get("https://www.spicejet.com/");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        String From = "Agartala";
        String TO = "Chennai";
        
        String fromMonth = "November";
        String fromYear= "2023";
        int fromDate = 25;
        
        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-zso239'])[2]")).click();
        driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).click();
        driver.findElement(By.xpath("//div[.='"+From+"']")).click();
        
        
        driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).click();
        driver.findElement(By.xpath("//div[.='"+TO+"']")).click();
        
        driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']")).click();
        Thread.sleep(3000);
        
        //driver.findElement(By.xpath("//div[@data-testid='undefined-month-November-2023']/descendant::div[.='17']")).click();
        
        
 }
}
