import java.awt.Rectangle;
import java.awt.Point;
import static java.lang.System.out;

/**
 * @author bednarzt
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		makeRectangles();

	}
	
	public static void makeRectangles() {
		
		// not overlapping
		Rectangle rect = new Rectangle(120, 120, 30, 15);
		Rectangle otherrect = new Rectangle(7, 20);
		out.println(rect);
		out.println(otherrect);
		
		Rectangle inter = new Rectangle(rect.intersection(otherrect));
		out.println(inter);
	}

}
