package observer;

import factory.CustomerGenerator;
public interface Broadcaster {
	public void addObserver(CustomerGenerator t);
	public void removeObserver(CustomerGenerator t);
	public void notifyObserver();
}
