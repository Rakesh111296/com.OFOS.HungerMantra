package com.HangarMantra_TestScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page_Test {
	
	public static void main(String[] args) throws Throwable {
		
		String Title = "Login";
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Login_common_Data.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get(URL);
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		
		//Validate Login
		WebElement element = driver.findElement(By.xpath("//a[@class='nav-link active']"));
		String ActualTitle = driver.getTitle();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		if (ActualTitle.contains(Title)) {
			System.out.println("Login Successfull");
		}
		
		else 
		{
			System.out.println("Login Failed");
		}
	}

}
