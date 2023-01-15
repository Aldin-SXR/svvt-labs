package ibu.svvt_lab14.exam1;

public class Monitor {
	String manufacturer;
	int screenSize;
	double price;
	int year;
	int refreshRate;
	
	public Monitor(String manufacturer, int screenSize, double price, int year, int refreshRate) {
		super();
		this.manufacturer = manufacturer;
		this.screenSize = screenSize;
		this.price = price;
		this.year = year;
		this.refreshRate = refreshRate;
	}
	
	public int age() {
		return 2023 - year;
	}
	
	public double discount() {
		if (age() > 3) {
			return 0.8 * price;
		}
		return price;
	}
	
	public boolean isPremium() {
		if (manufacturer.equals("Dell") 
				&& screenSize >= 27 && refreshRate >= 120) {
			return true;
		}
		return false;
	}
	
}
