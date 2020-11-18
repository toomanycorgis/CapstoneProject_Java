package users;

//Student class with additional roles set for permissions 

public class Student extends User implements Observer {
	
	private int studentID;

	public Student(String userName, String firstName, String lastName, String email, String password) {
		super(userName, password, email);
		super.setRole(null);
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	public void update(String post) {
		System.out.println("Received updated post");
		
	}

}


/*
public Student(String userName, String password, String email) {
	super(userName, password, email);
	super.setRole("S");
}

public Student(String userName, String firstName, String lastName, String email, String password) {
	super(userName, firstName, lastName, email, password);
	super.setRole("S");
}
 */ 