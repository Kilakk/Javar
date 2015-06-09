import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TextTwistRunner {

	private TTRobot steve;
	
	private PuzzleSolver solver;
	
	private List<String> results;
	
	public TextTwistRunner() {
		try {
			
			steve = new TTRobot();
			
		} catch (AWTException e) {
			System.err.println("Robot Steve: AWTException in constructor :(");
			e.printStackTrace();
		}
		
		results = new ArrayList<String>();
		solver = new PuzzleSolver();
	}
	
	public String toString() {
		return "TextTwistRunner: using [" + this.solver + "] and " + this.steve;
	}

	public void play(String letters) {
		results = solver.solve(letters);
		
		// todo: stop assuming where the game will be
		steve.moveMouseAndClick(100, 100);
		
		for(int i = 0; i < results.size(); i++) {
			steve.typeString(results.get(i) + "\n");
		}
		
		steve.delay(2000);
		steve.pressAndRelease(KeyEvent.VK_ENTER);
		
		
		steve.moveMouseAndClick(1500, 1000);
	}
	
	/*
	 * Main functions
	 */
	
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		
		TextTwistRunner ttr = new TextTwistRunner();
		System.out.println(ttr);
		
		String input = "";
		while(true) {
			try {
				
				input = getInput();
				if(input == "" || input == null || input.equals("STOP")) break;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			ttr.play(input);
		}
		
	}
	
	public static String getInput() throws IOException {
		System.out.print("Input String: ");
		return reader.readLine();
	}
}
