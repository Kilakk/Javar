import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author bednarzt
 * @version 1.2
 */
public class Cashier {
	
	private double topay;
	private boolean isBuying;
	
	/**
	 * Creates a new Cashier object
	 */
	public Cashier() {
		topay = 0.00;
		isBuying = false;
	}
	
	/**
	 * @return a String representation of the Cashier class
	 */
	public String toString() {
		return "Cashier: topay = " + topay;
	}
	
	// Get
	
	/**
	 * 
	 * @return 
	 */
	public double Owed() {
		if (this.isBuying) {
			return this.topay;
		}
		
		else return 0.0;
	}
	
	public double getChange() {
		if (this.isBuying) {
			return this.topay * -1;
		}
		
		else return 0.0;
	}
	
	/**
	 * Sets up the specified item for purchase
	 */
	public void purchase(Product g) {
		this.isBuying = true;
		this.topay = round(g.getCost(), 2);
	}
	
	public void cancel() {
		this.isBuying = false;
		this.topay = 0.00;
	}
	
	public void pay(double amount) {
		if(this.isBuying) { 
			this.topay = round(this.topay - amount, 2);
		}
	}
	
	public int[] calcChange() {
		int money[] = {0, 0, 0, 0, 0};
		double change = getChange();
		
		if(change > 0) {
			
			// Dollars
			while(change >= 1) {
				money[0] += 1;
				change -= 1.00;
			}
			
			// Quarters
			while(change >= 0.25) {
				money[1] += 1;
				change -= 0.25;
			}
			
			// Dimes
			while(change >= 0.1) {
				money[2] += 1;
				change -= 0.10;
			}
			
			// Nickels
			while(change >= 0.05) {
				money[3] += 1;
				change -= 0.05;
			}
			
			// Pennies
			while(change >= 0.01) {
				money[4] += 1;
				change -= 0.01;
			}
		}
		
		return money;
	}
	
	
	// Okay.. I got some help from StackOverflow on this one
	public static double round(double value, int places) {
		
	    BigDecimal big = new BigDecimal(value);
	    big = big.setScale(places, RoundingMode.HALF_UP);
	    return big.doubleValue();
	}
	
}
