package users;

public interface Subject {
	public void notifySubscribers();
	public void addSubscribers(Observer observer);
	public void removeSubscribers(Observer observer);

}