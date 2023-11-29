package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Write_data_TO_Excel {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Test_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		
		//wb.getSheet("Sheet1").createRow(6).createCell(0).setCellValue("QSP");
		wb.getSheet("Sheet1").getRow(6).getCell(1).setCellValue("BNG");
		//wb.getSheet("Sheet1").createRow(7).createCell(0).setCellValue("QSP");
		//wb.getSheet("Sheet1").getRow(7).createCell(1).setCellValue("MYS");
	
		
		
		FileOutputStream fo = new FileOutputStream(".\\src\\test\\resources\\Test_Data.xlsx");
		wb.write(fo);
		wb.close();
		
		System.out.println("Data created");
		
		System.out.println(wb.getSheet("Sheet1").getRow(6).getCell(0).getStringCellValue());
		System.out.println(wb.getSheet("Sheet1").getRow(6).getCell(1).getStringCellValue());
		System.out.println(wb.getSheet("Sheet1").getRow(7).getCell(0).getStringCellValue());
		System.out.println(wb.getSheet("Sheet1").getRow(7).getCell(1).getStringCellValue());
		
	}
}
