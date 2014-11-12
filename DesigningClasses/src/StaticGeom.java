import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;


/**
 * @author bednarzt
 *
 */
public class StaticGeom {
	
	/**
	 * @return a string describing the StaticGeom class
	 */
	public String toString() {
		return "It is a StaticGeom.";
	}
	
	public static double sphereVolume(double r) {
		// 4/3 pi r^3
		return ( (4.00 / 3.00) * Math.PI * (Math.pow(r, 3)));
	}
	
	public static double sphereSurface(double r) {
		// 4 pi r^2
		return ( 4.00 * Math.PI * (Math.pow(r, 2)));
	}
	
	public static double cylinderVolume(double r, double h) {
		// pi r^2 h
		return (Math.PI * Math.pow(r, 2) * h);
	}
	
	public static double cylinderSurface(double r, double h) {
		// (2 pi r^2) + (pi 2r h)
		return ((2 * Math.PI * Math.pow(r,  2)) + (Math.PI * (r * 2) * h));
	}
	
	public static double coneVolume(double r, double h) {
		// 1/3 the volume of a cylinder of the same dimensions
		return (StaticGeom.cylinderVolume(r, h) / 3.00);
	}
	
	public static double coneSurface(double r, double h) {
		// pi r (r + sqrt(h^2 + r^2)
		return ((Math.PI * r) * (r + Math.sqrt(Math.pow(h, 2) + Math.pow(r, 2))));
	}

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		
		double radius = getInput(scn, "Radius");
		double height = getInput(scn, "Height");
		
		
		out.println("Sphere Volume: " + StaticGeom.sphereVolume(radius));
		out.println("Sphere Surface: " + StaticGeom.sphereSurface(radius));
		
		out.println("==================");
		
		out.println("Cylinder Volume: " + StaticGeom.cylinderVolume(radius, height));
		out.println("Cylinder Surface: " + StaticGeom.cylinderSurface(radius, height));
		
		out.println("==================");
		
		out.println("Cone Volume: " + StaticGeom.coneVolume(radius, height));
		out.println("Cone Surface: " + StaticGeom.coneSurface(radius, height));
		
	}
	
	private static double getInput(Scanner scn, String what) {
		double output;
		
		try {
			out.print(what + ": ");
			output = scn.nextDouble();
		} 
		
		catch(InputMismatchException ex) {
			// using recursion to ask the user for another value ends in a stack overflow
			// thanks, scanner
			return 1.00;
		}
		
		return output;
	}

}
