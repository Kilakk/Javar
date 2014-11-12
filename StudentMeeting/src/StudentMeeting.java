
public class StudentMeeting {

	public static void main(String[] args) {
		Student joe = new Student("Tyler Besselman", 1, false);
		System.out.println(joe);

		System.out.println("To the Parents of " + joe.getName());
		System.out.println("Your " + (joe.getGender() ? "daughter" : "son") + " is required to bring " + (joe.getGender() ? "her" : "his") + " iPad with " + (joe.getGender() ? "her" : "him") + " to the " + joe.getGradeString() + " meeting.");
		
	}

}
