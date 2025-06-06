package model;

import mediator.Mediator;

public class Worker extends Person{

	private Integer speed;
	
	public Worker(String name, Mediator mediator) {
		super(name, mediator);
		// TODO Auto-generated constructor stub
		this.speed = 1;
	}
	
	public void upgradeSpeed() {
		this.speed++;
	}
	
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}


}
