import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;

public class ArticleList {
	
	String json;
	ArrayList<Article> articleList;
	ConnectionStatus connection;
	
	
	/**
	 * This function constructs an ArticleList object. 
	 *
	 * @param requestedURL, is a String representation of the URL that will be used to perform the API call. 
	 *
	 * @return nothing is returned, the ArticleList is constructed.  
	 */
	ArticleList(String requestedURL){
	
		this.articleList = new ArrayList<Article>();
		
		try {
			setJSON(new URL(requestedURL));
			
			setConnection(json);
			
			// Runs if the API call returns a result / if the API call is successful
			if(connection.getTotalResults() != 0) {
				ArrayList<String> newsArticlesStrings = splitJSON(json);
				setArticleList(newsArticlesStrings);
			}
		} 
		catch (MalformedURLException exception) {
			exception.printStackTrace();
		}
	}
	
	
	/**
	 * This function takes in a URL, attempts to open the URL stream, if the URL stream is opened then the function will gather all of the JSON from the URL stream. 
	 *
	 * @param url, is a URL representation of the URL that will be used to perform the API call. 
	 *
	 * @return nothing is returned, the json variable is set.  
	 */
	private void setJSON(URL url){
		
		int read;
	    char[] chars = new char[1024];
		BufferedReader urlReader = null;
		StringBuffer urlBuffer = new StringBuffer();
		
		
		try {
			urlReader = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while ((read = urlReader.read(chars)) != -1) {
	            urlBuffer.append(chars, 0, read); 
	        }
		} 
		catch (IOException exception) {
			exception.printStackTrace();
		}
	
		this.json = urlBuffer.toString();
	}
	
	/**
	 * This function takes the json variable and splits it into separate Strings that will be parsed the Article objects.
	 *
	 * @param json, is a String representation of the json that was received when the program performed the API call. 
	 *
	 * @return an ArrayList of type String is returned, each element in the ArrayList contains the details for the articles that were received from the API call.
	 */
	private ArrayList<String> splitJSON(String json) {
		
		ArrayList<String> newsArticlesStrings = new ArrayList<String>();
		
		String[] splitJSON = json.split("},");
		
		for(int counter = 1; counter < 20; counter = counter+2) {
			String temp = "{" + splitJSON[counter] + "}";
			newsArticlesStrings.add(temp);
		}
		
		return newsArticlesStrings;
		
	}
	
	/**
	 * This function takes in the newsArticlesString variable. The function uses gson to parse all elements in the ArrayList. Gson uses the
	 * the data to create Article objects for each element in the ArrayList. Each Article object is then added to an ArrayList of type Article.
	 *
	 * @param newsArticlesStrings, is an ArrayList of type String that represents the information about the articles in json format. 
	 *
	 * @return nothing is returned, the articleList varibale is set.  
	 */
	private void setArticleList(ArrayList<String> newsArticlesStrings) {
	
		for(int counter = 0; counter < newsArticlesStrings.size(); counter++) {
			Gson gson = new Gson();
			
			// Use gson to parse the newsArticleList using the Article class as a template to parse Article Objects.
			Article article = gson.fromJson(newsArticlesStrings.get(counter), Article.class);
			this.articleList.add(article);
		}
	}
	
	/**
	 * This function takes in the json variable. The function uses gson to parse  the json. Gson uses the
	 * the data to create a ConnectionStatus object. The connectionStatus object is used to verify results were received from the API call. 
	 *
	 * @param requestedURL, is a String representation of the URL that will be used to perform the API call. 
	 *
	 * @return nothing is returned, the connection variable is set.  
	 */
	private void setConnection(String json) {
		Gson gson = new Gson();
		// Use gson to parse the connection using the ConnectionStatus class as a template to parse the ConnectionStatus Object.
		this.connection =  gson.fromJson(json, ConnectionStatus.class);
	}
	
	/**
	 * This function returns the articleList that is created using the API call, and other functions that parsed the data.   
	 *
	 * @param no parameters.
	 *
	 * @return the articleList is returned. the ArticleList is represented as an ArrayList of type Article.
	 */
	public ArrayList<Article> getArticleList(){
		return this.articleList;
	}
	
}
