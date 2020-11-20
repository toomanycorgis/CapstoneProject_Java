import java.sql.SQLException;
import java.util.ArrayList;

import dao.AppDAO;
import users.Teacher;
import users.User;

public class DBTest {

	public static void main(String[] args) throws SQLException {

		AppDAO appDAO = AppDAO.getInstance();
//		User u1 = new Teacher("TestTeacher", "Test", "Teacher", "email@aslkdj.com", "password");
//		appDAO.insertNewUser(u1);
//		appDAO.insertNewUser("JaneDoe2", "Passw0rd", "Jane", "Doe", "jd@mail.com", "123", "0", "S");
//    	appDAO.insertNewUser("Admin2", "Passw0rd", "Bob", "Builder", "bob@mail.com", "123", "1", "A");
//		ArrayList<User> users = appDAO.showAllClassUsers();
//		for (User user : users) {
//			System.out.println(user.getUserName() + ": " + user.getRole() + " Is verified: " + user.isVerified());
//		}
//		System.out.println("Correct password: " + appDAO.checkPassword("TestTeacher", "password"));
//		System.out.println("Incorrect password: " + appDAO.checkPassword("TestTeacher", "poop"));
//		User u = appDAO.getUserObject("TestTeacher");
//		System.out.println("Got user object: " + u.displayUser(u));
		
		System.out.println(appDAO.userExists("TestTeacher"));
		System.out.println(appDAO.userExists("kasjdhksdjfbidsjhf"));
		
		//test SendMail ---- enter your own email to test it out ------
		SendMail.send("jennifer.olenic@gmail.com", "test", "this is a test");
	}

}

//JEN NOTE TO SELF:  Clearly != null is a bad way to check for this.  research this and implement fix in AppDAO, and for checkPassword too