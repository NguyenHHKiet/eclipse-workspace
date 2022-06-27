package com.coding.entity;

public class BlogUser {
	private int user_id;
	private String name;
	private String email;
	public BlogUser(int user_id, String name, String email) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
