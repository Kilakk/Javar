import java.util.ArrayList;
import java.util.List;


public class RoachPopulation {

	private List<Roach> roaches = new ArrayList<>();
	private int index = 0;
	
	public RoachPopulation() {
		this.addRoaches(10);
	}
	
	public RoachPopulation(int size) {
		this.addRoaches(size);
	}
	
	// Getters
	
	public String toString() {
		return "Roach population: " + this.getSize();
	}
	
	public int getSize() {
		return this.roaches.size();
	}
	
	public List<Roach> getList() {
		return this.roaches;
	}
	
	// Setters
	
	public void addRoaches(int num) {
		for(int i = 0; i < num; i++) {
			this.roaches.add(new Roach());
			this.index++;
		}
	}
	
	public void delRoaches(int num) {
		for(int i = 0; i < num; i++) {
			this.roaches.remove(index);
			this.index--;
		}
	}
	
	public void setSize(int size) {
		if(size == this.getSize()) {
			return;
		}
		
		else if(size > this.getSize()) {
			this.addRoaches(size - this.getSize());
		}
		
		else {
			
		}
	}
	
	// Modifiers
	
	public void passtime() {
		
		// 1/4 second per roach, because why not?
		int waittime;
		waittime = (250 * this.getSize());
		
		try {
			Thread.sleep(waittime);
		} catch (InterruptedException ex) {
			ex.printStackTrace(System.err);
		}
		
		// Increase the age of every roach
		for(int i = 0; i < this.getSize(); i++) {
			this.roaches.get(i).live();
		}
		
		this.doublepop();
	}
	
	/**
	 * Doubles the roach population
	 */
	public void doublepop() {
		this.setSize(this.getSize() * 2);
	}
	
	/**
	 * Kills the wealthiest 10%
	 */
	public void spray() {
		// Get 10% of the population and round to the nearest int
		int tokill = (int) Math.round(this.getSize() * 0.1);
		System.out.println("Getting ready to kill " + tokill);
		
		// Kill them dead
		for(int i = 0; i <= tokill; i++) {
			this.roaches.get(i).kill();
		}
		
		// Remove the dead from the population
		removeDead();
	}
	
	/**
	 * Removes dead roaches from the population
	 */
	public void removeDead() {
		for(int i = 0; i < this.getSize(); i++) {
			if(!this.roaches.get(i).isLiving()) {
				this.roaches.remove(i);
				this.index--;
				i = 0;
			}
		}
	}
	
}
