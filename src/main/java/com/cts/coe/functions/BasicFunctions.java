package com.cts.coe.functions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BasicFunctions {
	public String baseUrl = "http://the-internet.herokuapp.com/login";

	static String driverPathForWindow = "D:\\cloud\\chromedriver_win32\\chromedriver.exe";
	static String driverPathForLinux = "/usr/local/share/chromedriver";

	/// usr/local/share/chromedriver
	// <- For Ubuntu
	// String driverPath = "C:\\BrowserDriver\\chromedriver.exe"; // <- For
	/// Windows
	public  RemoteWebDriver driver;
	WebDriver dfc;

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

	public  RemoteWebDriver getWebDriverInstance(String baseUrl) throws MalformedURLException {

		if (driver != null) {
			System.out.println("Driver instance is returned");
			return driver;
		}

//		 if (System.getProperty("os.name").contains("Windows")) {
//		 System.setProperty("webdriver.chrome.driver", driverPathForWindow);
//		 System.out.println("added for windows");
//		 driver = new ChromeDriver();
//		 } else {
//		 System.setProperty("webdriver.chrome.driver", driverPathForLinux);
//		 ChromeDriverManager.getInstance().setup();
//		 System.out.println("added for ubuntu");
//		 ChromeOptions options = new ChromeOptions();
//		 options.addArguments("--headless", "--disable-gpu",
//		 "window-size=1920,1080", "--no-sandbox");
//		 driver = new ChromeDriver(options);
//		 }
		String url = "http://192.168.40.192:4444/wd/hub";

		String hubHostIP = System.getProperty("hub.host.ip");
		if (hubHostIP != null && !hubHostIP.isEmpty() && !hubHostIP.equals("")) {
			url = "http://" + hubHostIP + ":4444/wd/hub";

		}
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		desiredCapabilities.setCapability(CapabilityType.PLATFORM, Platform.LINUX);
		//
		// // Create a new instance of the remote web driver
		driver = new RemoteWebDriver(new URL(url), desiredCapabilities);
//
		

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

	public  void closeApplication() {
		driver.quit();
		driver = null;
	}

	public static void main(String[] args) {
		BasicFunctions function = new BasicFunctions();
		function.launchApplication();
		function.closeApplication();
	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}

}
