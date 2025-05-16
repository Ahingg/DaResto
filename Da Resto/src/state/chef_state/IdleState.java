package state.chef_state;

import model.Chef;
import state.ChefState;

public class IdleState implements ChefState	{

	public IdleState() {
	}

	@Override
	public String getPrintFormat() {
		return "idle";
	}
	
}
