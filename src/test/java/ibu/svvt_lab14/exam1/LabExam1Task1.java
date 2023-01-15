package ibu.svvt_lab14.exam1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LabExam1Task1 {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	@Order(1)
	void testAgePositive() {
		Monitor m = new Monitor("Dell", 27, 400, 2019, 120);
		
		assertEquals(4, m.age());
	}

	@Test
	@Order(2)
	void testAgeNegative() {
		Monitor m = new Monitor("Dell", 27, 400, 2019, 120);
		
		assertNotEquals(2, m.age());
	}
	
	@Test
	@Order(3)
	void testDiscountPositive() {
		Monitor m = new Monitor("Dell", 27, 400, 2019, 120);
		
		assertEquals(320, m.discount());
	}
	
	@Test
	@Order(4)
	void testDiscountNegative() {
		Monitor m = new Monitor("Dell", 27, 400, 2019, 120);
		
		assertNotEquals(400, m.discount());
	}
	
	@Test
	@Order(5)
	void testIsPremiumPositive() {
		Monitor m = new Monitor("Dell", 27, 400, 2019, 120);
		
		assertTrue(m.isPremium());
	}
	
	@Test
	@Order(6)
	void testIsPremiumNegative() {
		Monitor m = new Monitor("Dell", 24, 400, 2019, 120);
		
		assertFalse(m.isPremium());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "monitors.csv")
	@Order(7)
	void testMonitorCsv(String manufacturer, int screenSize, double price, int year, int refreshRate, boolean expected) {
		Monitor m = new Monitor(manufacturer, screenSize, price, year, refreshRate);
		
		assertEquals(expected, m.isPremium());
	}

}
