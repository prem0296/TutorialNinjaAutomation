package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends RegisterAccount {

	public MyAccountPage(WebDriver driver){

		super(driver);

	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccount;

	@FindBy(xpath = "(//a[text()='Login'])[1]")
	WebElement accountloginButton;

	@FindBy(name = "email")
	WebElement emailTextBox;

	@FindBy(name = "password")
	WebElement passTextBox;


	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;


	@FindBy(xpath = "(//a[text()='Logout'])[2]")
	WebElement logoutButton;
	
	public void clickMyAccount() {
		myAccount.click();
	}
	
	public void clickMyaccountloginButton() {
		accountloginButton.click();
	}
	
	public void setEmail(String email) {
		emailTextBox.sendKeys(email);
	}
	
	public void setPassword(String pass) {
		passTextBox.sendKeys(pass);
	}
	
	public void clickloginButton() {
		loginButton.click();
	}
	
	public void clicklogoutButton() {
		logoutButton.click();
	}
	
	
	
	
}
