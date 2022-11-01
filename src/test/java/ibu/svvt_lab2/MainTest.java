package ibu.svvt_lab2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

	@BeforeAll
	static void whatever() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddTwoNumbers() {
		int result = Main.addTwoNumbers(3, 4);
		assertEquals(7, result);
		assertNotEquals("Hi", "Hello");
	}
	
	@Test
	public void testFactorial() {
		int result = Main.factorial(5);
		assertEquals(120, result);
	}
	
	@Test
	public void testArrays() {
		String[] array1 = {"Hello", "world"};
		String[] array2 = {"Hello", "world"};
		assertArrayEquals(array1, array2);
	}
	
	@Test
	public void testBooleans() {
		assertTrue(2 > 1);
		assertFalse(1 < 0);
		
		assertEquals(true, 3 > 1);
	}
	
	@Test
	public void testNulls() {
		String n = null;
		assertNull(n);
		n = "data";
		assertNotNull(n);
	}
	
	@Test
	public void testSortWords1() {
		String input = "hello everyone";
		String[] expected = {"everyone", "hello"};
		String[] words = Main.sortWords(input);
		assertArrayEquals(expected, words);
	}
	
	@Test
	public void testSortWords2() {
		String input = "i like this course";
		String[] expected = {"course", "i", "like", "this"};
		String[] words = Main.sortWords(input);
		assertArrayEquals(expected, words);
	}
}
