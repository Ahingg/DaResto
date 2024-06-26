package state.chef_state;

import model.Chef;
import state.ChefState;

public class IdleState implements ChefState	{

	public IdleState() {
		
	}

	@Override
	public void reset(Chef chef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPrintFormat() {
		// TODO Auto-generated method stub
		return "idle";
	}
	

}
