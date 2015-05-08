import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SortTester {
	
	private static List<Integer> mergeTest = new ArrayList<Integer>();
	private static final int SIZE = 100000;
	
	/**
	 * Static method to retrieve the contents of an array as a String
	 * @param name the name of the array, which will be appended to the front of the string
	 * @param array the array to return the contents of
	 * @return a String representing the array
	 */
	public static String arrayToString(String name, int[] array) {
		String ret = name + ": {";
		
		for(int i = 0; i < array.length; i++) {
			if(i == array.length - 1) ret += array[i];
			else ret += array[i] + ", ";
		}
		
		ret += "}";
		return ret;
	}
	
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
	 * Sorts a List object with QuickSort and returns the time that it took.
	 * @param list the list to sort
	 * @return the time it took to sort the list entirely, in nanoseconds
	 */
	public static long sortQuickAndTime(List<Integer> list) {
		long start = System.nanoTime();
		
		QuickSort.sort(list, 0, list.size() - 1);
		
		return (System.nanoTime() - start);
	}
	
	/**
	 * Sorts a List object with MergeSort and returns the time that it took.
	 * @param list the list to sort
	 * @return the time it took to sort the list entirely, in nanoseconds
	 */
	public static long sortMergeAndTime() {
		long start = System.nanoTime();
		
		// an assignment is necessary because mergesort doesn't modify the original list
		mergeTest = MergeSort.sort(mergeTest);
		
		return (System.nanoTime() - start);
	}

	
	/*
	 * unimportant code
	 */
	public static void a()
	{
		try {
			System.out.println("a");
			throw new RuntimeException();
		} catch (Throwable t) {
			try {
				b();
			} catch (StackOverflowError e) {
				b();
			}
			
		}
	}

	public static void b()
	{
		try {
			System.out.println("b");
			throw new RuntimeException();
		} catch (Throwable t) {
			try {
				a();
			} catch (StackOverflowError e) {
				a();
			}
		}
	}
	/*
	 * end of unimportant code
	 */
	
	public static void testQuickSort() {
		Random rand = new Random();
		
		List<Integer> myArray = new ArrayList<Integer>();
		for(int i = 0; i < SIZE; i++) {
			myArray.add(rand.nextInt(SIZE + 1));
		}
		
		//System.out.println(listToString("QSort", myArray));
		System.out.println(sortQuickAndTime(myArray));
		//System.out.println(listToString("QSorted", myArray));
	}
	
	public static void testMergeSort() {
		Random randumb = new Random();
		
		mergeTest.clear();
		for(int i = 0; i < SIZE; i++) {
			mergeTest.add(randumb.nextInt(SIZE + 1));
		}
		
		//System.out.println(listToString("mSort", mergeTest));
		System.out.println(sortMergeAndTime());
		//System.out.println(listToString("mSorted", mergeTest));
	}

	public static void main(String[] args) {
		// Mr Miller, ignore this
		a();
		
		testQuickSort();
		System.out.println("===");
		testMergeSort();
	}
}
