package com.musicLibrary.Beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private String password;
	private String firstName;
	private String lastName;
	private String type;
	private String email;
	private int userId;

	public User() {
	}

	public User(int userId, String firstName, String lastName) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(int userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public User(int userId, String firstName, String lastName, String type, String password) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		if (type == null) {
			this.type = "cust";
		} else {
			this.type = type;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
