package Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DataBase.DBinfo;

public class accountDao {
	
	/**
	 * @return
	 * 0 - if done without any problem,
	 * 1 - if username is in use, 
	 * 2 - if mail is in use, 
	 * 3 - if username and mail both in use,
	 * 4 - if username or mail field is empty,
	 * -1 - if sql Error
	 */
	public int addNewAccount(String firstname, String lastname, String username, String password, String mail,Connection con) {
		
		try {
			Statement stm = con.createStatement();
			stm.executeQuery("USE "+DBinfo.MYSQL_DATABASE_NAME);
			String insert = "INSERT INTO accounts (account_first_name, account_last_name, account_username, account_mail, account_password) VALUES (";
			if(firstname == "") {insert += "null, ";} else {insert += "\"" + firstname + "\", ";}
			if(lastname == "")  {insert += "null, ";} else {insert += "\"" + lastname + "\", ";}
			insert += "\"" + username + "\", ";
			insert += "\"" + mail + "\", ";
			insert += "\"" + password + "\");";
						
			stm.executeUpdate(insert);
			stm.close();
			
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}	
	}
	
	
	/**
	 * @return 
	 * 0 - if username and mail both not in use,
	 * 1 - if username is in use, 
	 * 2 - if mail is in use, 
	 * 3 - if username and mail both in use,
	 * -1 - for sql Error 
	 */
	public int containsAccount(String username, String mail, Connection con) {
		int result = 0;
		try{  
			Statement stm = con.createStatement();
			stm.executeQuery("USE " + DBinfo.MYSQL_DATABASE_NAME);
			
			String selectUsername = "Select * from accounts ";
			selectUsername += "where account_username = \"" + username + "\";";
						
			ResultSet rs = stm.executeQuery(selectUsername);
						
			if(rs.next()) {
				result = 1;
			}
			
			String selectMail = "Select * from accounts ";
			selectMail += "where account_mail = \"" + mail + "\";";
			
			rs = stm.executeQuery(selectMail);
			if(rs.next()) {
				if(result==1) {
					result = 3;
				} else result = 2;
			}
			
			stm.close();

		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
		return result;
	}
	
	
	/**
	 * @return 
	 * 0 - successfully matched username and password,
	 * 1 - if username not in use,
	 * 2 - if password is incorrect,
	 * -1 - for sql Error 
	 */
	public int checkPassword(String username, String password, Connection con) {
		int result = 0;
		try{  
			Statement stm = con.createStatement();
			stm.executeQuery("USE " + DBinfo.MYSQL_DATABASE_NAME);
			
			String selectUsername = "Select * from accounts ";
			selectUsername += "where account_username = \"" + username + "\";";
						
			ResultSet rs = stm.executeQuery(selectUsername);
						
			if(rs.next()) {
				if(rs.getString("account_password").equals(password)) {
					result = 0;
				}else {
					result = 2;
				}
			}else {
				result = 1;
			}
			
			if(rs.next()) {
				result = -1;
			}
			
			stm.close();

		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
		
		return result;
	}
	
	
	/**
	 * @return 
	 * Account - found account with this username
	 * null - for sql Error 
	 */
	public account getAccount(String username, Connection con) {
		account result = null;
		
		String mail, userName, firstName, lastName;
		int userID;
		
		try{  
			Statement stm = con.createStatement();
			stm.executeQuery("USE " + DBinfo.MYSQL_DATABASE_NAME);
			
			String selectUsername = "Select * from accounts ";
			selectUsername += "where account_username = \"" + username + "\";";
						
			ResultSet rs = stm.executeQuery(selectUsername);
			
			if(rs.next()) {
				
				userID = rs.getInt("account_id");
				mail = rs.getString("account_mail");
				userName = rs.getString("account_username");
				firstName = rs.getString("account_first_name");
				lastName = rs.getString("account_last_name");
								
			}else {
				stm.close();
				return null;
			}
			
			if(rs.next()) {
				stm.close();
				return null;
			}
			
			result = new account(userID, userName, firstName, lastName, mail);

			stm.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}
	
}
