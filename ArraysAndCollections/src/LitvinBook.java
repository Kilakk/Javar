import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/*
 * 12. Write a method that takes an ArrayList<String> and returns a new ArrayList<String> in which the elements are stored in reverse order. 
 *     The original list should remain unchanged.
 * 
 * 13. Write a method that removes the smallest value from an ArrayList<Integer>. 
 *     (Hint: Integer has a method compareTo(Integer other) that returns a positive integer if this is greater than other, a negative integer if this is less than other, and 0 if this is equal to other.)
 * 
 * 14. Write and test a method public void filter(ArrayList<Object> list1, ArrayList<Object> list2) that removes from list1 all objects that are also in list2. 
 *     Your method should compare the objects using the == operator, not equals. (Hint: the contains and indexOf methods cannot be used.)
 * 
 * 15. Write and test a method public void removeDuplicates(ArrayList<String> words) that removes duplicate words (that is, for which word1.equals(word2)) from the list. 
 *     (Hint: start with the last element and use the indexOf and remove methods.)
 */


public class LitvinBook {
	public static List<String> list = new ArrayList<>();
	public static List<Integer> intlist = new ArrayList<>();

	// 12
	public static List<String> reverseOrder(List<String> list) {
		ArrayList<String> newlist = new ArrayList<>();
		
		for(int i = list.size() - 1; i >= 0; i--) {
			newlist.add(list.get(i));
		}
		
		return newlist;
	}
	
	// 13
	public static void removeSmallest(List<Integer> list) {
		
		// the index of the minimum value
		int small = 0;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) < list.get(small)) {
				small = i;
			}
		}
		
		list.remove(small);
	}
	
	// 14
	public static void filter(List<?> b, List<?> a) {
		Iterator<?> aIterator = a.iterator();
		Iterator<?> bIterator = b.iterator();

		while (aIterator.hasNext())
		{
			Object aObj = aIterator.next();

			while (bIterator.hasNext())
			{
				Object bObj = bIterator.next();
				if (aObj == bObj) bIterator.remove();
			}

			bIterator = b.iterator();
		}
	}
	
	// 15
	public static void removeDuplicates(List<String> a) {
		for(int i = a.size() - 1; i >= 0; i--) {
			if(a.indexOf(a.get(i)) != i) {
				a.remove(a.indexOf(a.get(i)));
			}
		}
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		
		String teststring = "REMOVE ME";
		
		// tyler did this
		list.add(teststring);
		list.add(teststring);
		list.add("apple");
		list.add(teststring);
		list.add("blueberry");
		list.add(teststring);
		list.add("cantaloupe");
		list.add(teststring);
		list.add("banana");
		list.add(teststring);
		list.add("grape");
		list.add(teststring);
		list.add(teststring);
		list.add(teststring);
		list.add("kiwi");
		list.add(teststring);
		list.add(teststring);
		list.add(teststring);
		list.add("melon");
		list.add(teststring);
		list.add(teststring);

		List<String> testlist = new ArrayList<>();
		testlist.add(teststring);
		testlist.add("apple");
		testlist.add("Mr. Miller");
		
		
		for(int i = 0; i < 10; i++) {
			intlist.add(rand.nextInt(100));
		}

		
		// #12
		List<String> rlist = reverseOrder(list);
		System.out.println("Reverse Order: " + rlist);
		System.out.println("===");
		
		// #13
		System.out.println("Original: " + intlist);
		removeSmallest(intlist);
		System.out.println("Removed Smallest: " + intlist);
		System.out.println("===");
		
		// #14
		System.out.println(list);
		System.out.println(testlist);
		filter(list, testlist);
		System.out.println(list);
		System.out.println(testlist);
		
		System.out.println("===");
		
		// #15
		
		// add some duplicate strings
		list.add("kiwi");
		list.add("grape");
		
		// let's get rid of them
		System.out.println(list);
		removeDuplicates(list);
		System.out.println(list);
	}
	
}

