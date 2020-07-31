package Login;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Account.accountDao;

/**
 * Servlet implementation class Reg_Servlet
 */
@WebServlet("/Login/Reg_Servlet")
public class Reg_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg_Servlet() {
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
		
		ServletContext cont = getServletContext();
		Object obj = cont.getAttribute("manager");
		accountDao acc = (accountDao)obj;
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String mail = request.getParameter("mail");
		
		DataBase.DateBaseManager d = (DataBase.DateBaseManager)cont.getAttribute("baseManager");
	    
		Connection con = d.getConnection();
		
		int accountIsTaken = acc.containsAccount(username, mail, con);
		boolean error = false;
		
		if(accountIsTaken==0) {
			// success
			
			if(password.length() < 4 || mail.length() < 4) {
				error = true;
			} else {
				acc.addNewAccount(first_name, last_name, username, password, mail, con);
				request.getSession().setAttribute("username", username);
				RequestDispatcher dispatch = request.getRequestDispatcher("/index.jsp");
				dispatch.forward(request, response);
			}
		}else {
			error = true;
		}
		
		if(error){
			// mail or username is taken
			// pass < 4 or mail <4
			RequestDispatcher dispatch = request.getRequestDispatcher("/error.jsp");
			dispatch.forward(request, response);
		}
	}

}
