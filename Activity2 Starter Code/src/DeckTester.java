/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String ranks[] = {"A", "B", "C"};
		String suits[] = {"Apples", "Oranges"};
		int values[] = {1, 2, 3};
		
		Deck deck = new Deck(ranks, suits, values);
		Deck other = new Deck();
		
		System.out.println(deck);
		deck.deal(); deck.deal();
		
		System.out.println(deck);
		if(other.isEmpty()) System.out.println(deck.size());
	}
}
