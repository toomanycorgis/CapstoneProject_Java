package users;

//Teacher class with additional roles set for permissions 
public class Teacher extends User implements Subject {
	
	private int teacherID;

	public Teacher(String userName, String firstName, String lastName, String email, String password) {
		super(userName, password, email);
		super.setRole(null);
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	
	 final List<Observer> subscribers = new ArrayList<>(); 
		
	  @Override
	  public void addSubscriber(Observer subscriber) {
	  subscribers.add(subscriber);
	  System.out.println(subscriber + " has started following post updates");
	  }
	    	    
	  public void removeSubscribers(Observer subscriber) {
        subscribers.remove(subscriber);
        System.out.println(subscriber + " has stopped following post updates");
	  }
	  
	@Override
   public void notifySubscribers() {
    System.out.println("new post added");
    for(Observer subscriber: subscribers) {
      subscriber.update("post update"); 
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
