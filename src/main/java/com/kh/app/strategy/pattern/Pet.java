package com.kh.app.strategy.pattern;

public abstract class Pet {
	protected String name;

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pet(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String className = this.getClass().getName();
		int lastIndex = className.lastIndexOf(".");
		return  className.substring(lastIndex + 1)+ " [name=" + name + "]";//클래스 이름에 맞춰서 출력됨
	}
}
