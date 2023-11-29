package com.practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parctice {
	public static void main(String[] args) throws Throwable {
		String Title = "Admin Login";

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Login_common_Data.properties");
		Properties pObj = new Properties();
		pObj.load(fis);

		String ADMINURL = pObj.getProperty("adminurl");
		String ADMINUSERNAME = pObj.getProperty("adminusername");
		String ADMINPASSWORD = pObj.getProperty("adminpassword");
		System.out.println(ADMINURL + "   " + ADMINUSERNAME + "  " + ADMINPASSWORD);

		
		
		FileInputStream fexcel = new FileInputStream(".\\src\\test\\resources\\testdaata.xlsx");
		Workbook wb = WorkbookFactory.create(fexcel);
		Sheet sh = wb.getSheet("input");
		int Count = sh.getLastRowNum();
		System.out.println(Count);

		HashMap<String, String> map = new HashMap<String, String>();
		
		String key1 = sh.getRow(0).getCell(0).getStringCellValue();
		System.out.println(key1);

		for (int i = 0; i < Count; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}

		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			System.out.println(key + "   "+ val);
			
		
		}

}}
