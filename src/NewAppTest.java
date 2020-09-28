import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;

import org.junit.jupiter.api.Test;

class NewAppTest {

	@Test
	void test() {
		
		// API Keys are typically sensitive information and should not be shared publicly 
		// If you would like to manually build this application you will need to provide your own API Key
		// Simply change the value of apiKey to be "your api key" and then you should be able to build the application successfully 
		StringBuilder apiKey = new StringBuilder("&apiKey=");
		apiKey.append("Put Your API Key HERE, between the quotation marks");
	
		// Call the GUI constructor
		Gui gui = new Gui(new StringBuilder("http://newsapi.org/V2/"), new StringBuilder("?country="), "top-headlines", apiKey.toString());
		
		// Create an ActionEvent that is initialized to the values of the submit button
		ActionEvent event = new ActionEvent(this, 1001, "Submit");
		
		// Call the actionPerformed simulating the "Submit" button click
		gui.actionPerformed(event);
		
		// Get the tempNewsFeed value
		String testNewsFeedText = gui.getNewsFeedText();
		
		// Verify that the testNewsFeedText is equal to an empty String. This is because the test simulating the user clicking submit without entering a country abbreviation
		// as a result the program sets the newsFeed to an empty String. 
		assertEquals(testNewsFeedText,"");
		
	}

}
