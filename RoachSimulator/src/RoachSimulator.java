import static java.lang.System.out;

/**
 * @author bednarzt
 *
 */
public class RoachSimulator {
	
	private static final int RUNS = 3;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RoachPopulation simulator = new RoachPopulation();
		
		for(int i = 0; i < RUNS; i++) {
			out.println("Waiting for population to grow...");
			simulator.passtime();
			out.println("Doubled to " + simulator.toString());
			
			out.println("Killing the 10%...");
			simulator.spray();
			
			out.println(simulator.toString());
		}
		
		out.println("===========");
		out.println("Final " + simulator.toString());
	}

}
