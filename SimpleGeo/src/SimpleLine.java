import java.awt.geom.Point2D;

public class SimpleLine {
	private Point2D ptOne;
	private Point2D ptTwo;
	
	public SimpleLine(Point2D ptOne, Point2D ptTwo) {
		this.ptOne = ptOne;
		this.ptTwo = ptTwo;
	}
	
	public SimpleLine(double x, double y, double length) {
		this.ptOne = new Point2D.Double(x, y);
		this.ptTwo = new Point2D.Double(x + length, y + length);
	}
	
	public SimpleLine(double x1, double y1, double x2, double y2) {
		this.ptOne = new Point2D.Double(x1, y1);
		this.ptTwo = new Point2D.Double(x2, y2);
	}
	
	public SimpleLine() {
		this(0.0, 0.0, 0.0, 0.0);
	}
	
	// Getter
	
	public String toString() {
		return "SimpleLine (" + this.ptOne.getX() + ", " + this.ptOne.getY() + ") to (" + this.ptTwo.getX() + ", " + this.ptTwo.getY() + "), eqn[ " + equation() + "]";
	}
	
	public double getSlope() {
		try {
			double slope = (this.vDist() / this.hDist());
			return slope;
		}
		
		catch (ArithmeticException ex) {
			return 0.0;
		}
	}
	
	public double hDist() {
		return Math.abs(this.ptOne.getX() - this.ptTwo.getX());
	}
	
	public double vDist() {
		return Math.abs(this.ptOne.getY() - this.ptTwo.getY());
	}
	
	public double getLength() {
		return this.ptOne.distance(ptTwo);
	}
	
	public Point2D midpoint() {
		return new Point2D.Double( (ptOne.getX() + ptTwo.getX()) / 2.0, (ptOne.getY() + ptTwo.getY()) / 2.0);
	}
	
	public String equation() {
		double b = ptOne.getY() - (getSlope() * ptOne.getX());
		return "y = " + getSlope() + "x + " + b;
	}
	
	// Set
	
	public void setPointOne(double x, double y) {
		this.ptOne.setLocation(x, y);
	}
	
	public void setPointTwo(double x, double y) {
		this.ptTwo.setLocation(x, y);
	}
}
