package com.Cognizant.Bases;
//******************* To import all the required files *******************************//
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.UserDataHandler;

//*************************** Creating class ******************************//
public class TestBase {
	
	 /* To initialize the locater variable with the type */
	public static WebDriver driver;
	public Properties prop;
	File file;
	FileInputStream fis;

	// ************************ To create method for driver set up ***********************//
	public void setupDriver() {
		prop = new Properties();
		
		try {
			fis = new FileInputStream("./src/main/resources/com/Cognizant/config/configure.properties");
			prop.load(fis);
		} catch (FileNotFoundException fnf) {
			System.out.println("File name or path name is not correct");
		} catch (IOException ioe) {
			System.out.println("Input output error");
		}

		 /* To launch chrome browser */
		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+".\\src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		 /* To launch firefox browser */
		else if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\Drivers\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		 /* To launch edge browser */
		else if (prop.getProperty("Browser").equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.edge.driver", ".\\src\\test\\resources\\Drivers\\msedgedriver1.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	//****************************** To create method for navigation of url ***********************************//
	public void navigateToURL() {

		/* To open the site */
		driver.get(prop.getProperty("URL"));
		
	}
	
	//*********************************** To create method for closing the browser *******************************//
	public void closeDriver() {
		
		/* To close the driver */
		driver.quit();
	}
	
}
