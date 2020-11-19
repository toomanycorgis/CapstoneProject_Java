package users;

import java.util.ArrayList;
import java.util.List;

public class Course implements Subject{
	
	final List<Observer> subscribers = new ArrayList<>(); 
	
	  @Override
	  public void addSubscribers(Observer subscriber) {
	  subscribers.add(subscriber);
	  System.out.println(subscriber + " has started following the course");
	  }
	    	    
	  public void removeSubscribers(Observer subscriber) {
      subscribers.remove(subscriber);
      System.out.println(subscriber + " has stopped following the course");
	  }
	  
	  @Override
	  public void notifySubscribers() {
		  System.out.println("new post added");
		  for(Observer subscriber: subscribers) {
			  subscriber.update("post update"); 
		  }  

	  }
	  
	  public void addContent (String content) {
		  System.out.println("Here is some new content: " + content);
		  notifySubscribers();
	  }
 
}
