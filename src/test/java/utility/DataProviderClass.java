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
		
		
		  if (cellCount > 3) {
		        cellCount = 3; // Limit to 3 columns
		    }
		  
		  
		String logindata [][] = new String[rowCount][cellCount];
		
		for(int i = 1 ; i <=rowCount;i++ ) {
			
			for (int j = 0; j < cellCount; j++) {
				
				logindata [i-1][j] = excel.getCellData("Sheet1", i, j);
				
			}
			
		}		
		
	return 	logindata;

	}
	
	public static int getCurrentTestRow(String email, String pwd) throws IOException {
		
	    int rowCount = Excel.getRowCount("Sheet1");

	    for (int i = 1; i <= rowCount; i++) {
	    	
	        String excelEmail = Excel.getCellData("Sheet1", i, 0);
	        String excelPwd = Excel.getCellData("Sheet1", i, 1);

	        if (excelEmail.equals(email) && excelPwd.equals(pwd)) {
	            return i; 
	        }
	    }

	    throw new RuntimeException("Test data not found in Excel file.");
	}
	
	
	


	
	
}
