package testLayer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import BasePackage.BaseAmazonClass;
import pompackage.PomLogin;

public class SignInTest extends BaseAmazonClass{
	
	PomLogin loginHelper;
	public SignInTest() throws IOException {
		
		super();
	}
	
	@BeforeClass
	public void initsetup() throws IOException {
		initiate();
		
		//sign in before every test 
		 loginHelper=new PomLogin();
		
	}
	@Test
	public void verifySignInTitle() {
		loginHelper.login();
		Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
		//use wait condition instead of hard sleep
		String actual= driver.getTitle();
		System.out.println(actual);
		Assert.assertEquals(actual, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
	}
	
	@Test
	public void verifyInvalidEmail() {
		loginHelper.typeEmail("");
		loginHelper.clickContinueBtn();
		String actualErrorMsg = loginHelper.getEmailErrorMsg();
		Assert.assertEquals(actualErrorMsg, "Enter your e-mail address or mobile phone number");
	}
	
	@Test
	public void verifyInvalidPassword() {
		loginHelper.typeEmail(prop.getProperty("username"));
		loginHelper.clickContinueBtn();
		loginHelper.typePassword("");
		loginHelper.clickSignInBtn();
		String actualErrorMsg = loginHelper.getPasswordErrorMsg();
		Assert.assertEquals(actualErrorMsg, "Enter your password");
	}
	
	@AfterClass
	public void close() {
		driver.close();
	}
}