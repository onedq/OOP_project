package Quiz;

import java.util.ArrayList;

public class question {
	
	private int id;
	private String title;

	private String correctAnswer;
	
	public question(int id, String title, String correctAnswer) {
		this.id = id;
		this.title = title;
		this.correctAnswer = correctAnswer;
	}

	public int getId() {
		return id;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public String getTitle() {
		return title;
	}
	
	
}
