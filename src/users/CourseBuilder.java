package users;

public class CourseBuilder {

		
		public String teachFirstName;
		public String teachLastName;
		private String section;
		private String courseName;
		private String department;
		private int classSize; 


	public CourseBuilder() {
	}

	public CourseBuilder setteachFirstName(String teachFirstName) {
		this.teachFirstName = teachFirstName;
		return this;
		
	}

	public CourseBuilder setteachLastName(String teachLastName) {
		this.teachLastName = teachLastName; 
		return this; 
	}

	public CourseBuilder setSection(String section) {
	this.section = section;
	return this;
	}


	public CourseBuilder setcourseName(String courseName) {
	this.courseName = courseName;
	return this;
	}

	public CourseBuilder setDepartment(String department) {
	this.department = department;
	return this;
	}

	public CourseBuilder setClassSize(int classSize) {
	this.classSize = classSize; 
	return this;


	public Course build() {
	return new Course(teachFirstName, teachLastName, section, courseName, department, classSize);
	}
	}

}
