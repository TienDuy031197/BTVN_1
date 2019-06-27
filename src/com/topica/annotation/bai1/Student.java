package com.topica.annotation.bai1;

public class Student {
	@getNameFieldMethod
	private String name;

	@getNameFieldMethod
	private Integer age;
	private String address;

	@getNameFieldMethod
	public static final String data = "This is Data";
	public static final String process = "Processer";

	public Student(String name, Integer age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@getNameFieldMethod
	public String getName() {
		return name;
	}

	@getNameFieldMethod
	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
