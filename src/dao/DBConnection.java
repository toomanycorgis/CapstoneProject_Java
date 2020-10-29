package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//CREATE DATABASE `capstone` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
//use capstone;
//CREATE TABLE `users` (
//  `username` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
//  `password` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `firstName` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `lastName` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `email` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
//  `verificationCode` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `isVerified` bool DEFAULT false,
//  `userType` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `classroomID` int DEFAULT 1,
//  PRIMARY KEY (`username`)
//) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
//use capstone;
//CREATE TABLE `class_posts` (
//  `postID` int NOT NULL auto_increment,
//  `classroomID` int DEFAULT 1,
//  `username` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
//  `time` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `type` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
//  `title` varchar(120) COLLATE utf8_unicode_ci DEFAULT NULL,
//  `content` text COLLATE utf8_unicode_ci,
//  PRIMARY KEY (`postID`)
//) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

public class DBConnection {

	private static final String dbUser = "root";
	private static final String dbPassword = "password";

	public static Connection getConnectionToDatabase() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
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