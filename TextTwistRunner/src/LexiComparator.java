import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class LexiComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		String a = o1.toString();
		String b = o2.toString();
		
		return a.compareToIgnoreCase(b);
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("apple");
		list.add("base");
		list.add("microwave");
		list.add("Microwave");
		list.add("baseball");
		list.add("HotDog");
		
		Collections.sort(list, new LexiComparator());
		
		for(String s : list) {
			System.out.println(s);
		}
	}
}
