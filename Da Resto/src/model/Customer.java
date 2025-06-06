package model;

import mediator.Mediator;
import state.CustomerState;

public class Customer extends Person{


	private Integer tolerance;
	private  CustomerState state;
	
	public Customer(String name, Mediator mediator) {
		super(name, mediator);
		this.tolerance = 12;
	}

	
	public Integer getTolerance() {
		return tolerance;
	}
	public void setTolerance(Integer tolerance) {
		this.tolerance = tolerance;
	}
	
	public void decreaseTolerance() { tolerance --; }
	
	public CustomerState getState() {
		return state;
	}
	public void setState(CustomerState state) {
		this.state = state;
	}
	
	public void nextState() {
		this.state.nextState(this);
	}
	
	public void rageLeave() {
		getMediator().customerRageLeave(this);
	}
	
}
