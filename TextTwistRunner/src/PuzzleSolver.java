import java.util.ArrayList;
import java.util.List;


public class PuzzleSolver {
	
	private Dictionary dictionary;
	
	private List<String> combinations;
	
	public PuzzleSolver() {
		dictionary = new Dictionary();
		combinations = new ArrayList<String>();
	}
	
	public String toString() {
		return "PuzzleSolver: using " + dictionary;
	}
	
	
	public List<String> solve(String input) {
		List<String> results = new ArrayList<String>();
		
		combinations.clear();
		
		for(int i = 0; i <= 3; i++) {
			findCombs(input, "", i);
		}
		
		List<String> toAdd = new ArrayList<String>();
		for(int i = 0; i < combinations.size(); i++) {
			
			toAdd = dictionary.getValuesFromString(combinations.get(i));
			
			if(toAdd != null) {
				
				for(int j = 0; j < toAdd.size(); j++) {
					if(!results.contains(toAdd.get(j)))
					{
						results.add(toAdd.get(j));
					}
				}
			}
		}
		
		return results;
	}
	
	private void findCombs(String input, String prefix, int stop) {
		int n = input.length();
		if(n == stop) {
			combinations.add(prefix);
		}
		
		else {
			for(int i = 0; i < n; i++) {
				findCombs(input.substring(0, i) + input.substring(i + 1, n), prefix + input.charAt(i), stop);
			}
		}
	}
	
}
