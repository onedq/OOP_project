package Quiz;

import java.util.ArrayList;

public class quiz {
	
	private int id;
	private String title;
	private String author;
	private ArrayList<question> questions;
	
	public quiz(int id, String title, String author, ArrayList<question> questions) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.questions = questions;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<question> getQuestions() {
		return questions;
	}

	public String getAuthor() {
		return author;
	}
	
	
}
