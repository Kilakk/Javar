
/**
 * Keeps track of Dice object rolls using an integer array.
 * @author bednarzt
 * @version 1.0
 */
public class ArrayDice extends Dice {

	private int[] sums;

	/**
	 * Creates the default ArrayDice object with 6 sides and an integer array to keep track of rolls.
	 */
	public ArrayDice() {
		super();
		this.sums = new int[this.getSides()];
	}
	
	/**
	 * Includes the integer array of sums.
	 * @return a string representation of the ArrayDice class
	 */
	@Override
	public String toString() {
		String ret = "Array Dice: {";
		
		for(int i = 0; i < this.sums.length; i++) {
			if(i == this.sums.length - 1) {
				ret += this.sums[i] + "}";
				break;
			}
			
			ret += this.sums[i] + ", ";
		}
		
		return ret;
	}
	
	/**
	 * Overrides Dice.roll() to keep track of the number of times that each side is rolled.
	 * Uses an integer array to increment the sum.
	 */
	@Override
	public void roll() {
		super.roll();
		this.sums[this.getRoll()]++;
	}
	
	/**
	 * @return the integer array representing the number of times each side has been rolled
	 */
	public int[] getSums() {
		return this.sums;
	}
}
