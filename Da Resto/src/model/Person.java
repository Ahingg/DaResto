package model;

import mediator.Mediator;

public abstract class Person {

	 private String name;
	 private Mediator mediator;

	 public Person(String name, Mediator mediator) {
		 this.name = name;
	     this.mediator = mediator;
	 }

	 public String getName() { return name; }
	 public void setName(String name) { this.name = name; }
	 public Mediator getMediator() { return mediator; }

}
