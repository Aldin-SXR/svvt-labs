package ibu.svvt_lab11;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

class SeleniumWaitTest {
	private static WebDriver webDriver;
	private static String baseUrl;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/aldin-sxr/selenium/chromedriver");
		webDriver = new ChromeDriver();
		baseUrl = "https://www.ibu.edu.ba/";
		// webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

//	@Test
//	void testWait() {
//		webDriver.get(baseUrl);
//		webDriver.manage().window().maximize();
//		webDriver.findElement(By.xpath("//*[@id=\"header__section__white\"]/div[2]/div[2]/div[1]/figure")).click();
//		// webDriver.findElement(By.linkText("Contact us")).click();
//		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
//		WebElement contactLink = wait.until(
//			ExpectedConditions.visibilityOfElementLocated(
//				By.linkText("Contact us")
//			)
//		);
//		contactLink.click();
//	}
	
	@Test
	void testHumanBenchmark() throws InterruptedException {
		webDriver.get("https://humanbenchmark.com/tests/reactiontime");
		
		WebElement area = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[4]"));
		area.click();
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(webDriver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1));
		wait.ignoring(NoSuchElementException.class);
		
		wait.until(
			ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("/html/body/div[1]/div/div[4]/div[1]/div/div/div/h1/div"), 
				"Click!")
		);
		area.click();
		
		Thread.sleep(5000);
	}

}
