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
 * Servlet implementation class Login_Servlet
 */
@WebServlet("/Login/Login_Servlet")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Servlet() {
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
		
		DataBase.DateBaseManager d = (DataBase.DateBaseManager)cont.getAttribute("baseManager");
	    
		Connection con = d.getConnection();
		
		int login = acc.checkPassword(username, password, con);
		
		if(login==0) {
			// success
			request.getSession().setAttribute("username", username);
			RequestDispatcher dispatch = request.getRequestDispatcher("/index.jsp");
			dispatch.forward(request, response);
		} else {
			// failure
			
		}
		
	}

}
