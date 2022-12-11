package com.management.entity;

public class OrderProject {
	private int id;
	private float bonus;
	private Employee employee = new Employee();
	private Project project = new Project();

	public OrderProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderProject(int id, float bonus) {
		super();
		this.id = id;
		this.bonus = bonus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

	public int getEmployee() {
		return employee.getId();
	}

	public void setEmployee(int id) {
		this.employee.setId(id);
	}

	public int getProject() {
		return project.getId();
	}

	public void setProject(int id) {
		this.project.setId(id);
	}

}
