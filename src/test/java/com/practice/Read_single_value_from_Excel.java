package com.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_single_value_from_Excel {

	public static void main(String[] args) throws Throwable {

		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Test_Data.xlsx");

		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet1");

		int RowNum = sh.getLastRowNum();
		int cellNum = sh.getRow(0).getLastCellNum();
		
		System.err.println(RowNum);
		System.out.println(cellNum);
		
		System.out.println(sh.getRow(0).getCell(0).getStringCellValue());
		
	}
}
