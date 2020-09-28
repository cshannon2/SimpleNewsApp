/**
* This class constructs an Article object. 
* This class also serves as a representation of Article which gson will use to parse JSON from an API Call to an Article object 
*/
public class Article {

	private String author;
	private String title;
	private String description;
	private String url;
	private String urlToImage;
	private String publishedAt;
	private String content;
	
	public Article(String author, String title, String description, String url, String urlToImage, String publishedAt, String content) {
		this.author = author;
		this.title = title;
		this.description = description;
		this.url = url;
		this.urlToImage = urlToImage;
		this.publishedAt = publishedAt;
		this.content = content;
	}

	public String getTitle() {
		return this.title;
	}

	public String getContent() {
		return this.content;
	}
}