package ibu.svvt_lab12;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

class SeleniumAdvancedTest4 {
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
		baseUrl = "https://www.atlantbh.com/";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@Test
	void test1() throws InterruptedException {
		webDriver.get(baseUrl);
		
		WebElement blogLink = webDriver.findElement(By.linkText("Blog"));
		
		Actions builder = new Actions(webDriver);
		
		Action doWhatever = 
			builder
				.moveToElement(blogLink)
				.moveByOffset(0, 130)
				.click()
				.build();
		
		doWhatever.perform();
		
		Thread.sleep(3000);
	}
	

	@Test
	void test2() throws InterruptedException {
		webDriver.get(baseUrl);
				
		Actions builder = new Actions(webDriver);
		
		Action contactActions = 
			builder
				.moveToElement(webDriver.findElement(By.name("ask-us")))
				.click()
				.sendKeys("Hello")
				.sendKeys(Keys.ENTER)
				.pause(Duration.ofSeconds(2))
				.keyDown(Keys.SHIFT)
				.sendKeys("world")
				.pause(Duration.ofSeconds(2))
				.keyUp(Keys.SHIFT)
				.doubleClick()
				.build();
		
		contactActions.perform();
		
		Thread.sleep(3000);
	}

}
