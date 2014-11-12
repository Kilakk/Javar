
/**
 * An alarm clock that rings when the specified Time has been reached
 * @author bednarzt
 * @version 1.0
 */
public class AlarmClock {
	
	Time currentTime;
	
	Time alarmTime;
	
	/**
	 * Creates a new AlarmClock at the specified current Time and the specified alarm Time
	 * @param current the current time
	 * @param alarm the time when the alarm clock will begin ringing
	 */
	public AlarmClock(Time current, Time alarm) {
		this.currentTime = current;
		this.alarmTime = alarm;
	}
	
	/**
	 * Creates a new AlarmClock at the default Time (midnight) and the specified alarm Time
	 * @param alarm the time when the alarm clock will begin ringing
	 */
	public AlarmClock(Time alarm) {
		this(new Time(), alarm);
	}
	
	/**
	 * Creates a new AlarmClock at the specified integer time and the specified alarm integer time
	 * @param current an integer representing the current time
	 * @param alarm an integer representing the time the alarm clock will begin ringing
	 */
	public AlarmClock(int current, int alarm) {
		this(new Time(current), new Time(alarm));
	}
	
	/**
	 * Creates a new AlarmClock at the default current Time (midnight) and the specified alarm integer time
	 * @param alarm an integer representing the time the alarm clock will begin ringing
	 */
	public AlarmClock(int alarm) {
		this(0, alarm);
	}
	
	/**
	 * Creates a new AlarmClock at the default current Time (midnight) and the default alarm Time (8:00 AM)
	 */
	public AlarmClock() {
		this(new Time(), new Time(800));
	}
	
	/**
	 * Displays the current set time, whether or not the alarm is ringing, and the set alarm time
	 * @return a string modeling the alarm clock class
	 */
	public String toString() {
		return "AlarmClock: " + this.currentTime + " - " + (this.isRinging() ? "started ringing" : "will ring") + " at " + this.alarmTime;
	}
	
	// Getters
	
	/**
	 * @return the current set time
	 */
	public Time getCurrentTime() {
		return this.currentTime;
	}
	
	/**
	 * @return the set alarm time
	 */
	public Time getAlarmTime() {
		return this.alarmTime;
	}
	
	/**
	 * @return whether or not the current set time has surpassed or is equal to the set alarm time
	 */
	public boolean isRinging() {
		return (this.currentTime.getTime() >= this.alarmTime.getTime());
	}
	
	// Setters
	
	/**
	 * Sets the current time to the specified Time object
	 * @param current the Time object representing the current time
	 */
	public void setCurrentTime(Time current) {
		this.currentTime = current;
	}
	
	/**
	 * Sets the current time to the specified time, as an integer
	 * @param ctime an integer representing the current time
	 */
	public void setCurrentTime(int ctime) {
		this.currentTime = new Time(ctime);
	}
	
	/**
	 * Sets the alarm time to the specified Time object
	 * @param alarm the Time object representing the alarm time
	 */
	public void setAlarmTime(Time alarm) {
		this.alarmTime = alarm;
	}
	
	/**
	 * Sets the alarm time to the specified time, as an integer
	 * @param atime an integer representing the alarm time
	 */
	public void setAlarmTime(int atime) {
		this.alarmTime = new Time(atime);
	}
	
	// maine
	public static void main(String[] args) {
		AlarmClock c = new AlarmClock(1555, 1550);
		System.out.println(c);
		
		// we've got to go back...
		c.setCurrentTime(1530);
		System.out.println(c);
	}
}
