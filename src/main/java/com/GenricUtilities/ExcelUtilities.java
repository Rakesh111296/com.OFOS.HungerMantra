package com.GenricUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.common.collect.Table.Cell;

public class ExcelUtilities {

	/**
	 * This Method will Read the data from excel and return values
	 * 
	 * @param SheetName
	 * @param Row
	 * @param Cell
	 * @return String CellValue
	 * @throws Throwable
	 */
	public String readFromExcel(String SheetName, int row, int cell) throws Throwable {

		FileInputStream fexcel = new FileInputStream(IpathConstants.Excel_Path);
		Workbook wb = WorkbookFactory.create(fexcel);
		Sheet Sh = wb.getSheet(SheetName);
		String CellValue = Sh.getRow(row).getCell(cell).getStringCellValue();
		return CellValue;
	}
	
	/**
	 * This Method is for writing the data to Excel file
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @param Value
	 * @return void
	 * @throws Throwable
	 */
	public void WriteDataToExcel(String SheetName, int row, int cell, String Value) throws Throwable {
		
		FileInputStream fexcel = new FileInputStream(IpathConstants.Excel_Path);
		Workbook wb = WorkbookFactory.create(fexcel);
		Sheet Sh = wb.getSheet(SheetName);
		Sh.createRow(row).createCell(cell).setCellValue(Value);	
		FileOutputStream fout = new FileOutputStream(IpathConstants.Excel_Path);
		wb.write(fout);
		wb.close();
	}
	
	/**
	 * This method Return Last Row Count 
	 * @param SheetName
	 * @return LastRow Num
	 * @throws Throwable
	 */
	public int lastRowNum (String SheetName ) throws Throwable {
		
		FileInputStream fexcel = new FileInputStream(IpathConstants.Excel_Path);
		Workbook wb = WorkbookFactory.create(fexcel);
		Sheet Sh = wb.getSheet(SheetName);
		int Count = Sh.getLastRowNum();
		return Count;
	}
	
	/**
	 * This Method will read multiple data and stores in Hashmap as Key-Value Pair
	 * Key-webelement Locator
	 * Value-sendkeyes Value
	 * @param SheetName
	 * @param driver
	 * @param Keycell
	 * @param Valuecell
	 * @throws Throwable
	 */
	public void readMultipleDataFromExcel (String SheetName, WebDriver driver, int Keycell, int Valuecell) throws Throwable {
		
		ExcelUtilities Ex = new ExcelUtilities();
		FileInputStream fexcel = new FileInputStream(IpathConstants.Excel_Path);
		Workbook wb = WorkbookFactory.create(fexcel);
		Sheet Sh = wb.getSheet(SheetName);
		int Count = Ex.lastRowNum(SheetName);
		
		HashMap<String, String> map =  new HashMap<String, String>();
		 
		for (int i = 0; i <= Count; i++) {
			String key = Sh.getRow(i).getCell(Keycell).getStringCellValue();
			String value = Sh.getRow(i).getCell(Valuecell).getStringCellValue();
			map.put(key, value);
			}
		for(Entry<String, String> entry :map.entrySet()) {
			
			driver.findElement(By.name(entry.getKey())).sendKeys(entry.getValue());
			
		}
	}
	
	//data provider
	public Object[][] getMultipleSetOfData (String SheetName) throws Throwable {
		
		FileInputStream fis = new FileInputStream(IpathConstants.Excel_Path);
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet Sh = wb.getSheet(SheetName);
		
		int RowCount = Sh.getPhysicalNumberOfRows();
		int CellCount = Sh.getRow(0).getLastCellNum();
		
		
		Object[][] obj = new Object [RowCount][CellCount];
		
		for (int i = 0; i < RowCount; i++) {
			for (int j = 0; j < CellCount; j++) {

				obj [i][j]= Sh.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		
		return obj;
	}
	
	
}
