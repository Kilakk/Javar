import java.util.Random;

/**
 * @author bednarzt
 *
 */
public class Buffon {
	
	
	private double ylow;
	private double angle; // in degrees
	
	private double yhigh;
	
	Random rand;
	
	private int hitcount;
	
	public Buffon() {
		this.ylow = 0;
		this.angle = 0;
		this.yhigh = 0;
		
		this.rand = new Random();
		
		hitcount = 0;
	}
	
	public String toString() {
		return "Needle: ylow = " + this.ylow + "; angle = " + this.angle + "; yhigh = " + this.getYHigh();
	}
	
	public void drop() {
		this.ylow = rand.nextDouble() * 2;
		this.angle = rand.nextDouble() * 180;
		
		this.yhigh = ylow + Math.sin(Math.toRadians(angle));
		
		if(this.isOver()) {
			hitcount++;
		}
	}
	
	public int getHits() {
		return this.hitcount;
	}
	
	public double getYHigh() {
		return this.yhigh;
	}
	
	public boolean isOver() {
		return (this.yhigh > 2);
	}
	
	public static void main(String args[]) {
		
		// Buffon's needle experiment (#1)
		Buffon n = new Buffon();
		
		for(int i = 0; i < 100000; i++) {
			n.drop();
			//System.out.println(n);
		}
		
		System.out.println("Hits: " + n.getHits());
		System.out.println("Approx: " + (100000.0 / n.getHits()));
		
		// Vowels (#2)
		System.out.println(Vowels.countVowels("Hello world!")); // 3
		System.out.println(Vowels.countVowels("The quick fox jumps over the lazy dog.")); // 11
	}
}
