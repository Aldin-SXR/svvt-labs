package ibu.svvt_lab6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumIntroTest {
	private static WebDriver webDriver;
	private static String baseUrl;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/aldin-sxr/selenium/chromedriver");
		webDriver = new ChromeDriver();
		baseUrl = "https://www.ibu.edu.ba/";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@Test
	void testTitle() throws InterruptedException {
		webDriver.get(baseUrl);
		String title = webDriver.getTitle();
		assertEquals("International Burch University | IBU", title);
		Thread.sleep(3000);
	}

	@Test
	void testRedirect() throws InterruptedException {
		webDriver.get("https://lms.ibu.edu.ba");
		Thread.sleep(2000);
		String url = webDriver.getCurrentUrl();
		assertEquals("https://learning.ibu.edu.ba/", url);
	} 
	
	@Test
	void testIBUIT() {
		webDriver.get("https://www.ibu.edu.ba/department-of-information-technologies");
		assertEquals("Department of Information Technology | IBU", webDriver.getTitle());
		String source = webDriver.getPageSource();
		assertTrue(source.contains("_next"));
	}
	
	@Test
	void testCovidPage() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.navigate().to(baseUrl + "/covid");
		Thread.sleep(2000);
		assertEquals("Covid 19 measures and information | IBU", webDriver.getTitle());
		webDriver.navigate().back();
		Thread.sleep(2000);
		assertEquals(baseUrl, webDriver.getCurrentUrl());
	}
	
	@Test
	void testContactForm() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		WebElement menuButton = webDriver.findElement(By.cssSelector("#header__section__white > div.menu__wrap > div.menu__wrap > div.menu__elem > figure"));
		menuButton.click();
		Thread.sleep(3000);
		
		WebElement contactLink = webDriver.findElement(By.cssSelector("#header__section__white > div.menu__wrap > div.menu__wrap > div.desktop__bg > div.sub__menu > a:nth-child(3)"));
		contactLink.click();
		Thread.sleep(2000);
		
		WebElement name = webDriver.findElement(By.name("fullName"));
		name.sendKeys("Aldin Kovačević");
		
		WebElement email = webDriver.findElement(By.name("email"));
		email.sendKeys("aldin.kovacevic@ibu.edu.ba");
		
		WebElement subject = webDriver.findElement(By.name("subject"));
		subject.sendKeys("Hello from SVVT. :)");
		
		WebElement message = webDriver.findElement(By.name("message"));
		message.sendKeys("This is an automated test.");
		
		webDriver.findElement(By.name("message")).sendKeys("ddfd");
		
		Thread.sleep(5000);
	}
}	
