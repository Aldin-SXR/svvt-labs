package ibu.svvt_lab2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("My happy class")
class DBTest {
	static DB database;
	
	@BeforeAll
	static void whatever() throws Exception {
		database = new DB();
		database.connect();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		database.disconnect();
		database = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		database.insert("Hello");
		database.insert("World");
	}

	@AfterEach
	void tearDown() throws Exception {
		database.clear();
	}

	@Test
	@Order(2)
	@DisplayName("Check if getting data from DB works")
	void testGet() {
		assertEquals("Hello", database.get(0));
	}
	
	@Test
	@Order(1)
	@Disabled
	void testCount() {
		assertEquals(2, database.count());
	}
	
	@Test
	@Order(3)
	@EnabledOnOs({OS.MAC, OS.WINDOWS})
	void testClear() {
		database.clear();
		assertEquals(0, database.count());
	}
	
	@Test
	@Order(4)
	void testInsert() {
		database.insert("Java");
		assertEquals(3, database.count());
		assertEquals("Java", database.get(2));
	}
	
	@Test
	void testExceptions1() {
		Exception e = assertThrows(IndexOutOfBoundsException.class, () -> {
			String something = database.get(10);
		});
	}
	
	@Test
	void testExceptions2() {
		try {
			String something = database.get(10);
			fail("No exception thrown.");
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}
	}
}
