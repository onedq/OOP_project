package Quiz;

import java.util.ArrayList;

public class question {
	
	private int id;
	private String title;
	private ArrayList<String> answers;
	private String correctAnswer;
	
	public question(int id, String title, ArrayList<String> answers, String correctAnswer) {
		this.id = id;
		this.title = title;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
	}

	public int getId() {
		return id;
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public String getTitle() {
		return title;
	}
	
	
}
