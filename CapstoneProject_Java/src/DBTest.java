import java.sql.SQLException;
import java.util.ArrayList;

import dao.AppDAO;
import users.User;

public class DBTest {

	public static void main(String[] args) throws SQLException {

		AppDAO appDAO = new AppDAO();
		appDAO.insertNewUser("JohnDoe1", "Passw0rd", "John", "Doe", "jd@mail.com", "123", "1", "T");
		appDAO.insertNewUser("JaneDoe1", "Passw0rd", "Jane", "Doe", "jd@mail.com", "123", "0", "S");
		appDAO.insertNewUser("Admin1", "Passw0rd", "Bob", "Builder", "bob@mail.com", "123", "1", "A");
		ArrayList<User> users = appDAO.showAllClassUsers();
		for (User user : users) {
			System.out.println(user.getUserName() + ": " + user.getRole() + " Is verified: " + user.isVerified());
			
		}
	}

}
