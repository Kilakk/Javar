import java.util.ArrayList;

/**
 * Keeps track of Dice object rolls using an ArrayList of Counters.
 * @author bednarzt
 * @version 1.0
 */
public class CounterDice extends Dice {

	private ArrayList<Counter> sums;
	
	/**
	 * Creates the default CounterDice object with 6 sides and an ArrayList of Counter objects to keep track of rolls.
	 */
	public CounterDice() {
		super();
		this.sums = new ArrayList<Counter>();
		
		for(int i = 0; i < this.getSides(); i++) {
			this.sums.add(new Counter());
		}
	}
	
	/**
	 * Includes the ArrayList of Counter objects representing the sums.
	 * @return a string representation of the ArrayDice class
	 */
	@Override
	public String toString() {
		String ret = "Counter Dice: {";
		
		for(int i = 0; i < sums.size(); i++) {
			if(i == this.sums.size() - 1) {
				ret += this.sums.get(i).getCount() + "}";
			}
			
			else {
				ret += this.sums.get(i).getCount() + ", ";
			}
		}
		
		return ret;
	}
	
	/**
	 * Overrides Dice.roll() to keep track of the number of times that each side is rolled.
	 * Uses an ArrayList of Counters to increment the sum.
	 */
	@Override
	public void roll() {
		super.roll();
		this.sums.get(this.getRoll()).incr();
	}
	
	/**
	 * @return the ArrayList of Counters representing the number of times each side has been rolled
	 */
	public ArrayList<Counter> getSums() {
		return this.sums;
	}
}
