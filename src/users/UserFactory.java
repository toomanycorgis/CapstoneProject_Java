/**
 * 
 */
package users;

/**
 * @author ariella
 *
 */

//Factory for creation of users 
public class UserFactory {
	
	public User createUser(String userType, String userName, String firstName, String lastName, String email, String password) {
		User user = null;
		switch (userType) {
		case "A":
			user = new Admin(userName, firstName, lastName, email, password);
			break;
		case "T":
			user = new Teacher(userName, firstName, lastName, email, password);
			break;
		case "S":
			user = new Student(userName, firstName, lastName, email, password);
			break;
		default:
			//exception throw here
			break;
		}
		return user;
	}
}