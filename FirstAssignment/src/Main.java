/**
 * @author bednarzt
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Program prgm = new Program();
		
		prgm.drawFace();
		prgm.drawSomeVars();
		
		double firstfive[] = {1, 2, 3, 4, 5};
		prgm.drawSomeMath(firstfive);
		
		for(int i = 0; i < firstfive.length; i++) {
			firstfive[i] = 1 / firstfive[i];
		}
		prgm.drawSomeMath(firstfive);
	}

}