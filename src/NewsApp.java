
public class NewsApp {

	public static void main(String[] args) {
		
		// API Keys are typically sensitive information and should not be shared publicly 
		// If you would like to manually build this application you will need to provide your own API Key
		// Simply change the value of apiKey to be "your api key" and then you should be able to build the application successfully 
		StringBuilder apiKey = new StringBuilder("&apiKey=");
		apiKey.append("Put Your API Key HERE, between the quotation marks");
	
		// Call the GUI constructor
		Gui gui = new Gui(new StringBuilder("http://newsapi.org/V2/"), new StringBuilder("?country="), "top-headlines", apiKey.toString());
		
	}
}


