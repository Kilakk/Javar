

/**
 * @author bednarzt
 *
 */
public class Vowels {

	public static int countVowels(String str) {
		str = str.toLowerCase();
		
		int vowelcount = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(isVowel(str.charAt(i))) {
				vowelcount++;
			}
		}
		
		return vowelcount;
	}
	
	public static boolean isVowel(char c) {
		// lowercase only
		// aeiou and y
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y');
	}
	
}
