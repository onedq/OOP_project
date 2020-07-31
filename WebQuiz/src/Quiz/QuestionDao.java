package Quiz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import DataBase.DBinfo;

public class QuestionDao {
	
	public ArrayList<question> getAllQuestion(Connection con) {
		ArrayList<question> result = new ArrayList<question>();
		
		try {
			Statement stm = con.createStatement();
			stm.executeQuery("USE "+DBinfo.MYSQL_DATABASE_NAME);
			ResultSet rs = stm.executeQuery("SELECT * FROM questions");
			while(rs.next()) {
				int id = rs.getInt("question_id");
				String title = rs.getString("question_title");
				String ans = rs.getString("question_answer");
				
				question q = new question(id, title, ans);
				result.add(q);
			}	
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<question>();
		}	
		
		return result;
	}

}