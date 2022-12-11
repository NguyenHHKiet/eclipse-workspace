package com.management.entity;

import java.util.List;

public class Employee {

	private int id;
	private String name;
	private float salary;
	private long contactNo;
	private String emailId;
	private float totolSalaryBonus;
	private int dateOfBirth;
	private Department department = new Department();
	private List<OrderProject> orderprojects;
	private List<Relative> relatives;

	public Employee(int id, String name, float salary, long contactNo, String emailId, float totolSalaryBonus,
			int dataOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.totolSalaryBonus = totolSalaryBonus;
		this.dateOfBirth = dataOfBirth;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public float getTotolSalaryBonus() {
		return totolSalaryBonus;
	}

	public void setTotolSalaryBonus(float totolSalaryBonus) {
		this.totolSalaryBonus = totolSalaryBonus;
	}

	public int getDepartment() {
		return department.getId();
	}

	public void setDepartment(int id) {
		this.department.setId(id);
	}

	public List<OrderProject> getOrderprojects() {
		return orderprojects;
	}

	public void setOrderprojects(List<OrderProject> orderprojects) {
		this.orderprojects = orderprojects;
	}

	public List<Relative> getRelatives() {
		return relatives;
	}

	public void setRelatives(List<Relative> relatives) {
		this.relatives = relatives;
	}

}
