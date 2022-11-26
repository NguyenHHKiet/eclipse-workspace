package com.management.entity;

public class OrderProject {
	private int id;
	private float bonus;
	private int employee_id;
	private int project_id;

	public OrderProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderProject(int id, float bonus, int employee_id, int project_id) {
		super();
		this.id = id;
		this.bonus = bonus;
		this.employee_id = employee_id;
		this.project_id = project_id;
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

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

}
