/**
 * 
 */

import static java.lang.System.out;
import java.util.Random;

/**
 * @author bednarzt
 *
 */
public class Program {

	// #1
	public void drawFace() {
		out.println("\"\"\"\"\"");
		out.println(" O-O ");
		out.println("  ^  ");
		out.println(" \\_/");
	}
	
	// #2
	public void drawSomeVars() {
		int n1 = 7;
		int n2 = 4;
		
		out.println(n1 + n2 + " is the answer to " + n1 + " + " + n2);
		out.println(n1 + " + " + n2 + " = " + (n1 + n2));
	}
	
	// #3 and #3.5
	public void printSum(double array[]) {
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
	
	// #4
	public double[] randomArray(int length) {
		double ret[] = new double[length];
		Random rand = new Random();
		
		for(int i = 0; i < ret.length; i++) {
			rand.nextDouble();
		}
		
		return ret;
	}
	
	public void printArray(double array[]) {
		for(int i = 0; i < array.length; i++) {
			out.print(array[i]);
			
			if(i != array.length - 1) {
				out.print(", ");
			}
		}
		
		out.print("\n");
	}
	
	// #5
	public void printTable(int max) {
		Random rand = new Random();
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				out.print(rand.nextInt(max) + "\t");
			}
			
			out.print("\n");
		}
		
	}
}
