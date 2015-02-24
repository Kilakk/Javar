import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Translator {

	private Map<String, String> translations;
	Iterator<String> itr;
	
	private String language;
	
	/**
	 * Create a new Translator with the specified language
	 * @param language the language that words are being translated into
	 */
	public Translator(String language) {
		this.translations = new HashMap<String, String>();
		this.language = language;
	}
	
	/**
	 * Creates a new Translator for the German language
	 */
	public Translator() {
		this("German");
	}
	
	/**
	 * @return a String representation of the Translator
	 */
	@Override
	public String toString() {
		itr = translations.keySet().iterator();
		
		String ret = "Translator (" + language + "): { ";
		
		String key;
		while(itr.hasNext()) {
			key = itr.next();
			ret += "[" + key + ", " + translations.get(key) + "] ";
		}
		
		ret += "}";
		return ret;
	}
	
	/**
	 * Adds a word into the translations map
	 * @param word the English word to add as a key
	 * @param translation the translated word to add as the value
	 */
	public void addWord(String word, String translation) {
		if( ! translations.containsKey(word)) {
			translations.put(word, translation);
		}
	}
	
	/**
	 * Gets map key based off of the translated value given.
	 * @param translation the translated word to lookup the English key with
	 * @return the English key of the translated word
	 */
	public String getWord(String translation) {
		itr = translations.keySet().iterator();
		
		String testkey;
		while(itr.hasNext()) {
			testkey = itr.next();
			
			if(getTranslation(testkey) == translation) return testkey;
		}
		
		return "";
	}
	
	/**
	 * Gets the specified key translated into this Translator's language
	 * @param key the English key to lookup the translation for
	 * @return the translation
	 */
	public String getTranslation(String key) {
		return translations.get(key);
	}
	
	public static void main(String[] args) {
		Translator trans = new Translator();
		trans.addWord("Hello", "Guten Tag");
		trans.addWord("Apple", "Apfel");
		trans.addWord("Wall", "Mauer");
		trans.addWord("City", "Stadt");
		trans.addWord("Train Station","Bahnhof");
		trans.addWord("Forest", "Wald");
		
		System.out.println(trans.getWord("Bahnhof"));
		System.out.println(trans.getTranslation("Hello"));
		System.out.println(trans);
	}
}
