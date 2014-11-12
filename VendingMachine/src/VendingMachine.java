import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Models a vending machine
 * @author bednarzt
 * @version 1.0
 */
public class VendingMachine {
	
	private Map<String, List<Product>> products = new HashMap<>();
	private Product toBuy;
	
	// inside every vending machine, there is a tiny cash man who hands out change to people
	private Cashier cashman;
	
	// construct
	/**
	 * Creates a new VendingMachine object
	 * @param products an array of Products to be added into the vending machine initially
	 */
	public VendingMachine(Product products[]) {
		
		for(int i = 0; i < products.length; i++) {
			this.addProduct(products[i]);
		}
		
		//System.out.println(this);
		
		// init the change slave
		this.cashman = new Cashier();
	}
	
	/**
	 * Creates a new VendingMachine object with a single Product within it
	 * @param product the Product to be added to the vending machine
	 */
	public VendingMachine(Product product) {
		this.addProduct(product);
		this.cashman = new Cashier();
	}
	
	/**
	 * Creates a new VendingMachine with a default Product object within it
	 */
	public VendingMachine() {
		this(new Product());
	}
	
	/**
	 * Returns a string representation of the VendingMachine object
	 * @return a String with information about this VendingMachine object
	 */
	public String toString() {
		return "VendingMachine: " + this.getNumItems() + " items; " + this.products;
	}
	
	// get
	
	/**
	 * Gets the number of different items in the vending machine
	 * @return the number of different items in the vending machine
	 */
	public int getNumItems() {
		return this.products.size();
	}
	
	/**
	 * Gets the array of items available for purchase.
	 * @return an array of items available for purchase
	 */
	public String[] getItemList() {
		return this.products.keySet().toArray(new String[this.products.keySet().size()]);
	}
	
	/**
	 * Gets the list of products from the map key <code>p</code>
	 * @param p the String key to fetch the Product list from
	 * @return the list of Products
	 */
	private List<Product> getProductList(String p) {
		return this.products.get(p);
	}
	
	/**
	 * Gets the first product in the list of products with the key <code>p</code>
	 * @param p the Map key to fetch the Product from, as a string
	 * @return the first Product in the list
	 * @throws MissingProductException if the Product requested is null
	 */
	public Product getProduct(String p) throws MissingProductException {
		if(this.getProductList(p) != null) {
			return this.getProductList(p).get(0);
		}
		
		else throw new MissingProductException();
	}
	
	
	// product modification
	
	/**
	 * Removes the first product in the list of products with the key <code>p</code>
	 * @param p the Map key to remove the Product from, as a string
	 * @return the Product that was removed from the list
	 */
	private Product remProduct(String p) {
		return this.getProductList(p).remove(0);
	}
	
	/**
	 * Adds a product to the vending machine. If that type of product is already present in the machine, it is added to the list.
	 * If the product is a new kind of product, <code>addNewProduct(pr)</code> is called.
	 * @param pr the Product to add to the machine
	 */
	public void addProduct(Product pr) {
		if(this.getProductList(pr.getName()) != null) {
			this.getProductList(pr.getName()).add(pr);
		}
		
		else {
			addNewProduct(pr);
		}
	}
	
	/**
	 * Adds a new product to the vending machine and creates a new Map key to hold it.
	 * @param pr the new Product to add to the machine
	 */
	private void addNewProduct(Product pr) {
		if(this.getProductList(pr.getName()) == null) {
			List<Product> productList = new ArrayList<>();
			productList.add(pr);
			this.products.put(pr.getName(), productList);
		}
	}
	
	// purchases and money

	/**
	 * Sets up the vending machine to buy an item
	 * @param p
	 */
	public void buy(String p) {
		try {
			this.toBuy = this.getProduct(p);
		}
		
		catch (MissingProductException ex) {
			System.err.println("Couldn't find the product " + p + "! Aborting.");
			cashman.cancel();
			return;
		}
		
		cashman.purchase(toBuy);
	}
	
	/**
	 * Cancels the current purchase.
	 */
	public void cancelPurchase() {
		this.toBuy = null;
		cashman.cancel();
	}
	
	/**
	 * 
	 * @param amount the amount to pay into the vending machine, in dollars
	 * @return the change received, if any
	 */
	public double pay(double amount) {
		// make sure we actually have a balance to pay
		if(cashman.Owed() > 0) {
			cashman.pay(amount);
		}
		
		else return 0;
		
		if(cashman.Owed() <= 0) {
			dispense();
			return cashman.getChange();
		}
		
		else return 0;
	}
	
	/**
	 * 
	 * @return the amount owed to the vending machine
	 */
	public double toPay() {
		return cashman.Owed();
	}
	
	/**
	 * Dispenses toBuy to the user and removes it from the vending machine
	 */
	private void dispense() {
		System.out.println("The vending machine spits out " + toBuy.getName() + "!");
		this.retrieveChange();
		this.remProduct(toBuy.getName());
	}
	
	public void retrieveChange() {
		if(cashman.getChange() > 0) {
			System.out.println("The vending machine launches $" + cashman.getChange() + " of change at you!");
		}
		
		else {
			System.out.println("The vending machine doesn't have any change to give you!");
		}
	}
	
	/**
	 * Used to catch non-existant product lookups in the getProduct() method
	 * @author bednarzt
	 *
	 */
	public class MissingProductException extends Exception {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Creates a new MissingProductException
		 */
		public MissingProductException() {
			super();
		}
		
		/**
		 * Creates a new MissingProductException with <code>message</code> as its detail message
		 * @param message the detail message
		 */
		public MissingProductException(String message) {
			super(message);
		}
	}
}
