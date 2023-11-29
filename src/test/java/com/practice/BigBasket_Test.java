package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket_Test {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//div[@class='Header___StyledCategoryMenu2-sc-19kl9m3-13 ibVaum']/descendant::span[.='Category']")).click();
		
		WebElement Element = driver.findElement(By.xpath("//ul/following::a[.='Fruits & Vegetables']"));
		WebElement Element1 = driver.findElement(By.xpath("//ul[@role='none']/following::a[.='Exotic Fruits & Veggies']"));
		Actions al = new Actions(driver);
		al.moveToElement(Element);
		al.moveToElement(Element1);
		al.perform();
		
		driver.findElement(By.xpath("//ul[@role='none']/following::a[.='Exotic Vegetables']")).click();
		
		
	}
}
