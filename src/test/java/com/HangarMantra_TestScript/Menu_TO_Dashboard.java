package com.HangarMantra_TestScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Menu_TO_Dashboard {

	public static void main(String[] args) throws Throwable {
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
		
		String DishCountBeforeAdding = driver.findElement(By.xpath("//p[.='Dishes']/../child::h2")).getText();
		int DishCount = Integer.parseInt(DishCountBeforeAdding);
		System.out.println("Dish Count in Dashboard Before Adding Menu ------------>"+ DishCount);
		
		driver.findElement(By.xpath("//span[.='Menu']")).click();
		driver.findElement(By.xpath("//a[.='Add Menu']")).click();
		
		FileInputStream fexcel = new FileInputStream(".\\src\\test\\resources\\testdaata.xlsx");
		Workbook wb = WorkbookFactory.create(fexcel);
		Sheet sh = wb.getSheet("MenuInput");
		int RowCount = sh.getLastRowNum();
		
		String DishName = sh.getRow(0).getCell(1).getStringCellValue();
		 HashMap<String, String> map = new HashMap<String, String>();
		 
		for (int i = 0; i <=RowCount; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		
		for(Entry<String, String> entry :map.entrySet()) {
			
			driver.findElement(By.name(entry.getKey())).sendKeys(entry.getValue());
			
		}
		Sheet sh1 = wb.getSheet("DD1");
		String ResValue = sh1.getRow(0).getCell(0).getStringCellValue();
		WebElement Element = driver.findElement(By.name("res_name"));
		Select sl = new Select(Element);
		sl.selectByVisibleText(ResValue);
		
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("C:\\Users\\Raki\\eclipse-workspace\\com.ofos.HangerMantra\\src\\test\\resources\\2023-02-21.jpg");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		
		String ExpText = "New Dish Added Successfully.";
		String ConText = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		System.out.println(ConText);
		
		if (ConText.contains(ExpText)) {
			System.out.println("Menu Added");
		}
		else {
			System.out.println("Menu Not Added");
		}
		
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		driver.findElement(By.xpath("//span[.='Dashboard']")).click();
		
		String DishCountAfterAdding = driver.findElement(By.xpath("//p[.='Dishes']/../child::h2")).getText();
		int DishCountAfter = Integer.parseInt(DishCountAfterAdding);
		System.out.println("Dish Count After Adding menu------------>"+DishCountAfter);
		
		
	}
	
	
}
