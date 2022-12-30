package ibu.svvt_lab12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class SeleniumAdvancedTest3 {
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
	void test() throws InterruptedException {
		webDriver.get(baseUrl);
		
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		
		// js.executeScript("alert('Hello from SVVT :)')");
		
		String domain = 
			js.executeScript("return document.domain;").toString();
		
		String title = 
			js.executeScript("return document.title;").toString();

		String url = 
			js.executeScript("return document.URL;").toString();

		WebElement contactLink = webDriver.findElement(By.linkText("Contact"));
		js.executeScript("arguments[0].click()", contactLink);
		
		System.out.println(domain);
		System.out.println(title);
		System.out.println(url);
		
		js.executeScript("window.scrollBy(0, 600);");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0, -600);");
		Thread.sleep(1000);

		WebElement map = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div[3]/div[2]"));
		js.executeScript("arguments[0].scrollIntoView(true);", map);
		
		Thread.sleep(3000);
	}

}
