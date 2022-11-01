package ibu.svvt_lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonTest {
	static Person[] people;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		people = new Person[5];
		people[0] = new Person(34);
		people[1] = new Person(40);
		people[2] = new Person(19);
		people[3] = new Person(89);
		people[4] = new Person(67);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		people = null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Order(2)
	void testIsAdult() {
		Person p = new Person(25);
		assertTrue(p.isAdult());
//		assertEquals(true, p.isAdult());
	}
	
	@Test
	@Order(3)
	void testIsChild() {
		Person p = new Person(12);
		assertFalse(p.isAdult());
	}
	
	@Test
	@Order(4)
	void testPeopleArray() {
		for (Person p: people) {
			assertTrue(p.isAdult());
		}
	}
	
	@Test
	@Order(1)
	void testCanGoToSchool() {
		Person p = new Person(12);
		assertTrue(p.canGoToSchool());
	}
}
