import java.util.List;
import java.util.Scanner;

public class SeekAndYeMayFind {
	
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Static method to retrieve the contents of a list as a String
	 * @param name the name of the list, which will be appended to the front of the string
	 * @param list the list to return the contents of
	 * @return a String representing the List object
	 */
	public static String listToString(String name, List<?> list) {
		String ret = name + ": {";
		
		for(int i = 0; i < list.size(); i++) {
			if(i == list.size() - 1) ret += list.get(i);
			else ret += list.get(i) + ", ";
		}
		
		ret += "}";
		return ret;
	}
	
	/**
	 * Gets the next String input from the scanner
	 * @return the String returned by the scanner object
	 */
	public static String getSearchString() {
		return scanner.nextLine();
	}
	
	public static void main(String[] args) {
		WordReader reader = new WordReader();
		List<String> thedata = reader.getData();
		
		String query;
		for(;;) {
			System.out.println("Find what search string?");
			query = getSearchString();
			System.out.println("LinearFind: list[" + WordSearch.linearFind(thedata, query) + "] after " + WordSearch.getComparisons() + " comparisons");
			System.out.println("BinaryFind: list[" + WordSearch.binaryFind(thedata, query) + "] after " + WordSearch.getComparisons() + " comparisons");
		}
	}
}
