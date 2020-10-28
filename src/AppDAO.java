
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AppDAO {

	private Connection connection;
	private PreparedStatement insertNewUser;
	private PreparedStatement getUser;
//	private PreparedStatement updateUser;

//	`username` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
//  `password` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `firstName` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `lastName` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `email` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
//  `verificationCode` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `isVerified` bool DEFAULT false,
//  `userType` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `classroomID
	
	public AppDAO() {
		try {
			connection = DBConnection.getConnectionToDatabase();
			insertNewUser = connection.prepareStatement(
					"INSERT INTO users" 
					+ "(userName, password, firstName, lastName, email, verificationCode, isVerified, userType)" 
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			getUser = connection.prepareStatement("SELECT * FROM user" + " WHERE userName LIKE ?");
//			updateUser = connection.prepareStatement("UPDATE users " 
//					+ "SET password=?, firstName=?, lastName=?, email=?, verificationCode=?, isVerified=?, userType=?" 
//					+ "WHERE userName=?");
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	} // end constructor

	public Connection getConnection() {
		return connection;
	}

	public int insertNewUser(User u) {
		try {
			insertNewUser.setString(1, u.getUserName());
			insertNewUser.setString(2, u.getPassword());
			insertNewUser.setString(3, u.getFirstName());
			insertNewUser.setString(4, u.getLastName());
			insertNewUser.setString(5, u.getEmail());
			insertNewUser.setString(6, u.getVerificationCode());
			insertNewUser.setBoolean(7, (u.isVerified()));
			insertNewUser.setString(8, u.getRole());
			return insertNewUser.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int getUser(String userName) {
		try {
			getUser.setString(1, userName);
			return getUser.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

//	public int updateUser(String userName, String password, String firstName, String lastName,
//			String email, String verificationCode, String isVerified, String userType) {
//		try {
//			updateUser.setString(1, password);
//			updateUser.setString(2, firstName);
//			updateUser.setString(3, lastName);
//			updateUser.setString(4, email);
//			updateUser.setString(5, verificationCode);
//			updateUser.setString(6, isVerified);
//			updateUser.setString(7, userType);
//			updateUser.setString(8, userName);
//			return updateUser.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return 0;
//		}
//	}

	public ArrayList<User> showAllClassUsers() throws SQLException {
		ArrayList<User> dbUsers = new ArrayList<>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE classroomID LIKE 1");

		while (resultSet.next()) {		
			String userName = resultSet.getString("userName");
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			String email = resultSet.getString("email");
			String password = resultSet.getString("password");
			String verificationCode = resultSet.getString("verificationCode");
			boolean isVerified = resultSet.getBoolean("isVerified");
			String role = resultSet.getString("userType");
			
			if (role.equals("S")) {
				User u = new Student(userName, firstName, lastName, email, password);
				u.setVerificationCode(verificationCode);
				u.setVerified(isVerified);
				u.setRole(role);
				dbUsers.add(u);
			} else if (role.equals("T")) {
				User u = new Teacher(userName, firstName, lastName, email, password);
				u.setVerificationCode(verificationCode);
				u.setVerified(isVerified);
				u.setRole(role);
				dbUsers.add(u);
			} else if (role.equals("A")) {}
				User u = new Admin(userName, firstName, lastName, email, password);
				u.setVerificationCode(verificationCode);
				u.setVerified(isVerified);
				u.setRole(role);
				dbUsers.add(u);
		}

		return dbUsers;
	}

} // end class ApplicationDao