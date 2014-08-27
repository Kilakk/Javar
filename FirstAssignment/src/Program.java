/**
 * 
 */

import static java.lang.System.out;

/**
 * @author bednarzt
 *
 */
public class Program {

	public void drawFace() {
		out.println("\"\"\"\"\"");
		out.println(" O-O ");
		out.println("  ^  ");
		out.println(" \\_/");
	}
	
	public void drawSomeVars() {
		int n1 = 7;
		int n2 = 4;
		
		out.println(n1 + n2 + " is the answer to " + n1 + " + " + n2);
		out.println(n1 + " + " + n2 + " = " + (n1 + n2));
	}
	
	public void drawSomeMath(double array[]) {
		double sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
			
			if(i == array.length - 1) {
				out.print(array[i]);
			} 
			else {
				out.print(array[i] + " + ");
			}
		}
		
		out.println(" = " + sum);
	}
}
