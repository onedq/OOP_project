package Quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class QuizServlet
 */
@WebServlet("/Quiz/QuizServlet")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		int countScore = 0;
		ArrayList<question> arr = (ArrayList<question>)request.getSession().getAttribute("currQuiz");
		
		for(int i=0; i<arr.size(); i++) {
			String ansIdx = "answer" + i;
			String currAnswer = request.getParameter(ansIdx);
			
			if(currAnswer.equals(arr.get(i).getCorrectAnswer())) {
				countScore++;
			}
		}
		
		double countPercent = countScore/arr.size() * 100;
		String result = countScore + " out of " + arr.size();
		
		request.getSession().setAttribute("currScore", result);
		RequestDispatcher dispatch = request.getRequestDispatcher("/showScore.jsp");
		dispatch.forward(request, response);
		
	}

}
