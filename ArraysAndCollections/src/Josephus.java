import java.util.ArrayList;


public class Josephus {

	private int step;
	
	private int position;
	
	private ArrayList<Boolean> people;
	
	/**
	 * Creates a new Josephus object with the specified number of people, starting position, and step size.
	 * @param numpeople the number of people in the line
	 * @param position the starting position
	 * @param step the step size when running the simulation
	 */
	public Josephus(int numpeople, int position, int step) {
		people = new ArrayList<Boolean>();
		
		for(int i = 0; i < numpeople; i++) {
			people.add(new Boolean(false));
		}
		
		this.position = position;
		this.step = step;
	}
	
	/**
	 * Creates the default Josephus object with a size of 100, a starting position of 0, and a step size of 3.
	 */
	public Josephus() {
		this(100, 0, 3);
	}
	
	/**
	 * Returns the string representation of the Josephus class. Includes the state of each person in the line.
	 * @return a string representation of the Josephus class
	 */
	public String toString() {
		String ret = "Josephus: {";
		
		for(int i = 0; i < people.size(); i++) {
			if(i == this.people.size() - 1) {
				ret += this.people.get(i) + "}";
			}
			
			else {
				ret += this.people.get(i) + ", ";
			}
		}
		
		return ret;
	}
	
	/*
	 * Getters
	 */
	
	/**
	 * @return the current position
	 */
	public int getPosition() {
		return this.position;
	}
	
	/**
	 * @return the current step size
	 */
	public int getStep() {
		return this.step;
	}
	
	/**
	 * @return the number of people in the line
	 */
	public int getSize() {
		return this.people.size();
	}
	
	
	/*
	 * Everything Else
	 */
	
	/**
	 * Kills the person at the specified position in the ArrayList
	 * @param pos the position in which the person is located
	 */
	private void kill(int pos) {
		this.people.set(pos, true);
	}
	
	/**
	 * Advances the position marker by the current step size, skipping people in the line who are already deceased.
	 * If the position marker reaches the end of the line, returns to the beginning of the line.
	 */
	private void step() {
		int stepleft = this.step;
		
		while(stepleft > 0) {
			position++;
			if(position >= this.people.size()) position = 0;
			
			if(this.people.get(position) == false) stepleft--;
		}
	}
	
	/**
	 * Checks if there is one and only one person left alive in the line.
	 * @return whether or not there is only one person left
	 */
	private boolean checkCompletion() {
		boolean oneleft = false;
		
		for(int i = 0; i < people.size(); i++) {
			if(this.people.get(i) == false) {
				if(oneleft) return false;
				else oneleft = true;
			}
		}
		
		return oneleft;
	}
	
	/**
	 * Main run loop for the Josephus simulator
	 */
	public void run() {
		while(!checkCompletion()) {
			kill(position);
			step();
			System.out.println(this);
		}
	}
	
	public static void main(String[] args) {
		Josephus joe = new Josephus(10, 0, 3);
		System.out.println(joe);
		System.out.println("===");
		joe.run();
		System.out.println("===\nFinal Position: " + joe.getPosition());
	}
}
