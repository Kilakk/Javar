
public class Roach {

	private int age;
	private boolean alive;
	
	// Constructors
	
	public Roach() {
		this.alive = true;
		this.age = 0;
	}
	
	public Roach(int age) {
		if(age < 100) {
			this.age = age;
		}
		
		else {
			this.age = 0;
		}
		
		this.alive = true;
	}
	
	public String toString() {
		return "Roach: age = " + age + "; alive = " + alive;
	}
	
	// Getters
	
	public int getAge() {
		return this.age;
	}
	
	public boolean isLiving() {
		checkAge();
		return this.alive;
	}
	
	// Modifiers
	
	public void checkAge() {
		if(this.age >= 100) {
			this.alive = false;
		}
	}
	
	public void live() {
		this.age++;
		checkAge();
	}
	
	public void kill() {
		this.alive = false;
	}
}
