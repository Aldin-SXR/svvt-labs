package ibu.svvt_lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberCheckerTest {

	@ParameterizedTest
	@ValueSource(ints = {2, 4, 14, 60, -50, 30})
	void testIsEven(int n) {
		boolean result = NumberChecker.isEven(n);
		assertTrue(result);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2, 5, 17, 19, 211})
	void testIsPrime(int n) {
		boolean result = NumberChecker.isPrime(n);
		assertTrue(result);
	}
	
	@ParameterizedTest
	@CsvSource(value = {"2;4", "3;9", "5;25", "11;121"}, delimiter = ';')
	void testSquare(int n, int expected) {
		int result = NumberChecker.square(n);
		assertEquals(expected, result);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
	void testSquareFromFile(int n, int expected) {
		int result = NumberChecker.square(n);
		assertEquals(expected, result);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "fibonacci.csv", numLinesToSkip = 1)
	void testFibonaci(int n, int expected) {
		int result = NumberChecker.fibonacci(n);
		assertEquals(expected, result);
	}

}
