import java.util.Random;

/**
 * Simulates a regular die. Defaults to six sides.
 * @author bednarzt
 * @version 1.0
 */
public class Dice {

	private int sides;
	
	private int roll;
	
	private Random rand;
	
	/**
	 * Creates a Dice object with the specified number of sides.
	 * @param sides the number of sides the Dice object will have
	 */
	public Dice(int sides) {
		this.sides = sides;
		this.roll = -1;
		rand = new Random();
	}
	
	/**
	 * Creates the default Dice object with six sides.
	 */
	public Dice() {
		this(6);
	}
	
	/**
	 * @return a string representation of the Dice class
	 */
	public String toString() {
		return "Dice: Last roll = " + this.getRoll();
	}
	
	/**
	 * Rolls the die and stores the value of the result.
	 */
	public void roll() {
		roll = rand.nextInt(sides);
	}
	
	/**
	 * Gets the last integer to be rolled. If the die has not been rolled once yet, returns -1
	 * @return the previously rolled integer
	 */
	public int getRoll() {
		return this.roll;
	}
	
	/**
	 * Gets the number of sides on the dice.
	 * @return the number of sides
	 */
	public int getSides() {
		return this.sides;
	}
	
	/*		*/
	/* Main */
	/*		*/
	public static void main(String[] args) {
		ArrayDice die = new ArrayDice();
		ListDice die2 = new ListDice();
		CounterDice cdie = new CounterDice();
		
		for(int i = 0; i < 10000; i++) {
			die.roll();
			die2.roll();
			cdie.roll();
		}
		
		System.out.println(die);
		System.out.println(die2);
		System.out.println(cdie);
		
		
	}
}
