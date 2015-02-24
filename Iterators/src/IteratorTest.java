import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


public class IteratorTest {
	
	public static List<Integer> list = new ArrayList<Integer>();
	
	public static void emptyThenFill(List<Integer> l, int size) {
		l.clear();
		
		for(int i = 0; i < size; i++) {
			l.add(0);
		}
	}
	
	public static void emptyThenFillRandom(List<Integer> l, int size) {
		Random rand = new Random();
		l.clear();
		
		for(int i = 0; i < size; i++) {
			l.add(rand.nextInt(10));
		}
	}
	
	public static void removeDuplicates(List<Integer> list) {
		List<Integer> found = new ArrayList<Integer>();
		ListIterator<Integer> itr = list.listIterator();
		
		while(itr.hasNext()) {
			int i = itr.next();
			
			if(found.indexOf(i) > -1) itr.remove();
			else found.add(i);
		}
	}
	
	public static String stringList(List<Integer> l) {
		String ret = "{";
		
		for(int i = 0; i < l.size(); i++) {
			if(i == l.size() - 1) {
				ret += l.get(i) + "}";
				break;
			}
			
			ret += l.get(i) + ", ";
		}
		
		return ret;
	}
	
	public static long timeFor(List<Integer> l) {
		long start = System.nanoTime();
		
		for(int i = 0; i < l.size(); i++) {
			// do nothing
		}
		
		return (System.nanoTime() - start);
	}
	
	public static long timeForEach(List<Integer> l) {
		long start = System.nanoTime();
		
		for(@SuppressWarnings("unused") int i : l) { 
			// do nothing
		}
		
		return (System.nanoTime() - start);
	}

	public static long timeOther(List<Integer> l) {
		long start = System.nanoTime();
		
		l.forEach((v) -> {});
		
		return (System.nanoTime() - start);
	}
	
	public static long timeIterator(List<Integer> l) {
		Iterator<Integer> itr = l.iterator();
		long start = System.nanoTime();
		
		while(itr.hasNext()) {
			itr.next();
		}
		
		return (System.nanoTime() - start);
	}
	
	public static long timeListIterator(List<Integer> l) {
		ListIterator<Integer> itr = l.listIterator();
		long start = System.nanoTime();
		
		while(itr.hasNext()) {
			itr.next();
		}
		
		return (System.nanoTime() - start);
	}
	
	public static void main(String[] args) {
		emptyThenFill(list, 1000);
		System.out.println("timeFor: " + timeFor(list));
		System.out.println("timeForEach: " + timeForEach(list));
		System.out.println("timeOther: " + timeOther(list));
		System.out.println("timeIterator: " + timeIterator(list));
		System.out.println("timeListIterator: " + timeListIterator(list));
		
		emptyThenFillRandom(list, 100);
		System.out.println(stringList(list));
		removeDuplicates(list);
		System.out.println(stringList(list));
	}

}
