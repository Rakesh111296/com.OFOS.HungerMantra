package com.HangarMantra_TestScript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Enter;

public class Admin_EditDashboard_to_AllRestaurants_Intigration_Test {

	public static void main(String[] args) throws Throwable {
		String Title = "Admin Login";

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Login_common_Data.properties");
		Properties pObj = new Properties();
		pObj.load(fis);

		String ADMINURL = pObj.getProperty("adminurl");
		String ADMINUSERNAME = pObj.getProperty("adminusername");
		String ADMINPASSWORD = pObj.getProperty("adminpassword");
		System.out.println(ADMINURL + "   " + ADMINUSERNAME + "  " + ADMINPASSWORD);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(ADMINURL);

		driver.findElement(By.name("username")).sendKeys(ADMINUSERNAME);
		driver.findElement(By.name("password")).sendKeys(ADMINPASSWORD);
		driver.findElement(By.name("submit")).click();

		String Actual = driver.getTitle();
		// validating the Login
		System.out.println(Actual);

		if (Title.equals(Actual)) {

			System.out.println("Admin Login Successfull");
		}

		else {
			System.err.println("Admin Login Failed");
		}
		
		
		driver.findElement(By.xpath("//span[.='Restaurant']")).click();
		driver.findElement(By.xpath("//a[.='Add Restaurant']")).click();
		
		FileInputStream fexcel = new FileInputStream(".\\src\\test\\resources\\testdaata.xlsx");
		Workbook wb = WorkbookFactory.create(fexcel);
		Sheet sh = wb.getSheet("input");
		int Count = sh.getLastRowNum();
		System.out.println(Count);

		Sheet sh1 = wb.getSheet("DD");
		String HDD = sh1.getRow(0).getCell(0).getStringCellValue();
		String CHDD = sh1.getRow(4).getCell(1).getStringCellValue();
		String ODDD = sh1.getRow(3).getCell(2).getStringCellValue();
		String CDD = sh1.getRow(3).getCell(3).getStringCellValue();
		
		
		String key1 = sh.getRow(0).getCell(0).getStringCellValue();
		System.out.println(key1);
		System.out.println(HDD + CHDD + ODDD + CDD );

		

		HashedMap<String, String> map = new HashedMap<String, String>();
		
		
		for (int i = 0; i <=Count; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}

		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			System.out.println(key + "   "+ val);
			driver.findElement(By.name(entry.getKey())).sendKeys(entry.getValue());
			
		}
		
		
		WebElement HoursDD = driver.findElement(By.xpath("//select[@name='o_hr']"));
		Select hoursDD = new Select(HoursDD);
		hoursDD.selectByVisibleText(HDD);
		
		
		WebElement CloseHoursDD = driver.findElement(By.xpath("//select[@name='c_hr']"));
		Select closehoursDD = new Select(CloseHoursDD);
		 closehoursDD.selectByVisibleText(CHDD);
		
		
		
		WebElement OpenDaysDD = driver.findElement(By.xpath("//select[@name='o_days']"));
		Select opendaysDD = new Select(OpenDaysDD);
		opendaysDD.selectByVisibleText(ODDD);
		
		
		WebElement CategoryDD = driver.findElement(By.xpath("//select[@name='c_name']"));
		Select categoryDD = new Select(CategoryDD);
		categoryDD.selectByVisibleText(CDD);
		
		//driver.findElement(By.name("file")).sendKeys(".\\src\\test\\resources\\2023-02-21.jpg");
		
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("C:\\Users\\Raki\\eclipse-workspace\\com.ofos.HangerMantra\\src\\test\\resources\\2023-02-21.jpg");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		
		String NewResAdd = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		System.out.println(NewResAdd);
		
		String ExpNewResAdd = "New Restaurant Added Successfully";
		
		if (NewResAdd.contains(ExpNewResAdd)) {
			System.out.println("Restaurant Added Successfully");
		}
		else {
			System.err.println("Restaurant Not Added");
		}
		
		driver.findElement(By.xpath("//img[@alt='user']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		
		System.out.println("Logged out Succesfullty");
		
		//loggin again 
		
		driver.findElement(By.name("username")).sendKeys(ADMINUSERNAME);
		driver.findElement(By.name("password")).sendKeys(ADMINPASSWORD);
		driver.findElement(By.name("submit")).click();
		
		String Edtvalue = sh.getRow(0).getCell(1).getStringCellValue();
		
		driver.findElement(By.xpath("//span[.='Restaurant']")).click();
		driver.findElement(By.xpath("//a[.='All Restaurant']")).click();
		
		WebElement element = driver.findElement(By.xpath("(//a[@class='btn btn-info btn-flat btn-addon btn-sm m-b-10 m-l-5'])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		driver.findElement(By.xpath("//td[.='"+Edtvalue+"']/../child::td/child::a[@class='btn btn-info btn-flat btn-addon btn-sm m-b-10 m-l-5']")).click();
		
		
		driver.findElement(By.name("res_name")).sendKeys(Edtvalue + "Edit");
		
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("C:\\Users\\Raki\\eclipse-workspace\\com.ofos.HangerMantra\\src\\test\\resources\\2023-02-21.jpg");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		String ActualEdt = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		System.out.println(ActualEdt);
		String ExpetEdt = "Record Updated";
		
		if (ActualEdt.contains(ExpetEdt)){
			
			System.out.println("Record Updated");
		}
		else
		{
			System.err.println("Record not updtaed");
		}

	}

	
	
}
	

