package dao;

import java.sql.Connection;

//proxy class for our DB connection
public class DBConnectionProxy {
	
	public static Connection getConnectionToDatabase() {
	
		return DBConnection.getConnectionToDatabase();
	}

}
