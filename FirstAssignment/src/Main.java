/**
 * @author bednarzt
 *
 */

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Program prgm = new Program();
		
		// #1
		prgm.drawFace();
		
		// #2
		prgm.drawSomeVars();
		
		// #3
		double firstfive[] = {1, 2, 3, 4, 5};
		prgm.printSum(firstfive);
		
		// #3.5
		for(int i = 0; i < firstfive.length; i++) {
			firstfive[i] = 1 / firstfive[i];
		}
		prgm.printSum(firstfive);
		
		// #4
		double muhdoubles[] = prgm.randomArray(5);
		prgm.printArray(muhdoubles);
		
		System.out.print("\n");
		
		// #5
		prgm.printTable(10);
		
	}

}