package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import users.Admin;
import users.Student;
import users.Teacher;
import users.User;
import users.UserFactory;

public class AppDAO {
	
	//REMINDER: MAKE SURE PASSWORD IN DBConnection.java HAS BEEN CHANGED TO MATCH LOCAL

	// declaring instance for singleton
	private static AppDAO dao_instance = null;

	// declare variables
	private Connection connection;
	private PreparedStatement insertNewUser;
	private PreparedStatement getUser;

	// SQL TO CREATE DATABASE LOCALLY

//	`username` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
//  `password` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `firstName` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `lastName` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `email` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
//  `verificationCode` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `isVerified` bool DEFAULT false,
//  `userType` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `classroomID

	// private constructor, not accessible from outside the class to enforce singleton
	private AppDAO() {
		try {
			connection = DBConnectionProxy.getConnectionToDatabase();
			insertNewUser = connection.prepareStatement("INSERT INTO users"
					+ "(username, password, firstName, lastName, email, verificationCode, isVerified, userType)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			getUser = connection.prepareStatement("SELECT * FROM users" + " WHERE userName LIKE ?");

		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	// getInstance method returns static instance (Singleton)
	public static AppDAO getInstance() {
		if (dao_instance == null)
			dao_instance = new AppDAO();

		return dao_instance;
	}

	// takes a user object and inserts info into DB
	public int insertNewUser(User u) {
		try {
			insertNewUser.setString(1, u.userName);
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

	// gets a DB record of a user as a ResultSet, to be processed by other methods
	// within the class.
	// set to private because it is never used directly outside of AppDAO
	private ResultSet getUser(String userName) {
		try {
			getUser.setString(1, userName);
			return getUser.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// returns whether or not that user exists in the DB
	public boolean userExists(String userName) throws SQLException {
		if (getUser(userName).next()) {
			return true;
		} else
			return false;
	}

	// returns a user object of a DB record
	public User getUserObject(String userName) throws SQLException {

		UserFactory factory = new UserFactory();
		getUser.setString(1, userName);
		ResultSet dbUser = getUser.executeQuery();
		User u = null;

		// use ResultSet from getUser and get info to create user object
		while (dbUser.next()) {

			String firstName = dbUser.getString("firstName");
			System.out.println(firstName);
			String lastName = dbUser.getString("lastName");
			System.out.println(lastName);
			String email = dbUser.getString("email");
			String password = dbUser.getString("password");
			String verificationCode = dbUser.getString("verificationCode");
			boolean isVerified = dbUser.getBoolean("isVerified");
			String role = dbUser.getString("userType");
			System.out.println(role);

			// delegate to UserFactory to create the correct subclass
			u = factory.createUser(role, userName, firstName, lastName, email, password);
			u.setVerificationCode(verificationCode);
			u.setVerified(isVerified);
			u.setRole(role);
		}

		return u;
	} // end method geUserObject()

	// gets a user object from a given userName and checks that the password matches
	// the DB record
	public boolean checkPassword(String userName, String password) throws SQLException {
		if (getUser(userName).next()) {
			User u = getUserObject(userName);
			if (u.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// not currently in use in app
	// creates an ArrayList of users with the same classroomID (not yet implemented,
	// placeholder for future development of multiple classes)
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
			} else if (role.equals("A")) {
			}
			User u = new Admin(userName, firstName, lastName, email, password);
			u.setVerificationCode(verificationCode);
			u.setVerified(isVerified);
			u.setRole(role);
			dbUsers.add(u);
		}

		return dbUsers;
	} // end method showAllClassUsers()

} // end class ApplicationDao