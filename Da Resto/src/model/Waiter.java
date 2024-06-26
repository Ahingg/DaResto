package model;

import mediator.Mediator;
import state.WaiterState;
import state.waiter_state.IdleState;

public class Waiter extends Worker{

	private WaiterState state;
	public Waiter(String name, Mediator mediator) {
		super(name,mediator);
		this.state = new IdleState();
	}
	
	public void resetState() {
		this.state = new IdleState();
	}
	
	public void setState(WaiterState state) {
		this.state = state;
	}
	
	public WaiterState getState() {
		return state;
	}
	
	

}
