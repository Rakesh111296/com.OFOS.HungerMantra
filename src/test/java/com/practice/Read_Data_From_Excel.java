package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_Data_From_Excel {

	public static void main(String[] args) throws Throwable {

		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Test_Data.xlsx");

		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet1");

		int RowNum = sh.getLastRowNum();
		int cellNum = sh.getRow(0).getLastCellNum();

		for (int i = 0; i <=RowNum; i++) 
		{

			for (int j = 0; j <cellNum; j++) 
			{
				String Value = sh.getRow(i).getCell(j).getStringCellValue();

				System.out.print(Value);
				System.out.print("            ");

			}

			System.out.println();
		}
	}

}
