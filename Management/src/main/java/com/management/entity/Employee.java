package com.management.entity;

public class Employee {

	private int id;
	private String name;
	private float salary;
	private long contact_no;
	private String email_id;
	private float totolSalaryBonus;

	public Employee(int id, String name, float salary, long contact_no, String email_id, float totolSalaryBonus) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.contact_no = contact_no;
		this.email_id = email_id;
		this.totolSalaryBonus = totolSalaryBonus;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
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

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public long getContact_no() {
		return contact_no;
	}

	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public float getTotolSalaryBonus() {
		return totolSalaryBonus;
	}

	public void setTotolSalaryBonus(float totolSalaryBonus) {
		this.totolSalaryBonus = totolSalaryBonus;
	}

}
