
/**
 * Keeps count of something.
 * @author bednarzt
 * @version 1.0
 */
public class Counter {
	
	/**
	 * The current count held by the Counter object.
	 */
	private int count;
	
	/**
	 * Creates the default Counter object with the count set to 0
	 */
	public Counter() {
		count = 0;
	}
	
	/**
	 * Creates a Counter object with the count set to <code>n</code>
	 * @param n the int to initialize the count to
	 */
	public Counter(int n) {
		count = n;
	}
	
	public String toString() {
		return "Counter: count = " + count;
	}
	
	/**
	 * Increases the count by 1.
	 */
	public void incr() {
		count++;
	}
	
	/**
	 * Decreases the count by 1.
	 */
	public void decr() {
		count--;
	}
	
	/**
	 * Resets the count to 0.
	 */
	public void reset() {
		count = 0;
	}
	
	/**
	 * 
	 * @return the current count
	 */
	public int getCount() {
		return this.count;
	}
	
	/**
	 * Sets the count to the specified integer value.
	 * @param c the value to set the count to
	 */
	public void setCount(int c) {
		count = c;
	}
}
