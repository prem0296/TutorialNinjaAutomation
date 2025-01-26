package Test;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import pom.RegisterAccount;
import pom.RegistrationPage;

public class RegistrationAccount extends BaseClass {
	
	RegistrationPageTest rpt = new RegistrationPageTest();
	
	@Test
	public void registrationPageValidation() {
		
		rpt.registrationValidation();
		RegisterAccount ra = new RegisterAccount(driver);
		ra.setFirstName(randomString().toLowerCase());
		ra.setLastName("language");;
		ra.setEmail(randomAlphaNumerics().toLowerCase());
		ra.setTelephone(randomNumbers());
		ra.setPassword("java@123456");
		ra.setConfirmPassword("java@123456");
		ra.clickPolicyCheckBox();
		ra.clickContinueButton();

		//Assert.assertEquals(ra.getMessage(), "Your Account Has Been Created!");
		Assert.assertEquals(ra.getMessage(), "Your Account Has Been Created");

	}

	public String  randomString() {

		String randomAlphabetic = RandomStringUtils.randomAlphabetic(6);
		
		return randomAlphabetic;
	}

	
	public String randomNumbers() {

		String randomNumber = RandomStringUtils.randomNumeric(10);
		
		return randomNumber;
	}
	
	
	public String randomAlphaNumerics() {
		String randomAlphabetic = RandomStringUtils.randomAlphabetic(6);
		String randomnumber = RandomStringUtils.randomNumeric(6);
		return (randomAlphabetic + randomnumber + "@gmail.com");
   
	}


}
