package model;

import mediator.Mediator;
import state.State;
import state.chef_state.IdleState;


public class Chef extends Worker{
	private Integer skill;
	private State state;
	public Chef(String name, Mediator mediator) {
		super(name, mediator);
		this.skill = 1;
		state = new IdleState();
	}
	
	public Integer getSkill() {
		return skill;
	}
	
	public void setSkill(Integer skill) {
		this.skill = skill;
	}
	
	public void upgradeSkill() {
		this.skill++;
	}

	public State getState() {
		return this.state;
	}
	
	
	public void resetState() {
		this.state = new IdleState();
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
}
