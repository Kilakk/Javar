import java.util.ArrayList;
import java.util.List;

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

	public static List<String> reverseOrder(List<String> list) {
		ArrayList<String> newlist = new ArrayList<>();
		
		for(int i = list.size() - 1; i >= 0; i--) {
			newlist.add(list.get(i));
		}
		
		return newlist;
	}
	
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
	
	public static void filter(ArrayList<Object> a, ArrayList<Object> b) {
		
	}
	
	public static void main(String[] args) {
		list.add("apple");
		list.add("blueberry");
		list.add("cantaloupe");
		list.add("banana");
		list.add("grape");
		list.add("kiwi");
		list.add("melon");

		List<String> rlist = reverseOrder(list);
		
		System.out.println(rlist);
	}
	
}

