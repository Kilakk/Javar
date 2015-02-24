import java.util.LinkedList;
import java.util.ListIterator;


public class PhoneChain {

	private LinkedList<String> phonechain;
	private ListIterator<String> chainIterator;
	
	/**
	 * Creates a phone chain using "random" input values
	 */
	public PhoneChain() {
		phonechain = new LinkedList<String>();
		this.addRandom();
	}
	
	/**
	 * Creates a phone chain with a single phone number at the beginning of the Linked List
	 * @param start the phone number to insert into the list
	 */
	public PhoneChain(String start) {
		phonechain = new LinkedList<String>();
		this.addLast(start);
	}
	
	
	@Override
	/**
	 * @return a String representation of the PhoneChain class
	 */
	public String toString() {
		chainIterator = phonechain.listIterator();
		
		String ret = "Phone Chain: { ";
		String val;
		
		while(chainIterator.hasNext()) {
			val = chainIterator.next();
			
			if(chainIterator.hasNext()) ret += val + " -> ";
			else ret += val;
		}
		
		ret += " }";
		return ret;
	}
	
	/**
	 * Adds the specified phone number to the end of the LinkedList
	 * @param e the phone number to add to the list
	 */
	public void addLast(String e) {
		this.phonechain.addLast(e);
	}
	
	/**
	 * Removes and returns the last phone number in the chain
	 * @return the last phone number removed from the phone chain
	 */
	public String removeLast() {
		return this.phonechain.removeLast();
	}
	
	/**
	 * Adds random phone numbers to the phone chain
	 */
	private void addRandom() {
		this.addLast("412678945");
		this.addLast("4122256654");
		this.addLast("6105277595");
		this.addLast("7768524150");
	}
	
	/*
	 * Main
	 */
	public static void main(String[] args) {
		PhoneChain chain = new PhoneChain();
		
		System.out.println(chain);
	}
}
