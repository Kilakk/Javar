

/**
 * @author bednarzt
 *
 */
public class CollegeCourse {

	private double score;
	
	/*
	 * 0 - F
	 * 1 - D
	 * 2 - C
	 * 3 - B
	 * 4 - A
	 */
	private int lettergrade;
	
	private int credits;
	private int QP;
	
	public CollegeCourse() {
		this(80, 2);
	}
	
	public CollegeCourse(double score, int credits) {
		this.score = score;
		this.credits = credits;
		
		this.lettergrade = calcLetterGrade();
		this.QP = calcQP();
	}
	
	private int calcLetterGrade() {
		
		// A
		if(getScore() >= 90) {
			return 4;
		}
		
		// B
		else if(getScore() >= 80) {
			return 3;
		}
		
		// C
		else if(getScore() >= 70) {
			return 2;
		}
		
		// D
		else if(getScore() >= 60) {
			return 1;
		}
		
		// FAILURE
		return 0;
	}
	
	private int calcQP() {
		return (credits * lettergrade);
	}
	
	public String toString() {
		return "College Course: " + getLetterGrade() + " - " + getCredits() + " credits, " + getQP() + " QP.";
	}
	
	// Get
	
	public double getScore() {
		return this.score;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public String getLetterGrade() {
		switch(lettergrade) {
			case 0:
				return "F";
			case 1:
				return "D";
			case 2:
				return "C";
			case 3:
				return "B";
			case 4:
				return "A";
			default:
				return "U";
		}
	}
	
	public int getQP() {
		return this.QP;
	}

}
