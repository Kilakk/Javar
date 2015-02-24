import java.util.ArrayList;

/**
 * Keeps track of Dice object rolls using an ArrayList of Integers.
 * @author bednarzt
 * @version 1.0
 */
public class ListDice extends Dice {
	
	private ArrayList<Integer> sums;
	
	/**
	 * Creates the default ListDice object with 6 sides and an ArrayList of Integers to keep track of rolls.
	 */
	public ListDice() {
		super();
		this.sums = new ArrayList<Integer>();
		
		for(int i = 0; i < this.getSides(); i++) {
			sums.add(0);
		}
	}
	
	/**
	 * Includes the ArrayList of sums.
	 * @return a string representation of the ListDice class
	 */
	@Override
	public String toString() {
		String ret = "List Dice: {";
		
		for(int i = 0; i < this.sums.size(); i++) {
			if(i == this.sums.size() - 1) {
				ret += this.sums.get(i) + "}";
			}
			
			else {
				ret += this.sums.get(i) + ", ";
			}
		}
		
		return ret;
	}
	
	@Override
	/**
	 * Overrides Dice.roll() to keep track of the number of times that each side is rolled.
	 * Uses an ArrayList of Integers to increment the sum.
	 */
	public void roll() {
		super.roll();
		this.sums.set(this.getRoll(), this.sums.get(this.getRoll()) + 1);
	}
	
	/**
	 * @return the ArrayList representing the number of times each side has been rolled
	 */
	public ArrayList<Integer> getSums() {
		return this.sums;
	}
}
