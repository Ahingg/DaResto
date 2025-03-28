package model;

import mediator.Mediator;

public abstract class Worker{

	private String name;
	private Integer speed;
	private Mediator mediator;
	public Worker(String name, Mediator mediator) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.speed = 1;
		this.mediator = mediator;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	
	public Mediator getMediator() { return mediator; } 

}
