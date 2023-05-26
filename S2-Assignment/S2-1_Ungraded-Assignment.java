
/* 
Youtube allows users to follow their favorite Youtube stars so that they will be notified when the channel is live. This is commonly done using the observer pattern. Complete the provided code and use the following UML class diagram as a guide: 
*/

import java.util.ArrayList;


//Subject.java

public interface Subject {

    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserverss();
}


//Channel.java

public class Channel implements Subject {

    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private String channelName;
    private String status = "";

    public Channel (String channelName) {
        this.channelName = channelName;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String newStatus) {
        status = newStatus;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObserverss() {
        for (Observer o : observers) {
            o.update(status);
        }
    }
}


//Observer.java

public interface Observer {

	public void update(String status);
}


//Follower.java

public class Follower implements Observer {

    private String followerName;

    public Follower(String followerName) {
        this.followerName = followerName;
    }

    public void update(String status) {
        // get the Youtube channel change
    }
    public void play() {
        // play the Youtube channel change
    }
}
