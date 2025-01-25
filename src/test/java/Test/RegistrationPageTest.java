package Test;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseClass;
import pom.RegisterAccount;
import pom.RegistrationPage;

public class RegistrationPageTest extends BaseClass{


	
	@Test
	public void registrationValidation() {

		RegistrationPage rp = new RegistrationPage(driver);
		rp.clickMyAcccount();
		rp.register();
		
		Assert.assertTrue(rp.registerAccount());
		
		
		
		
	}




}
 