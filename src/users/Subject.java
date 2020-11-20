package users;

//subject interface from Observer design pattern
public interface Subject {
	
	//see course.java for usages
	public void notifySubscribers();
	public void addSubscribers(Observer observer);
	public void removeSubscribers(Observer observer);

}