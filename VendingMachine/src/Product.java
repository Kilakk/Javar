
/**
 * Products for the vending machine
 * @author bednarzt
 * @version 1.1
 */
public class Product {
	
	private String name;
	private double cost;
	
	/**
	 * Creates a new Product object with the specified name and cost
	 * @param name the name of the Product
	 * @param cost the cost of the Product as a double
	 */
	public Product(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}
	
	/**
	 * Creates a new Product with the specified name and the default cost of $1.00
	 * @param name the name of the Product
	 */
	public Product(String name) {
		this(name, 1.00);
	}
	
	/**
	 * Creates a new Product with the default name "Chips" and the default cost of $1.00
	 */
	public Product() {
		this("Chips");
	}
	
	/**
	 * @return a String representation of the Product class
	 */
	public String toString() {
		return "Product[" + this.getName() + ", " + this.getCost() + "]";
	}
	
	/**
	 * @return the name of the Product as a String
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return the cost of the Product with <code>double</code> precision
	 */
	public double getCost() {
		return this.cost;
	}
}
