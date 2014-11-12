

/**
 * @author bednarzt
 * @version 1.0
 */
public class SimpleTime {
	private int time;
	
	public SimpleTime() {
		this.setTime(0);
	}
	
	public SimpleTime(int time) {
		this.setTime(time);
	}
	
	public String toString() {
		int muhhours = getHours();
		if(!isMorning()) {
			muhhours -= 12;
		}
		return String.format("Time: %d:%d %s", muhhours, this.getMinutes(), this.ampm());
	}
	
	// Getters
	
	public int getTime() {
		return this.time;
	}
	
	public int getMinutes() {
		return (this.getTime() % 100);
	}
	
	public int getHours() {
		return (this.getTime() / 100);
	}
	
	public int getDifference(SimpleTime t) {
		return Math.abs(this.getTime() - t.getTime());
	}
	
	public boolean isMorning() {
		return (this.getHours() < 12);
	}
	
	public String ampm() {
		if(isMorning()) {
			return "AM";
		}
		
		else {
			return "PM";
		}
	}
	
	// Setters
	
	public void setTime(int time) {
		if(time > 0 && time < 2400) {
			this.time = time;
		}
	}
	
}
