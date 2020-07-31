package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DateBaseManager {
	private Connection con;
	public DateBaseManager() throws ClassNotFoundException, SQLException {
		// Build Path -> add extrenal archives -> "mysql-connector-java-8.0.16.jar"
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection("jdbc:mysql://"
			+ DBinfo.MYSQL_DATABASE_SERVER, DBinfo.MYSQL_USERNAME, DBinfo.MYSQL_PASSWORD);

		Statement stmt = con.createStatement();
		stmt.executeQuery("USE " + DBinfo.MYSQL_DATABASE_NAME);
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public void closeConnection() throws SQLException {
		con.close();
	}
}
