package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import pom.MyAccountPage;
import utility.DataProviderClass;
import utility.Excel;

public class MyAccountTest extends BaseClass {
	
	@Test(dataProvider = "myaccounttestdata" , dataProviderClass = DataProviderClass.class)
	private void validationOfMyAccount(String email, String pwd, String expected ) throws IOException {
		
		
		MyAccountPage myp = new MyAccountPage(driver);
		myp.clickMyAccount();
		myp.clickMyaccountloginButton();
		myp.setEmail(email);
		myp.setPassword(pwd);
		myp.clickloginButton();
		
		int currentRow = DataProviderClass.getCurrentTestRow(email, pwd);
		
		if (expected.equalsIgnoreCase("valid")) {
			
			myp.clicklogoutButton();
			Assert.assertTrue(true);
			Excel.setCellData("Sheet1", currentRow, 3, "Pass");
			Excel.setGreenColour("Sheet1", currentRow, 3); 
		}
		
		else {
			 Excel.setCellData("Sheet1", currentRow, 3, "Fail");
		     Excel.setRedColour("Sheet1", currentRow, 3);
			Assert.assertTrue(false);
			
		}
		
		
		
		

	}
	
	

}
