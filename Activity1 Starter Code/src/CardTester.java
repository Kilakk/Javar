/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card myCard = new Card();
		System.out.println(myCard);
		
		Card other = new Card("4", "S", 4);
		System.out.println(other);
		System.out.println(other.matches(myCard));
		
		Card third = new Card("7", "D");
		System.out.println(third);
		System.out.println(myCard.pointValue() == third.pointValue());
	}
}
