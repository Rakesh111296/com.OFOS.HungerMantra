package TestNG_Practice;

import java.text.Normalizer.Form;

import org.testng.annotations.Test;

public class GetData_from_DataProvider {

	
	
	
	@Test(dataProviderClass = dataProvider.class, dataProvider = "GetDataFromExcel")
	public void GetDataFromExcel1 (String From_Location, String TO_Location) {
		
		//System.out.println(From_Location +"----------------"+TO_Location);
		System.out.println(From_Location);
		

		
	}
	
}
