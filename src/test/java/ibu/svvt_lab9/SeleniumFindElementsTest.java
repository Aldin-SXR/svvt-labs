package ibu.svvt_lab9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

class SeleniumFindElementsTest {
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
	void testDean() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		webDriver.findElement(By.cssSelector("#header__section__white > div.menu__wrap > div.menu__wrap > div.menu__elem > figure")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.cssSelector("#header__section__white > div.menu__wrap > div.menu__wrap > div.desktop__bg > div.desktop__menu__wrap > div > button:nth-child(1)")).click();
		webDriver.findElement(By.cssSelector("#header__section__white > div.menu__wrap > div.menu__wrap > div.desktop__bg > div.desktop__menu__wrap > div.menu__content__wrap.active__item > div > nav > button:nth-child(1)")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.linkText("Faculty of Engineering and Natural Sciences")).click();
		Thread.sleep(2000);
		
		String deanText = webDriver.findElement(By.className("dean__footer")).getText();
		assertTrue(deanText.contains("Jasmin Kevrić"));
	}

	@Test
	void testSearch() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		WebElement menuIcon = webDriver.findElement(By.cssSelector("#header__section__white > div.menu__wrap > div.menu__wrap > div.menu__elem > figure"));
		webDriver.findElement(
				RelativeLocator.with(By.tagName("figure"))
				.toLeftOf(menuIcon)).click();
		
		WebElement inputBox = webDriver.findElement(By.xpath("/html/body/div/div/div/div/section[1]/div/div/div/form/div/div/input"));
		inputBox.sendKeys("engineering");
		Thread.sleep(1000);
		
		webDriver.findElement(
				RelativeLocator.with(By.tagName("a"))
				.below(inputBox)).click();
		
		Thread.sleep(2000);
	}


}
