package cs474;

import java.util.List;

public class Person {
	String firstName;
	String lastName;
	String mail;
	String role;
	String teachingCourses;
	String takenCourses;
	String takingCourses;
	
	public Person() {
		super();
	}
	
	public String showInfo(List<String> list) {
		return "something";
	}
	
	public String getMail() {
		return mail.toLowerCase();
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTeachingCourses() {
		return teachingCourses.toLowerCase();
	}
	public void setTeachingCourses(String teachingCourses) {
		this.teachingCourses = teachingCourses;
	}
	public String getTakenCourses() {
		return takenCourses.toLowerCase();
	}
	public void setTakenCourses(String takenCourses) {
		this.takenCourses = takenCourses;
	}
	public String getFirstName() {
		return firstName.toLowerCase();
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName.toLowerCase();
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role.toLowerCase();
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTakingCourses() {
		return takingCourses.toLowerCase();
	}
	public void setTakingCourses(String takingCourses) {
		this.takingCourses = takingCourses;
	}
}
