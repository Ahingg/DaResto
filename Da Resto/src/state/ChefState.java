package state;

import model.Chef;

public interface ChefState {
	void reset(Chef chef);
	
	String getPrintFormat();
}
