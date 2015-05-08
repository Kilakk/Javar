import java.util.List;


public class QuickSort {
	
	/**
	 * Sorts a list recursively using the QuickSort algorithm.
	 * @param array the list to sort
	 * @param start the starting position of the sort
	 * @param end the ending position of the sort
	 */
	public static void sort(List<Integer> array, int start, int end) {
		int index = partition(array, start, end);
		
		if(start < (index - 1)) sort(array, start, (index - 1));
		if(index < end) sort(array, index, end);
	}
	
	/**
	 * Splits the list based on the start and end values, then iterates over each side of the list until a value greater (or less than) the pivot value is found.
	 * These values are then swapped if they are on the wrong side of the list.
	 * @param array the list to partition
	 * @param start the beginning of the partition
	 * @param end the end of the partition
	 * @return the position after the last position that was swapped
	 */
	private static int partition(List<Integer> array, int start, int end) {
		
		int pivot = array.get(start + (end - start) / 2); // middle value
		
		int i = start;
		int j = end;
		
		while (i <= j) {
			for(; array.get(i) < pivot; i++);
			for(; array.get(j) > pivot; j--);
			
			if (i <= j) {
				swap(array, i, j);
				i++;
				j--;
			}
		}
		
		return i;
	}
	
	/**
	 * Swaps the values of two positions in the list.
	 * @param array the list to swap the positions of
	 * @param a the first position
	 * @param b the second position to swap with
	 */
	private static void swap(List<Integer> array, int a, int b) {
		int temp = array.get(a);
		
		array.set(a, array.get(b));
		array.set(b, temp);
	}

}
