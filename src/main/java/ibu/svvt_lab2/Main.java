package ibu.svvt_lab2;

import java.util.Arrays;

public class Main {
	
	public static int addTwoNumbers(int one, int two) {
		return one + two;
	}
	
	public static int factorial(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
	
	public static String[] sortWords(String input) {
		String[] words = input.split(" ");
		Arrays.sort(words);
		return words;
	}
}
