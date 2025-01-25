package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage  extends RegisterAccount{
	WebDriver driver;
	
	

	public RegistrationPage(WebDriver driver){
		
		super(driver);
		
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccount;
	
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement Register;
	
	
	@FindBy(xpath = "//h1[text()='Register Account']")
	WebElement RegisterAccount;
	
	public void clickMyAcccount() {
		myAccount.click();
	}
	
	public void register() {
		Register.click();
	}
	
	public boolean registerAccount() {
		boolean register = RegisterAccount.isDisplayed();
		
		return register;
	}
	
	
	
}
