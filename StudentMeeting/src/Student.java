

/**
 * @author bednarzt
 *
 */
public class Student {

	private String name;
	
	// 0 - 3
	// 0: freshman
	// 1: sophomore
	// 2: junior
	// 3: senior
	private int grade;
	
	// true for f
	// false for m
	private boolean gender;
	
	
	public Student(String name, int grade, boolean gender) {
		this.name = name;
		this.grade = validateGrade(grade);
		this.gender = gender;
	}
	
	public Student(String name, int grade) {
		this(name, grade, false);
	}
	
	public Student(String name) {
		this(name, 0);
	}
	
	public Student() {
		this("Tom Orrow");
	}
	
	public String toString() {
		return "Student: " + this.getName() + " (" + this.getGenderString() + ") is a " + this.getGradeString();
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getGenderString() {
		if(this.gender) {
			return "F";
		}
		
		else {
			return "M";
		}
	}
	
	public boolean getGender() {
		return this.gender;
	}
	
	public String getGradeString() {
		switch(this.grade) {
			case 0:
				return "freshman";
			case 1:
				return "sophomore";
			case 2:
				return "junior";
			case 3:
				return "senior";
			default:
				return "doesn't even go here";
		}
	}
	
	
	private int validateGrade(int g) {
		if(g > 0 && g < 4) {
			return g;
		}
		
		else if(g > 8 && g < 13) {
			return g - 9;
		}
		
		else {
			return 0;
		}
	}
}
