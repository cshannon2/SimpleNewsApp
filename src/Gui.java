import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gui extends JFrame implements ActionListener {
	
	 JTextField userCountrySelection = new JTextField(2);
	 JTextArea newsFeed = new JTextArea();
	 StringBuilder tempNewsFeed;
	 
	 StringBuilder baseURL;
	 StringBuilder country;
	 String category;
	 String apiKey;
	 
	 /**
	 * This function constructs the Gui interface. 
	 *
	 * @param baseURL, is a StringBuilder that represents the base URL we will use to create an API call. 
	 * @param country, is a StringBuilder that represents the base arguments for a country that can be appended with the user's selected country. 
	 * @param category, is a String that represents the category the news application will provide.
	 * @param apiKey, is the apiKey needed to make the API call.  
	 *
	 * @return nothing is returned, the Gui is constructed.  
	 */
	Gui(StringBuilder baseURL, StringBuilder country, String category, String apiKey){
		
		this.baseURL = baseURL;
		this.country = country;
		this.category = category;
		this.apiKey = apiKey;
	
		JFrame frame = new JFrame("Simple NewsAPP");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(450, 450);
	    
	    newsFeed.setLineWrap(true);
        newsFeed.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(newsFeed);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter Country Abbreviation");
       
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
     
        panel.add(label); 
        panel.add(userCountrySelection);
        panel.add(submitButton);
        
        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.setVisible(true);
  		
	}
	
	/**
	 * This function performs an action based off of the event that was triggered in the Gui interface . 
	 *
	 * @param event, is an ActionEvent variable that contains information about which Gui object was interacted with. 
	 *
	 * @return nothing is returned, the appropriate actions are performed based off of the param event.  
	 */
	@Override
	public void actionPerformed(ActionEvent event) {

		
		// Runs if the event triggered corresponds to the Submit button
        if (event.getActionCommand().equals("Submit")) {
        		
        	// Runs if the user has entered text in the userCountrySelection box 
        	if(userCountrySelection.getText().compareTo("") != 0) {
        	
        		// Creates a copy of the variables to allow for appending for the current query only 
        		StringBuilder tempBaseURL = new StringBuilder(this.baseURL.toString());
        		StringBuilder tempCountry = new StringBuilder(this.country.toString());
        		
        		// StringBuilder object that will hold the text for the newsFeed
        		 this.tempNewsFeed = new StringBuilder("");
        	
        		// Build the URL for the API call 
        		tempCountry.append(userCountrySelection.getText());
        		tempBaseURL.append(category);
        		tempBaseURL.append(tempCountry.toString());
        		tempBaseURL.append(apiKey);
    		
        		// Create a new ArticleList by passing the URL into the constructor
        		ArticleList articleList = new ArticleList(tempBaseURL.toString());
        		
        		// Get the ArrayList of Articles 
        		ArrayList<Article> listOfArticlesToDisplay = articleList.getArticleList();
        	
        	
        		// Runs if the listOfArticlesToDisplay has Articles
        		if(listOfArticlesToDisplay.size() != 0) {
        	
        			// Build the newsFeed text
        			for(int counter = 0; counter < 10; counter++) {
        				tempNewsFeed.append("*********************************\n");
        				tempNewsFeed.append("Title: ");
        				tempNewsFeed.append(listOfArticlesToDisplay.get(counter).getTitle());
        				tempNewsFeed.append("\n\n");
        				tempNewsFeed.append("Content: ");
        				tempNewsFeed.append(listOfArticlesToDisplay.get(counter).getContent());
        				tempNewsFeed.append("\n\n\n");;
        			}
        			
        			// Set the newsFeed text
        			newsFeed.setText(tempNewsFeed.toString());
        			
        		}
        		// Runs if the ArticleList is empty 
        		else {
        			newsFeed.setText("");
        			
        			// Prompt the user that there weren't any articles found with the abbreviation provided. 
        			JOptionPane.showMessageDialog(null, "There were no news articles found with the abbreviation provided.");
        		}		
        	}
        	// Runs if the user has not entered anything into the userCountrySelection box 
        	else {
        		
        		// StringBuilder object that will hold the text for the newsFeed
        		this.tempNewsFeed = new StringBuilder("");
        		
        		// Prompts the user to enter a country abbreviation into the userCountrySelection box 
    			JOptionPane.showMessageDialog(null, "Please enter an abbreviation for the country you would like to get get news for.");
        	}
        }
	}
	
	public String getNewsFeedText() {
		return this.tempNewsFeed.toString();
	}
	
}
