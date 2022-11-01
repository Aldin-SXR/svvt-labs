package ibu.svvt_lab4;

public class NumberChecker {
	
	public static boolean isEven(int n) {
		return n % 2 == 0;
	}
	
	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= n/2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int square(int n) {
		return n * n;
	}
	
	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
