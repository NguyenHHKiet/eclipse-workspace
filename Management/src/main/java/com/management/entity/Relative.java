package com.management.entity;

public class Relative {

	private int id;
	private String name;
	private String phone;
	private int employee_id;

	public Relative() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Relative(int id, String name, String phone, int employee_id) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.employee_id = employee_id;
	}

	@Override
	public String toString() {
		return "Relative [id=" + id + ", name=" + name + ", phone=" + phone + ", employee_id=" + employee_id + "]";
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

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

}
