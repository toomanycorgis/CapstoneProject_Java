package users;

//Teacher class with additional roles set for permissions 
public class Teacher extends User {
	
	private int teacherID;

	public Teacher(String userName, String firstName, String lastName, String email, String password) {
		super(userName, firstName, lastName, email, password);
		super.setRole("T"); //from factory
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
}


/*
public Teacher(String userName, String firstName, String lastName, String email, String password) {
	super(userName, firstName, lastName, email, password);
	super.setRole("T");
}

public Teacher(String userName, String password, String email) {
	super(userName, password, email);
	super.setRole("T");
} */
