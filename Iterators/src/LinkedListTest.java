import java.util.LinkedList;


public class LinkedListTest {

	public static LinkedList<Integer> list = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		IteratorTest.emptyThenFill(list, 100);
		
		System.out.println("timeFor: " + IteratorTest.timeFor(list));
		System.out.println("timeForEach: " + IteratorTest.timeForEach(list));
		System.out.println("timeOther: " + IteratorTest.timeOther(list));
		System.out.println("timeIterator: " + IteratorTest.timeIterator(list));
		System.out.println("timeListIterator: " + IteratorTest.timeListIterator(list));
	}
}
