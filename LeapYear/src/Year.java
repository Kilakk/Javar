

/**
 * @author bednarzt
 *
 */
public class Year {

	private int year;
	private boolean isleap;
	
	public Year(int year) {
		this.year = year;
		this.isleap = calcLeap();
	}
	
	public Year() {
		this(2014);
	}
	
	private boolean calcLeap() {
		if(year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					return true;
				}
				
				else {
					return false;
				}
			}
			
			else {
				return true;
			}
		}
		
		else {
			return false;
		}
	}
	
	public boolean isLeap() {
		return this.isleap;
	}
	
	public int getIntYear() {
		return this.year;
	}
	
	public static void main(String args[]) {
		Month m = new Month(2, new Year(1967));
		System.out.println(m);
	}
	
}
