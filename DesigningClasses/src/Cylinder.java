
public class Cylinder {

	private double radius;
	private double height;
	
	public Cylinder(double r, double h) {
		this.radius = r;
		this.height = h;
	}
	
	public Cylinder(double r) {
		this(r, 1.00);
	}
	
	public Cylinder() {
		this(1.00);
	}
	
	public String toString() {
		return "Cylinder: radius = " + radius + "; height = " + height;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void setRadius(double r) {
		this.radius = r;
	}
	
	public void setHeight(double h) {
		this.height = h;
	}
	
	public double volume() {
		// pi r^2 h
		return (Math.PI * Math.pow(this.radius, 2) * this.height);
	}
	
	public double surfaceArea() {
		// (2 pi r^2) + (pi 2r h)
		return ((2 * Math.PI * Math.pow(this.radius,  2)) + (Math.PI * (this.radius * 2) * this.height));
	}
}
