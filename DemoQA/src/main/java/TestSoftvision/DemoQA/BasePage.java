package TestSoftvision.DemoQA;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestSoftvision.DemoQA.Utils.utilsValues;

public class BasePage {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void initSetUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resource\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 30);
		try {
			utilsValues.getProperties();
		} catch (IOException e) {
			System.err.println("Could not read data from property file");
			e.printStackTrace();
		}
	}

	public static void tearDown() {
		driver.close();
		if (driver.equals(null)) {
			driver.quit();
		}
	}

}
