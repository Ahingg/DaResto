package singleton;

import model.Restaurant;

public class RestaurantSingleton {
	
	private static Restaurant instance;
	
	public static Restaurant getInstance() {
		if(instance == null) {
			instance = new Restaurant();
		}
		return instance;
	}
}
