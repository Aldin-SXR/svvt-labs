package ibu.svvt_lab12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class SeleniumAdvancedTest1 {
	private static WebDriver webDriver;
	private static String baseUrl;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/aldin-sxr/selenium/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--user-data-dir=/home/aldin-sxr");
		// options.addArguments("--headless");
		// options.addArguments("--window-size=768,1024");
		
		webDriver = new ChromeDriver(options);
		baseUrl = "https://www.klika.us/";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@Test
	void test() throws InterruptedException {
		webDriver.get(baseUrl);
		
		// webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/section/div[2]/div/div/div/div/div/button[2]")).click();
		
		Thread.sleep(2000);
	}

}
