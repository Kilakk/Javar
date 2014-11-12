import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author bednarzt
 *
 */
public class Cashier {
	
	private double topay;
	
	public Cashier() {
		topay = 0.00;
	}
	
	public String toString() {
		return "Cashier: topay = " + topay;
	}
	
	// Get
	
	public double Owed() {
		return this.topay;
	}
	
	public double getChange() {
		return this.topay * -1;
	}
	
	/**
	 * Sets up the specified item for purchase
	 */
	public void purchase(Goods g) {
		this.topay = round(g.getPrice(), 2);
	}
	
	public void pay(double amount) {
		this.topay = round(this.topay - amount, 2);
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
