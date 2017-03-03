package dta.chat.model.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class ChatObservable<T> {

	List<ChatObserver<T>> observers = new ArrayList<ChatObserver<T>>();

	public void addObserver(ChatObserver<T> observer) {
		observers.add(observer);
	}

	public void removeObserver(ChatObserver<T> observer) {
		observers.remove(observer);
	}

	public void notifyObservers(T msg) {
		for (ChatObserver<T> obs : observers) {
			obs.update(this, msg);
		}
	}

}
