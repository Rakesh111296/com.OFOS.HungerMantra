package com.HangarMantra_TestScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order_Dishes_from_two_different_Resturants {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Login_common_Data.properties");
		Properties pObj = new Properties();
		pObj.load(fis);

		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");

		String RestName = "Eataly";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(URL);
		driver.findElement(By.linkText("Login")).click();

		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();

		System.out.println("Login Successfull");

		driver.findElement(By.xpath("//a[contains(text(),'Restaurants')] ")).click();

		driver.findElement(By.xpath("//a[.='" + RestName + "']")).click();

		driver.findElement(By.xpath(
				"(//a[.='Crispy Chicken Strips'])[1]/ancestor::div[@class='food-item']/descendant::input[@type='text']"))
				.clear();
		driver.findElement(By.xpath(
				"(//a[.='Crispy Chicken Strips'])[1]/ancestor::div[@class='food-item']/descendant::input[@type='text']"))
				.sendKeys("2");

		driver.findElement(By.xpath(
				"(//a[.='Crispy Chicken Strips'])[1]/ancestor::div[@class='food-item']/descendant::input[@type='submit']"))
				.click();

		driver.findElement(By.xpath("//a[.='Choose Restaurant']")).click();
		driver.findElement(By.xpath("(//a[.='Korean Reso'])[1]")).click();

		driver.findElement(
				By.xpath("(//a[.='Kimchi'])[1]/ancestor::div[@class='food-item']/descendant::input[@type='text']"))
				.clear();
		driver.findElement(
				By.xpath("(//a[.='Kimchi'])[1]/ancestor::div[@class='food-item']/descendant::input[@type='text']"))
				.sendKeys("1");
		driver.findElement(
				By.xpath("(//a[.='Kimchi'])[1]/ancestor::div[@class='food-item']/descendant::input[@type='submit']"))
				.click();

		driver.findElement(By.xpath("//a[.='Checkout']")).click();

		driver.findElement(By.name("submit")).click();

		String ExpConText = "Thank you";

		Alert al = driver.switchTo().alert();
		al.accept();
		String actConText = al.getText();
		al.accept();

		if (actConText.contains(ExpConText)) {
			System.out.println("Order has been Placed From Two Different Resto");
		} else {
			System.out.println("Order has been not placed");
		}

		String ExpTitle = "My Orders";
		String ActTitle = driver.getTitle();
		if (ExpTitle.contains(ActTitle)) {
			System.out.println("Navigated To Orders Page");
		} else {
			System.err.println("Not Navigated To orders Page");
		}

		driver.findElement(By.xpath("//a[.='Logout']")).click();
		String ExpPagetitle = "Login";
		String ActPageTitle = driver.getTitle();
		if (ExpPagetitle.contains(ActPageTitle)) {
			System.out.println("Successfully logged out");
		} else {
			System.err.println("Log out failed");
		}

	}
}
