
public class FizzBuzzReadable {

	/**
	 * The number of integers to compare
	 */
	public static final int NUMS = 100;
	
	/**
	 * @param i the integer to check the divisibility of
	 * @return whether or not the int is divisible by 5
	 */
	private static boolean isDiv5(int i) {
		return (i % 5 == 0);
	}
	
	/**
	 * @param i the integer to check the divisibility of
	 * @return whether or not the int is divisible by 3
	 */
	private static boolean isDiv3(int i) {
		return (i % 3 == 0);
	}
	
	/**
	 * main method, iterates thru numbers from 0 to NUMS 
	 * prints the int if it is not divisible by 3 or 5, 
	 * prints fizz if divisible by 3, 
	 * prints buzz if divisible by 5, 
	 * prints fizzbuzz if divisible by both
	 * @param args there are no valid arguments for this program
	 */
	public static void main(String[] args) {
		for(int i = 0; i < NUMS; i++) {
			
			// if not divisible by any, print the number and continue
			if(!isDiv3(i) && !isDiv5(i)) {
				System.out.println(i);
				continue;
			}
			
			// if divisible by 3, print fizz
			if(isDiv3(i)) System.out.print("fizz");
			
			// if divisible by 5, print buzz
			// if the int is divisible by both 3 and 5, the ouput will concat into "fizzbuzz"
			if(isDiv5(i)) System.out.print("buzz");
		}
	}
	
}
