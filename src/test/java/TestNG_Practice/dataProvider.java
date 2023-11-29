package TestNG_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenricUtilities.ExcelUtilities;

public class dataProvider {

	@Test(dataProvider = "data")
	public void DataProvider(String From, String To) {

		System.out.println(From + "----------->" + To);

	}

	@DataProvider
	public Object[][] data() {

		Object[][] obj = new Object[4][2];

		obj[0][0] = "Banglore";
		obj[0][1] = "Mysuru";

		obj[1][0] = "Chennai";
		obj[1][1] = "Bengaluru";

		obj[2][0] = "Hydrabad";
		obj[2][1] = "Bengaluru";

		obj[3][0] = "Chennai";
		obj[3][1] = "Mysuru";

		return obj;

	}

	@DataProvider
	public Object[][] DataFromExcel() throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdaata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");

		int RowCount = sh.getLastRowNum();
		int ColumnCount = sh.getRow(0).getLastCellNum();

		Object[][] obj = new Object[RowCount + 1][ColumnCount];

		for (int i = 1; i <= RowCount; i++) {

			for (int j = 0; j < ColumnCount; j++) {

				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
				}
			}
		
		return obj;

	}
	
	@DataProvider
	public Object[][] GetDataFromExcel () throws Throwable {
		ExcelUtilities eUtil = new ExcelUtilities ();
		Object[][] Value = eUtil.getMultipleSetOfData("Sheet1");
		return Value;
		
	}
}
