package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String dbUser = "root";
	private static final String dbPassword = "password";

	public static Connection getConnectionToDatabase() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone", dbUser, dbPassword);
			System.out.println("MySQL JDBC Driver Registered!");

		}

		catch (SQLException e) {
			System.out.println("Connection Failed!  Check output console");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found, go figure that out I guess");
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("Connection made to DB!");
		}
		return connection;
	}

	public static void main(String[] args) {
		getConnectionToDatabase();
	}
}
