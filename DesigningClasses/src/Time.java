

/**
 * A class to model the time
 * @author bednarzt
 * @version 1.1
 */
public class Time {
	private int time;
	
	/**
	 * Create a new Time object at midnight
	 */
	public Time() {
		this.setTime(0);
	}
	
	/**
	 * Create a new Time object at the specified time
	 * @param time the current specified time
	 */
	public Time(int time) {
		this.setTime(time);
	}
	
	/**
	 * @return a string modeling the time in HH:MM am/pm format
	 */
	public String toString() {
		int muhhours = getHours();
		if(!isMorning()) {
			muhhours -= 12;
		}
		return String.format("%d:%d %s", muhhours, this.getMinutes(), this.ampm());
	}
	
	// Getters
	
	/**
	 * @return the current 24h time as an integer
	 */
	public int getTime() {
		return this.time;
	}
	
	/**
	 * 
	 * @return minutes past the hour of the current time, as an integer
	 */
	public int getMinutes() {
		return (this.getTime() % 100);
	}
	
	/**
	 * 
	 * @return the current hour of the current time, as an integer
	 */
	public int getHours() {
		return (this.getTime() / 100);
	}
	
	/**
	 * 
	 * @param t the Time object to find the difference between
	 * @return the difference between the two Times, as an integer
	 */
	public int getDifference(Time t) {
		return Math.abs(this.getTime() - t.getTime());
	}
	
	/**
	 * 
	 * @return whether or not it is between midnight and 12:00 noon
	 */
	public boolean isMorning() {
		return (this.getHours() < 12);
	}
	
	/**
	 * 
	 * @return a string representing whether it is morning or afternoon
	 */
	public String ampm() {
		if(isMorning()) {
			return "AM";
		}
		
		else {
			return "PM";
		}
	}
	
	// Setters
	
	/**
	 * Sets the time to the specified integer time
	 * @param time
	 * (Precondition: time must be between 0 and 2400)
	 */
	public void setTime(int time) {
		if(time > 0 && time < 2400) {
			this.time = time;
		}
	}
	
	/**
	 * Increments the time by one minute.
	 */
	public void incTime() {
		this.time++;
		if(this.time >= 2400) {
			this.time = 0;
		}
	}
	
}
