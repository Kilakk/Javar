

/**
 * Approximates the arcsin of numbers
 * @author bednarzt
 * @version 1.0
 */
public class ArcsinApprox {
	/**
	 * Gets the arcsin of a double between -1 and 1 inclusive
	 * @param a the double to get the arcsin of
	 * @return the arcsin of <code>a</code>
	 */
	public static double getArcsin(double a) {
		
		if(a > 1.0 || a < -1.0) {
			System.err.println("ArcsinApprox: Input value out of range!");
			return Double.NaN;
		}
		
		double arc = a;
		int coeff = 3;
		
		double toadd = 0;
		
		double num = Math.pow(a, coeff);
		double den = factorial(coeff);
		
		// arc should be a + ((a^3) / 3!) after the first loop
		
		do {
			toadd = num / den;
			arc += toadd;
			
			
			coeff += 2;
			
			num = num * Math.pow(a, 2) * Math.pow(coeff - 2, 2);
			den = den * (coeff - 1) * coeff;

			
		} while (toadd > (1 * Math.pow(10, -6)));
		
		
		return arc;
	}
	
	/**
	 * Gets the factorial of an integer
	 * @param n the integer to find the factorial of
	 * @return the factorial of <code>n</code>
	 */
	private static double factorial(int n) {
		if(n < 1) return 0;
		
		double start = 1.0;
		
		for(int i = 1; i <= n; i++) {
			start = start * i;
		}
		
		return start;
	}
}
