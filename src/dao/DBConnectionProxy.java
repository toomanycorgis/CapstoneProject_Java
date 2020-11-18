package dao;

import java.sql.Connection;

public class DBConnectionProxy {
	
	public static Connection getConnectionToDatabase() {
	
		return DBConnection.getConnectionToDatabase();
	}

}
