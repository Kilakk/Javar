import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordReader {

	private String filename;
	
	private Scanner scanner;
	
	private List<String> data;
	
	/*
	 * Construct
	 */
	public WordReader(String filename) {
		data = new ArrayList<String>();
		
		this.update(filename);
	}
	
	public WordReader() {
		this("scrabble.txt");
	}
	
	@Override
	public String toString() {
		return SeekAndYeMayFind.listToString("Scrabble", this.data);
	}
	
	/*
	 * Modifiers
	 */
	
	/**
	 * Clears the data list and resets the stored filename
	 */
	public void clear() {
		data.clear();
		this.filename = "CLEARED";
	}
	
	/**
	 * Modifies the WordReader object to use the specified file and updates the data list.
	 * @param filename
	 */
	public void update(String filename) {
		this.filename = filename;
		readFile();
	}
	
	/**
	 * Reads file data and updates the data list accordingly
	 */
	private void readFile() {
		
		try {
			scanner = new Scanner(new FileInputStream(this.filename));
			
			while(scanner.hasNext()) {
				String toadd = scanner.next();
				
				data.add(toadd);
			}
			
			System.out.println("WordReader: Got all file data from " + this.filename + " successfully!");
		}
		catch (FileNotFoundException e) {
			System.err.println("WordReader: has anyone even been so far as to do what got look like (404)");
		}
	}
	
	/*
	 * Get
	 */
	public String getFilename() {
		return this.filename;
	}
	
	public List<String> getData() {
		return this.data;
	}
}
