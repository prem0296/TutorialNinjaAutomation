package utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name = "myaccounttestdata")
	public Object[][] getData() throws IOException {
		
		String path = ".\\TestDataUtility\\TestData.xlsx";
		
		Excel excel = new Excel(path);
		
		
		int rowCount = excel.getRowCount("Sheet1");
		int cellCount = excel.getCellCount("Sheet1", 1);
		
		String logindata [][] = new String[rowCount][cellCount];
		
		for(int i = 1 ; i <=rowCount;i++ ) {
			
			for (int j = 0; j < cellCount; j++) {
				
				logindata [i-1][j] = excel.getCellData("Sheet1", i, j);
				
			}
			
		}		
		
	return 	logindata;

	}
	
	
	
	


	
	
}
