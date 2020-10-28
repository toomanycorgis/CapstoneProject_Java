import java.util.UUID;

public abstract class User {
	
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String verificationCode;
	private boolean isVerified;
	private String role;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public User (String userName, String firstName, String lastName, 
			String email, String password) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isVerified = false;
		this.verificationCode = String.valueOf(UUID.randomUUID());
	}
	
	public User (String userName, String password, String email) {	
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.isVerified = false;
		this.verificationCode = String.valueOf(UUID.randomUUID());
	}
	
	public String displayUser(User u) {
		return userName + ": " + role +  "   " + firstName + " " + lastName;
	}

}