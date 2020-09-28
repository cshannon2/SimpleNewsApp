 /**
* This class constructs a ConnectionStatus object. 
* This class also serves as a representation of ConnectionStatus which gson will use to parse JSON from an API Call to a ConnectionStatus object 
*/
public class ConnectionStatus {
	
	private String status;
	private int totalResults;

	public ConnectionStatus(String status, String totalResults) {
		this.status = status;
		this.totalResults = Integer.parseInt(totalResults);
	}

	public String getStatus() {
		return this.status;
	}

	public int getTotalResults() {
		return this.totalResults;
	}
	
}
