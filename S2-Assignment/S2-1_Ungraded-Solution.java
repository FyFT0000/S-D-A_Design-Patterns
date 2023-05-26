
/* 
Youtube allows users to follow their favorite Youtube stars so that they will be notified when the channel is live. This is commonly done using the observer pattern. Complete the provided code and use the following UML class diagram as a guide: 
*/

import java.util.ArrayList;


Subject.java

public interface Subject {
	public void registerObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObservers();
}

Channel.java

public class Channel implements Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String channelName;
	private String status;

	public Channel(String channelName, String status) {
		this.channelName = channelName;
		this.status = status;
	}
	
	public String getChannelName() {
		return channelName;
	}
	
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
	public string getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		notifyObservers();
	}

	public void notifyObservers() {
		for (Observer obs : observers) {
			obs.update(this.status);
		}
	}
	
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
}


Observer.java

public interface Observer {
	public void update(String status);
}


Follower.java

public class Follower implements Observer {

	private String followerName;

	public Follower(String followerName) {
		this.followerName = followerName;
	}

	public String getFollowerName() {
		return followerName;
	}

	public void setFollowerName(String followerName) {
		this.followerName = followerName;
	}

	public void update(String status) {
		//send message to followers that Channel is live.
	}
	
	public void play() {
		//play channel
	}

}
