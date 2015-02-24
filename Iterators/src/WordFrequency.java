import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class WordFrequency {
	
	private Scanner scanner;
	
	private Map<String, Counter> frequency;
	
	private String filename;
	
	/**
	 * Creates a WordFrequency with the specified file
	 * @param filename the name of the file to calculate the word frequency of
	 */
	public WordFrequency(String filename) {
		
		frequency = new HashMap<String, Counter>();
		
		this.update(filename);
	}
	
	/**
	 * Creates a WordFrequency using stormfield.txt
	 */
	public WordFrequency() {
		this("stormfield.txt");
	}
	
	@Override
	public String toString() {
		return frequency.toString();
	}
	
	/**
	 * Modifies the WordFrequency object to use the specified file and updates the word frequency map.
	 * @param filename
	 */
	public void update(String filename) {
		this.filename = filename;
		readData();
	}
	
	/**
	 * Reads file data and updates the word frequency map accordingly.
	 */
	private void readData() {
		
		try {
			scanner = new Scanner(new FileInputStream(this.filename));
			
			while(scanner.hasNext()) {
				String toadd = scanner.next();
				
				// make lower case and remove punctuation
				toadd = cleanString(toadd);
				
				// ignore empty strings
				if(toadd.equals("")) continue;
				
				// insert the word into the mappe
				insert(toadd);
			}
		}
		catch (FileNotFoundException e) {
			System.err.println("WordFreq: the universe is burning (404)");
		}
	}
	
	/**
	 * Removes non-letter characters from a string
	 * @param str the String object to remove characters from
	 * @return a String with no non-letter characters
	 */
	private String cleanString(String str) {
		str = str.toLowerCase();
		return str.replaceAll("[^a-zA-Z ]", "");
	}
	
	/**
	 * Inserts a word into the word frequency map. If the key is already present, increments its value by one.
	 * @param str the word to insert into the frequency map.
	 */
	private void insert(String str) {
		if(frequency.containsKey(str)) {
			frequency.get(str).incr();
		}
		
		else {
			frequency.put(str, new Counter(1));
		}
	}
	
	public static void main(String[] args) {
		WordFrequency wf = new WordFrequency();
		System.out.println(wf);
	}
}
