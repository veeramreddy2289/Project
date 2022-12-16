package pompackage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseAmazonClass;
public class PomHomepage extends BaseAmazonClass {
	
	
	
	@FindBy(css="#nav-link-accountList-nav-line-1") WebElement welcomeMsg;
	@FindBy(css="#a-page > div.a-container > div > div:nth-child(2) > div:nth-child(1) > a > div > div > div > div.a-column.a-span9.a-span-last > div > span") WebElement yourOrders;

	public PomHomepage() throws IOException {
		PageFactory.initElements(driver,this);

	}
  public String getWelcomeMsg() {
	  return welcomeMsg.getText();
}
  public void ClickyourOrdersBtn() {
  yourOrders.click();
  
  }
}