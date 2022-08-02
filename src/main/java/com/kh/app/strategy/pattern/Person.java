package com.kh.app.strategy.pattern;

public class Person {
	private String name;
	private Pet pet;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, Pet pet) {
		super();
		this.name = name;
		this.pet = pet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", pet=" + pet + "]";
	}
	
	
}
