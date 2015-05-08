/**
 * Card.java
 *
 * <code>Card</code> represents a playing card.
 */
public class Card {

	/**
	 * String value that holds the suit of the card
	 */
	private String suit;

	/**
	 * String value that holds the rank of the card
	 */
	private String rank;

	/**
	 * int value that holds the point value.
	 */
	private int pointValue;

	/*
	 * Constructor
	 */

   /**
	 * Creates a new <code>Card</code> instance.
	 *
	 * @param cardRank  a <code>String</code> value
	 *                  containing the rank of the card
	 * @param cardSuit  a <code>String</code> value
	 *                  containing the suit of the card
	 * @param cardPointValue an <code>int</code> value
	 *                  containing the point value of the card
	 */
	public Card(String cardRank, String cardSuit, int cardPointValue) {
		this.rank = checkCardRank(cardRank);
		this.suit = checkCardSuit(cardSuit);
		this.pointValue = cardPointValue;
	}
	
	public Card(String rank, String suit) {
		this(rank, suit, 0);
	}
	
	public Card() {
		this("A", "H");
	}
	
	/*
	 * Check functions
	 */
	private String checkCardRank(String rank) {
		
		// integer value card (between 1 and 11)
		if(!isFace(rank)) return rank;
		
		/*
		 * Face cards:
		 * - A is Ace
		 * - J is Jack
		 * - Q is Queen
		 * - K is King
		 */
		switch(rank) {
			case "A":
			case "J":
			case "Q":
			case "K":
				return rank;
			default:
				return "UNKN";
		}
	}
	
	private String checkCardSuit(String suit) {
		switch(suit) {
			case "H":
			case "D":
			case "C":
			case "S":
				return suit;
			default:
				return "UNKN";
		}
	}
	
	public boolean isFace(String rank) {
		try {
			if(Integer.valueOf(rank) < 11 && Integer.valueOf(rank) > 1) return false;
			else return true;
		}
		
		catch (NumberFormatException ex) {
			return true;
		}
	}


	/*
	 * Getters
	 */
	
	/**
	 * Accesses this <code>Card's</code> suit.
	 * @return this <code>Card's</code> suit.
	 */
	public String suit() {
		return this.suit;
   }

	/**
	 * Accesses this <code>Card's</code> rank.
	 * @return this <code>Card's</code> rank.
	 */
	public String rank() {
		return this.rank;
	}

   /**
	 * Accesses this <code>Card's</code> point value.
	 * @return this <code>Card's</code> point value.
	 */
	public int pointValue() {
		return this.pointValue;
	}

	/** Compare this card with the argument.
	 * @param otherCard the other card to compare to this
	 * @return true if the rank, suit, and point value of this card
	 *              are equal to those of the argument;
	 *         false otherwise.
	 */
	public boolean matches(Card otherCard) {
		if(otherCard.rank().equals(this.rank)) {
			if(otherCard.suit().equals(this.suit)){
				if(otherCard.pointValue() == this.pointValue){
					return true;
				}
			}
		}
		
		return false;
	}

	/**
	 * Converts the rank, suit, and point value into a string in the format
	 *     "[Rank] of [Suit] (point value = [PointValue])".
	 * This provides a useful way of printing the contents
	 * of a <code>Deck</code> in an easily readable format or performing
	 * other similar functions.
	 *
	 * @return a <code>String</code> containing the rank, suit,
	 *         and point value of the card.
	 */
	@Override
	public String toString() {
		return "Card: " + this.rank + " of " + this.suit + " (point value = " + this.pointValue + ")";
	}
}
