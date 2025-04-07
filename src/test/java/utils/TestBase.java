package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fs);
		String url =prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven= prop.getProperty("broswer");	
		
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		
		if(driver == null ) {
			if(prop.getProperty("browser").equalsIgnoreCase("chrome"));
		System.setProperty("webdriver.chrome.driver",
				 System.setProperty("user.dir", browser)+"//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		if(browser.equalsIgnoreCase("firefox"))
			System.setProperty("webdriver.chrome.driver",
		    System.setProperty("user.dir", browser)+"//src//test//resources//chromedriver.exe");	
		}
		if(prop.getProperty("browser") == "firefox") {
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		
		return driver;
}

}
