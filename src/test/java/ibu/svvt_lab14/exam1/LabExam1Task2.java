package ibu.svvt_lab14.exam1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class LabExam1Task2 {
	private static WebDriver webDriver;
	private static String baseUrl;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/aldin-sxr/selenium/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		webDriver = new ChromeDriver(options);
		baseUrl = "https://www.w3schools.com/html/html_tables.asp";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@Test
	void test() {
		webDriver.get(baseUrl);
		
		WebElement cell = webDriver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[6]/td[2]"));
		String text = cell.getText();
		
		assertEquals("Yoshi Tannamuri", text);
	}

}
