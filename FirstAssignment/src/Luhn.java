/**
 * 
 */

/**
 * @author bednarzt
 *
 */
public class Luhn {
	private String cardNum;
	
	Luhn(String cardNum) {
		if( !setNum(cardNum)) {
			this.cardNum = "123456789012345";
		}
	}
	
	private boolean checkLength(String str) {
		if(str.length() == 15) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkValid() {
		return false;
	}
	
	public boolean setNum(String cardNum) {
		if(checkLength(cardNum)) {
			this.cardNum = cardNum;
			return true;
		}
		
		return false;
	}
	
}
