
public class Month {

	int month;
	Year year;
	
	public Month(int month, Year year) {
		this.month = month;
		this.year = year;
	}
	
	public Month(int month) {
		this(month, new Year());
	}
	
	public Month() {
		// starts jan. 2014
		this(1);
	}
	
	public String toString() {
		return this.getMonth() + " / " + this.getYear().getIntYear() + " - days in month: " + this.getDaysInMonth();
	}
	
	static final int months31days[] = {1, 3, 5, 7, 8, 10, 12};
	private boolean has31Days() {
		for(int i = 0; i < months31days.length; i++) {
			if(months31days[i] == this.month) {
				return true;
			}
		}
		
		return false;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public Year getYear() {
		return this.year;
	}
	
	public int getDaysInMonth() {
		if(has31Days()) {
			return 31;
		}
		
		else if (this.month == 2) {
			if(year.isLeap()) {
				return 29;
			}
			
			else return 28;
		}
		
		else {
			return 30;
		}
	}
	
}
