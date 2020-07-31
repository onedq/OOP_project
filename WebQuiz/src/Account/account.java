package Account;

public class account {
	
	private int userID;
	private String username;
	private String name;
	private String last;
	private String mail;
	
	public account(int userID, String username, String name, String last, String mail) {
		this.userID = userID;
		this.username = username;
		this.name = name;
		this.last = last;
		this.mail = mail;
	}

	public int getUserID() {
		return userID;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getLast() {
		return last;
	}
	
	public String getMail() {
		return mail;
	}
	
}
