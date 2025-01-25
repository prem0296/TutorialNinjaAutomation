package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class RegisterAccount {
	
	WebDriver driver;
	String username;
	String userlastname;
	String userEmail;
	String usercontact;
	String pass;
	String confirmpass;
	
	
	public RegisterAccount(WebDriver driver){
		  this.driver = driver;
			PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name = "firstname")
	WebElement firstName;
	
	@FindBy(name = "lastname")
	WebElement lastName;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "telephone")
	WebElement telephone;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "confirm")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement policyCheckBox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement accountCreateMessage;
	
	public void setFirstName(String username) {
		firstName.sendKeys(username);
	}
	
	public void setLastName(String userlastname) {
		lastName.sendKeys(userlastname);
	}
	
	public void setEmail(String userEmail) {
		email.sendKeys(userEmail);
	}
	
	public void setTelephone(String usercontact) {
		telephone.sendKeys(usercontact);
	}

	public void setPassword(String pass) {
		password.sendKeys(pass);
	}

	public void setConfirmPassword(String confirmpass) {
		confirmPassword.sendKeys(confirmpass);
	}
	
	public void clickPolicyCheckBox() {
		policyCheckBox.click();
	}
	
	public void clickContinueButton() {
		continueButton.click();
	}
	
	public String getMessage() {
		
		String text = accountCreateMessage.getText();
		
		return text;
	}
	
	
	
	

}
