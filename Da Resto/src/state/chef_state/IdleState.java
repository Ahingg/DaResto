package state.chef_state;

import model.Chef;
import state.State;

public class IdleState implements State	{

	public IdleState() {
	}

	@Override
	public String getPrintFormat() {
		return "idle";
	}
	
}
