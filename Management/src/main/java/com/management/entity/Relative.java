package com.management.entity;

public class Relative {

	private int id;
	private String name;
	private String phone;
	private Employee employee;

	public Relative() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Relative(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getEmployee() {
		return employee.getId();
	}

	public void setEmployee(int id) {
		this.employee.setId(id);
	}
}
