import java.util.ArrayList;
import java.util.List;


public class QualityPointAverage {
	
	List<CollegeCourse> courses = new ArrayList<>();
	
	QualityPointAverage(CollegeCourse courses[]) {
		for(int i = 0; i < courses.length; i++) {
			this.courses.add(courses[i]);
		}
	}
	
	QualityPointAverage(CollegeCourse c) {
		this.courses.add(c);
	}
	
	QualityPointAverage() {
		this(new CollegeCourse());
	}
	
	// Get
	
	public double getQPA() {
		int QP = 0;
		int creds = 0;
		
		for(int i = 0; i < courses.size(); i++) {
			QP += this.courses.get(i).getQP();
			creds += this.courses.get(i).getCredits();
		}
		
		return ((double) QP / creds);
	}
	
	// Set
	
	public void addCourse(CollegeCourse c) {
		this.courses.add(c);
	}
	
	// heh main
	public static void main(String args[]) {
	
		CollegeCourse c = new CollegeCourse(95, 4);
		System.out.println(c);
		
		CollegeCourse b = new CollegeCourse(87, 4);
		System.out.println(b);
		
		CollegeCourse courses[] = {c, b};
		
		QualityPointAverage qpa = new QualityPointAverage(courses);
		System.out.println(qpa.getQPA());
	}
}
