import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;


public class Dictionary {

	private Map<String, List<String>> words;
	
	private String filename;
	
	private Scanner scanner;
	
	private int numValues;
	
	/*
	 * Constructors
	 */
	
	public Dictionary(String filename) {
		words = new HashMap<String, List<String>>();
		this.update(filename);
	}
	
	public Dictionary() {
		this("scrabble.txt");
	}
	
	public String toString() {
		return "Dictionary: " + words.size() + " keys for " + numValues + " values";
	}
	
	/*
	 * Update and read from file functions
	 */
	
	public void update(String filename) {
		this.filename = filename;
		this.numValues = 0;
		readFile();
	}
	
	private void readFile() {
		
		try {
			scanner = new Scanner(new FileInputStream(this.filename));
			
			while(scanner.hasNext()) {
				String toadd = scanner.next();
				
				addWord(toadd);
			}
			
			System.out.println("Dictionary: Got all file data from " + this.filename + " successfully!");
		}
		
		catch (FileNotFoundException e) {
			System.err.println("Dictionary: has anyone even been so far as to do what got look like (404)");
		}
	}
	
	private void addWord(String word) {
		String canon = getCanon(word);
		
		if(words.containsKey(canon)) {
			words.get(canon).add(word);
		}
		
		else {
			List<String> toadd = new ArrayList<>();
			toadd.add(word);
			words.put(canon, toadd);
		}
		
		numValues++;
	}
	
	/*
	 * Get
	 */
	
	public String getCanon(String word) {
		char[] canon = word.toUpperCase().toCharArray();
		
		for(int i = 1; i < canon.length; i++) {
			
			char key = canon[i];
			
			int j;
			for(j = i; j > 0 && canon[j - 1] > key; j--) {
				canon[j] = canon[j - 1];
			}
			
			canon[j] = key;
			
		}
		
		return String.valueOf(canon);
	}
	
	public String getFilename() {
		return this.filename;
	}
	
	public int getNumWords() {
		return this.numValues;
	}
	
	public Map<String, List<String>> getWords() {
		return this.words;
	}
	
	/**
	 * Gets the List of words that are composed of the input parameter.
	 * @param word the String to check the dictionary with
	 * @return the List of words that are composed of the input string. If there are none, returns null.
	 */
	public List<String> getValuesFromString(String word) {
		return (this.words.get(getCanon(word)));
	}
	
	public void printAll() {
		for(Entry<String, List<String>> entry : this.words.entrySet()) {
			String key = entry.getKey();
			List<String> value = entry.getValue();
			
			System.out.print(key + " : {");
			
			for(int i = 0; i < value.size(); i++) {
				if(i == value.size() - 1) System.out.print(value.get(i));
				else System.out.print(value.get(i) + ", ");
			}
			
			System.out.println("}");
		}
	}
}
