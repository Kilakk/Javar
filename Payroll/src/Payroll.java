
/**
 * @author bednarzt
 *
 */
public class Payroll {
	
	double wages;
	double hours;
	
	double payroll;
	
	public Payroll(double wages, double hours) {
		this.wages = wages;
		this.hours = hours;
		this.payroll = calcPayroll();
		
		
	}
	
	public Payroll(double wages) {
		this(wages, 40);
	}
	
	public Payroll() {
		this(7.25);
	}
	
	public String toString() {
		return "Payroll: " + this.getHours() + " hours at $" + this.getWages() + " per hour. Made $" + this.getPayroll() + " total.";
	}
	
	public double getHours() {
		return this.hours;
	}
	
	public double getWages() {
		return this.wages;
	}
	
	public double getPayroll() {
		return this.payroll;
	}
	
	private double calcPayroll() {
		
		if (this.getHours() > 40) {
			if(this.getHours() < 48) {
				return ((40 * this.getWages()) + ((this.getHours() - 40) * this.getWages() * 1.5));
			}
			
			else {
				return (40 * this.getWages()) + (8 * this.getWages() * 1.5) + ((this.getHours() - 48) * this.getWages() * 2);
			}
		}
		
		else {
			return (this.getHours() * this.getWages());
		}
	}
	
	public static void main(String args[]) {
		Payroll jim = new Payroll(10, 49);
		System.out.println(jim);
	}
}
