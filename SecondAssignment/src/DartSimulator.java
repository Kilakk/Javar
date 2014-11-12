import java.awt.Rectangle;
import java.awt.Point;
//import java.awt.geom.Point2D;
import java.util.Random;
import static java.lang.System.out;

/**
 * @author bednarzt
 * @since 1.0
 */
public class DartSimulator {
	
	public static final double RUNS = 10000.0;

	/**
	 * Entry point
	 * @param args
	 */
	public static void main(String[] args) {
		
		// #1a
		makeRectangles();
		out.println();
		
		// #1b
		if(findRandomPoint()) {
			out.println("woohoo!");
		}
		else {
			out.println("boohoo :(");
		}
		
		out.println();
		
		// #2 - monte carlo
		Dart d = new Dart();
		DartBoard board = new DartBoard();
		
		for(int i = 0; i < RUNS; i++) {
			d.throwDart(board);
			out.print(d.toString());
			
			if(board.withinCircle(d)) {
				out.print("... was within the circle");
			}
			
			out.print("\n");
		}
		
		double ratiohit = (d.getHits() / RUNS);
		
		out.println();
		out.println("dart hit the circle " + d.getHits() + " / " + RUNS + " times, which is " + ratiohit * 100 + "%");
		out.println(ratiohit + " * 4 = " + ratiohit * 4);
		
	}
	
	/**
	 * #1a
	 * Makes two rectangles and prints them,
	 * then makes a third rectangle based on the intersection of the first two
	 */
	public static void makeRectangles() {
		
		// not overlapping
		Rectangle rect = new Rectangle(120, 120, 30, 15);
		Rectangle otherrect = new Rectangle(7, 20);
		out.println(rect);
		out.println(otherrect);
		
		Rectangle inter = new Rectangle(rect.intersection(otherrect));
		out.println(inter);
	}
	
	/**
	 * #1b
	 * Creates a point in a random location,
	 * then creates a rectangle in a random location.
	 * 
	 * @return whether or not the random rectangle contains the random point
	 */
	public static boolean findRandomPoint() {
		Random rand = new Random();
		
		Point p = new Point(rand.nextInt(11), rand.nextInt(11));
		out.println(p);
		
		Rectangle r = new Rectangle(rand.nextInt(11), rand.nextInt(11));
		out.println(r);
		
		return (r.contains(p));
	}

}
