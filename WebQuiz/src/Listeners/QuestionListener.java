package Listeners;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import DataBase.DateBaseManager;
import Quiz.QuestionDao;

/**
 * Application Lifecycle Listener implementation class QuestionListener
 *
 */
@WebListener
public class QuestionListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public QuestionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	ServletContext cont = sce.getServletContext();
    	
    	try {
			DateBaseManager baseManager = new DateBaseManager();
			cont.setAttribute("baseManager", baseManager);
		} catch (ClassNotFoundException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	QuestionDao q = new QuestionDao();
    	cont.setAttribute("Question", q);
    }
	
}
