package testLayer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import BasePackage.BaseAmazonClass;
import pompackage.PomHomepage;
import pompackage.PomLogin;

public class HomePageTest extends BaseAmazonClass{
	
	PomLogin loginHelper;
	PomHomepage homeHelper;
	public HomePageTest() throws IOException {
		
		super();
	}
	
	@BeforeClass
	public void initsetup() throws IOException {
		initiate();
		
		//sign in before every test 
		 loginHelper=new PomLogin();
		 homeHelper=new PomHomepage();
		
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
	@Test
	public void verifyuserName() {
		loginHelper.login();
		Uninterruptibles.sleepUninterruptibly( 10,TimeUnit.SECONDS);
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"))).build().perform();//to implement action required
	    driver.findElement(By.partialLinkText("Veera")).click();
		action.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"))).build().perform();
	    homeHelper.ClickyourOrdersBtn();
		Uninterruptibles.sleepUninterruptibly( 20,TimeUnit.SECONDS);

	    
	    
	}
	
	
	@AfterClass
	public void close() {
		driver.close();
	}
}