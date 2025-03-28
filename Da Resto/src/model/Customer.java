package model;

import mediator.Mediator;
import state.CustomerState;

public class Customer{

	private String name;
	private Integer tolerance;
	private Mediator mediator;
	private  CustomerState state;
	public Customer(String name, Mediator mediator) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.tolerance = 12;
		this.mediator = mediator;
		
	}
	
	public Mediator getMediator () { return mediator; }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		mediator.customerRageLeave(this);
	}
	
}
