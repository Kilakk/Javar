
public class Sphere {

	private double radius;
	
	public Sphere(double r) {
		this.setRadius(r);
	}
	
	public Sphere() {
		this(1.00);
	}
	
	public String toString() {
		return "Sphere: radius = " + radius;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double r) {
		this.radius = r;
	}
	
	public double volume() {
		// 4/3 pi r^3
		return ( (4.00 / 3.00) * Math.PI * (Math.pow(this.radius, 3)));
	}
	
	public double surfaceArea() {
		return ( 4.00 * Math.PI * (Math.pow(this.radius, 2)));
	}
}
