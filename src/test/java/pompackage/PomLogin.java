package pompackage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseAmazonClass;

public class PomLogin extends BaseAmazonClass{

	//object repository
	@FindBy(css="#ap_email") //replacement of friver.findElement(By.
	WebElement Email;
	@FindBy(id="ap_password")WebElement Password;
	@FindBy(id="signInSubmit") WebElement Signinbtn;
	@FindBy(css="#continue.a-button") WebElement continueBtn;
	@FindBy(css="#auth-email-missing-alert") WebElement emailPageErrorMsg;
	@FindBy(css="#auth-password-missing-alert") WebElement passwordPageErrorMsg;
	

	//initiate page elements
	public PomLogin() throws IOException{
		PageFactory.initElements(driver,this);
	}
	
	public void login() {
		 this.typeEmail(prop.getProperty("username"));
		 this.clickContinueBtn();
		 this.typePassword(prop.getProperty("password"));
		 this.clickSignInBtn();
	}
	
	//method overloading  (Polymorphism: one name different forms)
	public void login(String email, String password) {
		 this.typeEmail(email);
		 this.clickContinueBtn();
		 this.typePassword(password);
		 this.clickSignInBtn();
	}
	
	
	
	public void typeEmail(String email) {
		Email.sendKeys(email);
	}
	
	public void typePassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void clickContinueBtn() {
		
		continueBtn.click();
	}
	public void clickSignInBtn() {
		
		Signinbtn.click();
	}
	public String getEmailErrorMsg() {
			
	return emailPageErrorMsg.getText();
	}
	
	public String getPasswordErrorMsg() {
		
		return passwordPageErrorMsg.getText();
		}
}

