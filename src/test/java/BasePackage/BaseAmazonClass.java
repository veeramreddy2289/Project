package BasePackage;

import java.io.FileInputStream
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class BaseAmazonClass {

	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	//Step1 create constructor of this class
	
	public BaseAmazonClass() throws IOException {
	
		try {
		
		FileInputStream file=new FileInputStream("C:\\Users\\veera\\eclipse-workspace\\AMAZONECOMMERCE\\src\\test\\resources\\Config.properties");
		prop.load(file);
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException a) {
			a.printStackTrace();
		}
		}
	
	//Step 2
		
		public static void initiate() {
		String browsername =prop.getProperty("Browser");
		
		if(browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			
			driver=new ChromeDriver();}
			else if(browsername.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				driver=new FirefoxDriver();

			}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	
		}	
		public String verify() {
			return driver.getTitle();
			
		}
		}
		
