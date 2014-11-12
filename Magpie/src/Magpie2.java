/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	public String getParting() {
		return "See ya.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		if (statement.trim().length() <= 0) {
			return "Were you trying to say something?";
		}
		
		else if (statement.contains("Mr. Miller")) {
			return "He sounds like the best teacher in the universe.";
		}
		
		else if (statement.indexOf("no") >= 0 || statement.contains("hate"))
		{
			return "Why so negative?";
		}
		
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			return "Tell me more about your family.";
		}
		
		else if (statement.contains("dog") || statement.contains("cat")) {
			return "Tell me more about your pets.";
		}
		
		else if (statement.contains("tree")) {
			return "What's your favorite kind of tree?";
		}
		
		else if (statement.contains("hello")) {
			return "Hello! What do you want to talk about?";
		}
		
		else if (statement.contains("playground") || statement.contains("play")) {
			return "I love playgrounds!";
		}
		
		return getRandomResponse();
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		
		else if (whichResponse == 4) {
			response = "Intriguing... what do you mean?";
		}
		
		else if (whichResponse == 5) {
			response = "I like the way you think.";
		}

		return response;
	}
}
