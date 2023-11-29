package com.HangarMantra_TestScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.collections4.iterators.EntrySetMapIterator;
import org.apache.commons.math3.analysis.function.Exp;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Admin_EditMenu {

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
		
		String ExpText = "New Dish Added Successfully";
		String ConText = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		
		if (ExpText.contains(ConText)) {
			System.out.println("Menu Added");
		}
		else {
			System.out.println("Menu Not Added");
		}
		
		
		driver.findElement(By.xpath("//img[@alt='user']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		
		System.out.println("Logged out Succesfullty");
		
		//loggin again 
		
		driver.findElement(By.name("username")).sendKeys(ADMINUSERNAME);
		driver.findElement(By.name("password")).sendKeys(ADMINPASSWORD);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[.='Menu']")).click();
		driver.findElement(By.xpath("//a[.='All Menues']")).click();
		
		driver.findElement(By.xpath("//td[.='"+DishName+"']/../descendant::a[@class='btn btn-info btn-flat btn-addon btn-sm m-b-10 m-l-5']")).click();
		driver.findElement(By.name("d_name")).clear();
		driver.findElement(By.name("d_name")).sendKeys(DishName+123);
		
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("C:\\Users\\Raki\\eclipse-workspace\\com.ofos.HangerMantra\\src\\test\\resources\\2023-02-21.jpg");
		
		driver.findElement(By.name("submit")).click();
		String ExpetEdtConfMesg = "Record Updated";
		String UpdateConfMesg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		
		if (ExpetEdtConfMesg.contains(UpdateConfMesg)) {
			System.out.println("Record Updated successfully");
		}
		else {
			System.out.println("Record Not Updated");
		}
		
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		
		String EdtDishName = driver.findElement(By.xpath("//td[.='"+DishName+"']/../descendant::a[@class='btn btn-info btn-flat btn-addon btn-sm m-b-10 m-l-5']")).getText();
		
		if (DishName.contains("123")) {
			System.out.println("Record updated with 123 at last and Updated Dish Name------------->"+EdtDishName);
		}
		else 
		{
			System.out.println("Not Updated");
		}
		
		
		driver.findElement(By.xpath("//img[@alt='user']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		
		System.out.println("Logged out Succesfullty");
		
		driver.quit();
	}
}
