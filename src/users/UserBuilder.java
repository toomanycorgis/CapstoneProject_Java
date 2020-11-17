package users;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class UserBuilder {
	
	public String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String verificationCode;
	private boolean isVerified;
	private String role;



public UserBuilder() {
}

public UserBuilder userName(String userName) {
	this.userName = userName;
	return this;
	
}

public UserBuilder setName(String firstName) {
	this.firstName = firstName; 
	return this; 
}

public UserBuilder setLastName(String lastName) {
this.lastName = lastName;
return this;
}


public UserBuilder setEmail(String email) {
this.email = email;
return this;
}

public UserBuilder setPassword(String password) {
this.password = password;
return this;
}


public UserBuilder setverificationCode(String verificationCode) {
this.verificationCode = verificationCode;
return this;
}

public UserBuilder setVerified(boolean isVerified) {
this.isVerified = isVerified;  
return this;
}

public UserBuilder setRole(String role) {
this.role = role; 
return this;
	
}

public User build() {
return new User(firstName, lastName, email, password, verificationCode, isVerified, role);
}
}