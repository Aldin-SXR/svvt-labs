package ibu.svvt_lab14.exam2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

class LabExam2Task3 {

	private static WebDriver webDriver;
	private static String baseUrl;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/aldin-sxr/selenium/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		webDriver = new ChromeDriver(options);
		baseUrl = "https://phptravels.net/";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@Test
	void test() throws InterruptedException {
		webDriver.get(baseUrl);
		
		webDriver.findElement(By.linkText("Tours")).click();
		
		webDriver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div/div[2]/a[1]")).click();
		
		Select adults = new Select(webDriver.findElement(By.name("adults")));
		adults.selectByValue("2");
		Select children = new Select(webDriver.findElement(By.name("childs")));
		children.selectByValue("1");
		Select infants = new Select(webDriver.findElement(By.name("infants")));
		infants.selectByValue("2");
		
		webDriver.findElement(By.name("date")).click();
		webDriver.findElement(By.xpath("/html/body/div[7]/div[1]/table/tbody/tr[5]/td[4]")).click();
		
		Thread.sleep(2000);
		
		WebElement price = webDriver.findElement(By.xpath("/html/body/section[2]/div[2]/div/div/div[2]/div/div/div/div/div/p/span/span"));
		assertEquals("140", price.getText());
		
		webDriver.findElement(By.xpath("/html/body/section[2]/div[2]/div/div/div[2]/div/div/div/form/div[3]/button")).click();
		
		webDriver.findElement(By.name("firstname")).sendKeys("Aldin");
		webDriver.findElement(By.name("lastname")).sendKeys("Kovačević");
		webDriver.findElement(By.name("email")).sendKeys("aldin.kovacevic@ibu.edu.ba");
		webDriver.findElement(By.name("phone")).sendKeys("+387600000000");
		webDriver.findElement(By.name("address")).sendKeys("Francuske revolucije bb.");
		
		Select title1 = new Select(webDriver.findElement(By.name("title_1")));
		title1.selectByValue("Miss");
		webDriver.findElement(By.name("firstname_1")).sendKeys("Annete");
		webDriver.findElement(By.name("lastname_1")).sendKeys("Bradford");
		
		String url = webDriver.getCurrentUrl();
		assertEquals("https://phptravels.net/tours/booking", url);
		
		Thread.sleep(2000);
	}

}
