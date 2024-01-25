package com.hsaini.studentapp;

public class Student {
	private int id;
	private String name;
	private int age;
	private String major;

	public Student() {
		// TODO Auto-generated constructor stub
	}
	//	 public Student(int id, String name, int age, String major) {
	//		 this.id = id;
	//		 this.name = name;
	//		 this.age = age;
	//		 this.major = major; 
	//	 }
	// Getters
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getMajor() {
		return major;
	}
	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}