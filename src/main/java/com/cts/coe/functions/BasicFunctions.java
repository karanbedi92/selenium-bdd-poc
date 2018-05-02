package com.cts.coe.functions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.host.Window;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BasicFunctions {
	public String baseUrl = "http://the-internet.herokuapp.com/login";

	static String driverPathForWindow = "D:\\cloud\\chromedriver_win32\\chromedriver.exe";
	static String driverPathForLinux = "/usr/local/share/chromedriver";

	/// usr/local/share/chromedriver
	// <- For Ubuntu
	// String driverPath = "C:\\BrowserDriver\\chromedriver.exe"; // <- For
	/// Windows
	public static WebDriver driver;

	public void launchApplication() {

		System.setProperty("webdriver.chrome.driver", driverPathForLinux);
		ChromeDriverManager.getInstance().setup();
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--headless", "--disable-gpu", "window-size=1920,1080", "--no-sandbox");
		driver = new ChromeDriver(options);

		/*
		 * DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		 * String[] options = new String[] { "--start-maximized", "--headless"
		 * }; capabilities.setCapability("chrome.switches", options); driver =
		 * new RemoteWebDriver(service.getUrl(), capabilities);
		 */

		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.get(baseUrl);
		// String expectedTitle = "The Internet";
		// String actualTitle = driver.getTitle();
		// Assert.assertEquals(actualTitle, expectedTitle);

	}

	public static WebDriver getWebDriverInstance(String baseUrl) {

		if (driver != null) {
			System.out.println("Driver instance is returned");
			return driver;
		}
		


		
		
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", driverPathForWindow);
			System.out.println("added for windows");
		} else {
			System.setProperty("webdriver.chrome.driver", driverPathForLinux);
			 ChromeDriverManager.getInstance().setup();
				System.out.println("added for ubuntu");			 
			 
		}

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--disable-gpu", "window-size=1920,1080", "--no-sandbox");
		
		
	
		driver = new ChromeDriver(options);
		/*
		 * DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		 * String[] options = new String[] { "--start-maximized", "--headless"
		 * }; capabilities.setCapability("chrome.switches", options); driver =
		 * new RemoteWebDriver(service.getUrl(), capabilities);
		 */

		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		System.out.println("driver is created");
		return driver;

	}

	public static void closeApplication() {
		driver.close();
		driver = null;
	}

	public static void main(String[] args) {
		BasicFunctions function = new BasicFunctions();
		function.launchApplication();
		function.closeApplication();
	}
	
	 public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File(fileWithPath);

	                //Copy file at destination

	                FileUtils.copyFile(SrcFile, DestFile);

	    }

}
