package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RMGYantra_Test {

	public static void main(String[] args) throws InterruptedException, Throwable {

		Connection con = null;
		String expected = "TYSS15";

		// launching the browser
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver:8084");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(10000);
		// signing into the application
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		// printing for successful login
		System.out.println("Sign in Successfull");
		// click on project module in home page
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		// click on create new project
		driver.findElement(By.xpath("//span[.='Create Project']")).click();

		// entering the details for creating project
		driver.findElement(By.name("projectName")).sendKeys(expected);
		driver.findElement(By.name("createdBy")).sendKeys("Rishav Singh");
		// handeling the Select drop down
		WebElement status = driver.findElement(By.name("status"));
		// creating a select class
		Select s = new Select(status);
		s.selectByValue("On Going");
		// click on Add project
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		System.out.println("Project created");
		// logging out
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		
		driver.quit();

		try {
			// register to DB

			Driver JDBCdriver = new Driver();
			DriverManager.registerDriver(JDBCdriver);
			// Get Connection
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			
			boolean flag = false;
			// Create a statement
			Statement state = con.createStatement();
			String querry = "select * from project where project_name='"+expected+"';";
			ResultSet result = state.executeQuery(querry);
			
			while (result.next()) 
			{
				String actual = result.getString(4);
				
				if (actual.equals(expected)) 
				{
					flag = true;
					break;
				}
			}
				if (flag) 
				{
					System.out.println("Project created in DB");
				} 
				
				else 
				{
					System.err.println("Project not created in DB");
				}
			
		} 
		catch (Exception e) {
			System.out.println("Hi ");
		} finally {
			// close the DB
			con.close();
		}

	}
}
