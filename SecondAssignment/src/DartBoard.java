//import java.awt.geom.Point2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class DartBoard {
	private Rectangle square = new Rectangle(1, 1);
	private Ellipse2D circle = new Ellipse2D.Double(0, 0, 1, 1);
	
	public DartBoard() {}
	
	// Get
	
	/**
	 * 
	 * @return the width of the rectangle
	 */
	public double getWidth() {
		return square.getWidth();
	}
	
	/**
	 * 
	 * @return the height of the rectangle
	 */
	public double getHeight() {
		return square.getHeight();
	}
	
	/**
	 * 
	 * @return the Rectangle object
	 */
	public Rectangle getBoard() {
		return square;
	}
	
	/**
	 * 
	 * @return the Circle object
	 */
	public Ellipse2D getCircle() {
		return circle;
	}
	
	/**
	 * Checks whether or not the Dart p is within the DartBoard's circle
	 * @param p
	 * @return whether the DartBoard's circle contains the Dart's point
	 */
	public boolean withinCircle(Dart p) {
		return (circle.contains(p.getPoint()));
	}
	
}
