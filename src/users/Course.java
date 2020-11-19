package users;

import java.util.ArrayList;
import java.util.List;

public class Course implements Subject{
	private String content;
	
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
		  System.out.println("new content added");
		  for(Observer subscriber: subscribers){
			  subscriber.update(); 
		  }  

	  }
	  
	  public void addContent (String content) {
		  System.out.println("Here is some new content: " + content);
		  notifySubscribers();
	  }
	  
	
	 
 
}
