package ibu.svvt_lab14.exam2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@TestMethodOrder(OrderAnnotation.class)
class LabExam2Task1 {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	@Order(3)
	void testErrorTypePositive() {
		Error e = new Error("Something went wrong.", "File.java", 10, 5, "2023-01-12 10:10:10", 0.2);
		assertEquals("error", e.errorType());
	}
	
	@Test
	@Order(4)
	void testErrorTypeNegative() {
		Error e = new Error("Something went wrong.", "File.java", 10, 5, "2023-01-12 10:10:10", 0.2);
		assertNotEquals("warning", e.errorType());
	}
	
	@Test
	@Order(5)
	void testIsUrgentPositive() {
		Error e = new Error("Something went wrong.", "File.java", 10, 5, "2023-01-12 10:10:10", 5.2);
		assertTrue(e.isUrgent());
	}
	
	@Test
	@Order(6)
	void testIsUrgentNegative() {
		Error e = new Error("Something went wrong.", "File.java", 10, 5, "2023-01-12 10:10:10", 0.2);
		assertFalse(e.isUrgent());
	}
	
	@Test
	@Order(1)
	void testFormatPositive() {
		Error e = new Error("Something went wrong.", "File.java", 10, 5, "2023-01-12 10:10:10", 5.2);
		assertEquals("2023-01-12 10:10:10 | 5 | File.java | 10 | Something went wrong.", e.format());
	}
	
	@Test
	@Order(2)
	void testFormatNegative() {
		Error e = new Error("Something went wrong.", "File.java", 10, 5, "2023-01-12 10:10:10", 5.2);
		assertNotEquals("wrong format", e.format());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "errors.csv")
	@Order(7)
	void testErrorsCsv(String message, String fileName, int lineNumber, int severityLevel, String dateTime,
			double occurenceAverage, String errorType) {
		Error e = new Error(message, fileName, lineNumber, severityLevel, dateTime, occurenceAverage);
		assertEquals(errorType, e.errorType());
	}
}
