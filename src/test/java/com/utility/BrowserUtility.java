package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public class BrowserUtility {

	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	// right click-> source -> generate constructor using fileds -> generate
	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); // Initialises the instance variable
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching browser" + browserName);
		if (browserName.equalsIgnoreCase("Chrome")) {

			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("Edge")) {

			driver.set(new EdgeDriver());
		} else {
			logger.error("Invalid Browser Name....Please select Chrome or Edge only");
			System.err.println("Invalid Browser Name....Please select Chrome or Edge only");
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching browser" + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new"); // ✅ new reliable mode
			    options.addArguments("--no-sandbox");
			    options.addArguments("--disable-dev-shm-usage");
			    options.addArguments("--disable-gpu");
			    options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			}
			else {
				driver.set(new ChromeDriver());
			}

		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old"); // headless mode
				options.addArguments("--disable-gpu");
				driver.set(new EdgeDriver(options));
			}
			driver.set(new EdgeDriver());
			
		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old"); // headless mode
				driver.set(new FirefoxDriver(options));
			}else {
			driver.set(new FirefoxDriver());
			}
			
			
		} else {
			logger.error("Invalid Browser Name....Please select Chrome or Edge only");
			System.err.println("Invalid Browser Name....Please select Chrome or Edge only");
		}
	}

	public void goToWebsite(String url) {
		logger.info("Launching the website" + url);
		driver.get().get(url);
	}

	public void maximizewindow() {
		logger.info("maximizing the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("find element with locator" + locator);

		WebElement element = driver.get().findElement(locator); // Find element !!
		logger.info("Element found and performing click" + locator);

		element.click(); // click on signIn
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("find element with locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now enter text" + locator);
		element.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("find element with locator" + locator);
		WebElement element = driver.get().findElement(locator);

		logger.info("Element found and now returning visible text" + element.getText());
		return element.getText();

	}

	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;

	}
}
