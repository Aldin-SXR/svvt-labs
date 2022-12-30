package ibu.svvt_lab10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumCheckboxTest {
	private static WebDriver webDriver;
	private static String baseUrl;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/aldin-sxr/selenium/chromedriver");
		webDriver = new ChromeDriver();
		baseUrl = "https://demoqa.com/checkbox";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@Test	
	void testChecboxes() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		webDriver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button")).click();
		
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/ol/li/ol/li[2]/span/label/span[3]")).click();
		
		webDriver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button")).click();
		
		assertTrue(webDriver.findElement(By.id("tree-node-workspace")).isSelected());
		assertTrue(webDriver.findElement(By.id("tree-node-office")).isSelected());

		Thread.sleep(3000);
	}

}
