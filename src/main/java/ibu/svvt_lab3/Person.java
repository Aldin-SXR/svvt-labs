package ibu.svvt_lab3;

public class Person {
	int age;
	
	public Person(int age) {
		this.age = age;
	}
	
	public boolean isAdult() {
		if (age >= 18) {
			return true;
		}
		return false;
	}
	
	public boolean canGoToSchool() {
		if (age >= 6) {
			return true;
		}
		return false;
	}
}
