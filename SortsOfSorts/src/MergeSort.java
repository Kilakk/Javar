import java.util.ArrayList;
import java.util.List;


public class MergeSort {
	
	public static List<Integer> sort(List<Integer> array) {
		
		if(array.size() <= 1) {
			return array;
		}
		
		else {
			// {1, 2, 3, 4, 5, 6, 7}
			
			// middle = index 3, which is the value 4
			int middle = (array.size() / 2);
			
			// {1, 2, 3, 4}
			List<Integer> lower = new ArrayList<Integer>();
			for(int i = 0; i < middle; i++) {
				lower.add(array.get(i));
			}
			
			// System.out.println(SortTester.listToString("lower", lower) + ", len: " + lower.size());
			
			// {5, 6, 7}
			List<Integer> upper = new ArrayList<Integer>();
			for(int i = middle; i < array.size(); i++) {
				upper.add(array.get(i));
			}
			
			// System.out.println(SortTester.listToString("upper", upper) + ", len: " + upper.size());
			
			
			lower = sort(lower);
			
			upper = sort(upper);
			
			return merge(lower, upper);
		}
	}
	
	private static List<Integer> merge(List<Integer> a, List<Integer> b) {
		List<Integer> result = new ArrayList<Integer>();
		
		while(!a.isEmpty() && !b.isEmpty()) {
			if(a.get(0) <= b.get(0)) {
				result.add(a.remove(0));
			}
			
			else {
				result.add(b.remove(0));
			}
		}
		
		while(!a.isEmpty()) {
			result.add(a.remove(0));
		}
		
		while(!b.isEmpty()) {
			result.add(b.remove(0));
		}
		
		return result;
	}

}
