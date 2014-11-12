
public class Cone {

	private double radius;
	private double height;
	
	public Cone(double r, double h) {
		this.radius = r;
		this.height = h;
	}
	
	public Cone(double r) {
		this(r, 1.00);
	}

	public Cone() {
		this(1.00);
	}
	
	public String toString() {
		return "Cone: radius = " + radius + "; height = " + height;
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
		// 1/3 the volume of a cylinder of the same dimensions
		return (new Cylinder(radius, height).volume() / 3.00);
	}
	
	public double surfaceArea() {
		// pi r (r + sqrt(h^2 + r^2)
		return ((Math.PI * radius) * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2))));
	}
	
}
