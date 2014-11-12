import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ArcsinTest {

	private static BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
	private static String input;
	
	private static double inputnum;
	
	private static boolean running;
	
	public static void main(String args[]) throws IOException {
		running = true;
		
		while(running) {
			input = inputStream.readLine();
			
			if(input.equalsIgnoreCase("exit")) {
				running = false;
				break;
			}
			
			else {
				try {
					inputnum = Double.valueOf(input);
				}
				
				catch (NumberFormatException ex) {
					System.err.println("ArcsinText: Input was not a double or an exit command!");
					continue;
				}
				
				System.out.println("ArcsinApprox " + inputnum + ": " + ArcsinApprox.getArcsin(inputnum));
				System.out.println("Math.asin(" + inputnum + "): " + Math.asin(inputnum));
			}
		}
	}

}
