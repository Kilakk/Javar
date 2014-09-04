import java.awt.geom.Point2D;
import java.util.Random;

public class Dart {
	private Point2D point = new Point2D.Double();
	private Random rand = new Random();
	private int hitnum = 0;
	
	// Construct
	
	/**
	 * Default constructor. Sets the location of the dart to (0, 0)
	 */
	public Dart() {
		this.setLocation(0, 0);
	}
	
	/**
	 * Constructs a Dart with the location (x, y)
	 * 
	 * @param x
	 * @param y
	 */
	public Dart(double x, double y) {
		this.setLocation(x, y);
	}
	
	/**
	 * Returns information on the location of the Dart.
	 * 
	 * @return a String
	 */
	public String toString() {
		return "x = " + getX() + "; y = " + getY() + " ";
	}
	
	// Get
	
	public Point2D getPoint() {
		return this.point;
	}
	
	public double getX() {
		return this.point.getX();
	}
	
	public double getY() {
		return this.point.getY();
	}
	
	public int getHits() {
		return this.hitnum;
	}
	
	// Set
	
	/**
	 * Sets the location of the dart to (x, y)
	 * 
	 * @param x
	 * @param y
	 */
	public void setLocation(double x, double y) {
		this.point.setLocation(x, y);
	}
	
	// Modify
	
	/**
	 * Throws the dart at a random location on DartBoard d
	 * 
	 * @param d
	 */
	public void throwDart(DartBoard d) {
		this.point.setLocation(rand.nextDouble(), rand.nextDouble());
		if(d.withinCircle(this)) {
			hitnum++;
		}
	}
	
}
