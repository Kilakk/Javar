public class Goods {
	private double price;
	private String name;
	
	public Goods() {
		price = 1.00;
		
		name = "Generic Item";
	}
	
	public Goods(double price) {
		this.price = price;
		this.name = "Generic Item";
	}
	
	public Goods(String name, double price) {
		this.price = price;
		this.name = name;
	}
	
	public String toString() {
		return "Goods: name = " + name + "; price = " + price;
	}
	
	
	// Gett
	
	public double getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	// Set
	public void setName(String name) {
		this.name = name;
	}
}
