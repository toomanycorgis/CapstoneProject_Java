/**
 * 
 */
package users;

/**
 * @author ariella
 *
 */
public class UserFactory {
	
	public static User createUser(String userType) {
		switch (userType) {
		case "ADMIN": 
			break;
		case "TEACHER":
			break;
		case "STUDENT":
			break;
		default:
			//exception throw here
			break;
		}
		return null;
	}
}
