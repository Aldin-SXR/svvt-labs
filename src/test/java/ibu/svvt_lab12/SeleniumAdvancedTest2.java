package ibu.svvt_lab12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class SeleniumAdvancedTest2 {
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
		
		String handle1 = webDriver.getWindowHandle();
		System.out.println(handle1);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[8]/a[2]")).click();
		for (String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		Thread.sleep(5000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div/div[1]/div[1]/div/div/div/div[2]/div/a/div/div/div/div/img")).click();
		Thread.sleep(2000);
		
		webDriver.close();
		
		webDriver.switchTo().window(handle1);
		
		Thread.sleep(2000);
	}

}
