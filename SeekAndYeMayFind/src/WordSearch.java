import java.util.List;


public class WordSearch {

	/**
	 * Tracks the number of comparisons during each search
	 */
	private static int comparisons;
	
	/**
	 * Finds a search String in the specified List using the linear algorithm. If the string is not present, returns -1.
	 * @param list the list to search through
	 * @param tofind the search key to find in the list
	 * @return the position of the search string in the list, or -1 if it is not present
	 */
	public static int linearFind(List<String> list, String tofind) {
		
		// reset comparisons
		comparisons = 0;
		
		// iterate through the array
		for(int i = 0; i < list.size(); i++) {
			comparisons++;
			if(list.get(i).equals(tofind)) return i;
		}
		
		// there's nothing here...
		return -1;
	}
	
	/**
	 * Finds a search String in the specified List using the binary algorithm. If the string is not present, returns -1.
	 * @param list the list to search through
	 * @param tofind the search key to find in the list
	 * @return the position of the search string in the list, or -1 if it is not present
	 */
	public static int binaryFind(List<String> list, String tofind) {
		
		// reset comparisons
		comparisons = 0;
		
		// return the recursive method
		return binaryRecurse(list, tofind, 0, (list.size() - 1));
	}
	
	private static int binaryRecurse(List<String> list, String tofind, int min, int max) {
		
		// there's nothing here...
		if(max < min) return -1;
		
		comparisons++;
		
		// find the middle of the array and bail if it's something silly
		int position = min + ((max - min) / 2);
		if(position < 0 || position >= list.size()) return -1;
		
		
		// compare the search key with the string at our position
		int compare = list.get(position).compareTo(tofind);
		
		if(compare > 0) {
			// System.out.println("going down to " + (position / 2));
			return binaryRecurse(list, tofind, min, (position - 1));
		}
		
		else if(compare < 0) {
			// System.out.println("going up to " + ( (list.size() - position) / 2 ) );
			return binaryRecurse(list, tofind, (position + 1), max );
		}
		
		else return position;
	}
	
	/**
	 * Gets the number of comparisons of the previously executed search.
	 * @return the number of comparisons
	 */
	public static int getComparisons() {
		return comparisons;
	}
}
