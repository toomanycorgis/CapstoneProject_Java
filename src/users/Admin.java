package users;

//Admin class with additional roles set for permissions 

public class Admin extends User {
	
	private int adminID;

	public Admin(String userName, String firstName, String lastName, String email, String password) {
		super(userName, firstName, lastName, email, password);
		super.setRole("A"); //from factory
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
}


/*
public Admin(String userName, String firstName, String lastName, String email, String password) {
	super(userName, firstName, lastName, email, password);
	super.setRole("A");
}

public Admin(String userName, String password, String email) {
	super(userName, password, email);
	super.setRole("A");
} */