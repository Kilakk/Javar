import static java.lang.System.out;

/**
 * @author bednarzt
 *
 */
public class SimpleGeo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Week 3 - #2
		SimpleLine line = new SimpleLine(0, 0, 5, 2);
		
		out.println(line);
		
		// Week 3 - #3
		SimpleTime muhtime = new SimpleTime(1530);
		out.println(muhtime);
	}

}
