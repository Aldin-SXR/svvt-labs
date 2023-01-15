package ibu.svvt_lab14.exam1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

class LabExam1Task3 {
	private static WebDriver webDriver;
	private static String baseUrl;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/aldin-sxr/selenium/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		webDriver = new ChromeDriver(options);
		baseUrl = "https://the-internet.herokuapp.com/";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@Test
	void test() throws InterruptedException {
		webDriver.get(baseUrl);
		
		webDriver.findElement(By.linkText("Form Authentication")).click();
		
		webDriver.findElement(By.name("username")).sendKeys("tomsmith");
		webDriver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
		
		String url = webDriver.getCurrentUrl();
		assertEquals("https://the-internet.herokuapp.com/secure", url);
		
		Thread.sleep(2000);
		webDriver.findElement(By.linkText("Logout")).click();
		
		Thread.sleep(2000);
		
		webDriver.get(baseUrl);
		webDriver.findElement(By.linkText("Checkboxes")).click();

		webDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).click();
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).click();
		
		webDriver.navigate().back();
		webDriver.findElement(By.linkText("Dropdown")).click();
		
		Select dropdown = new Select(webDriver.findElement(By.id("dropdown")));
		dropdown.selectByVisibleText("Option 2");
		
		Thread.sleep(2000);
	}

}
