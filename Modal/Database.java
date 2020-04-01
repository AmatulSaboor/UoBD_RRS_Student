package Modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * It's a class that has two methods to get connection and close connection with
 * data base
 * 
 * @author Amatul Saboor
 * @version 01-04-2020
 */

public class Database {

	private static Connection conn;
	private final static String url = "jdbc:sqlite:C:/Users/Nabeelah Siddiqua/OneDrive - University of Birmingham/UoBD/Spring Term/Project SW/RRS_Student/db/RRS_Student.db";

	// get connection method
	public static Connection getConnection() throws SQLException {
		conn = DriverManager.getConnection(url);
		return conn;
	}

	// close connection method
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}
}
