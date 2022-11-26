package com.management.entity;

public class Project {

	private int id;
	private String name;
	private float totalInvestment;
	private String name_leader;
	private int count;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int id, String name, float totalInvestment, String name_leader, int count) {
		super();
		this.id = id;
		this.name = name;
		this.totalInvestment = totalInvestment;
		this.name_leader = name_leader;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public float getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(float totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

	public String getName_leader() {
		return name_leader;
	}

	public void setName_leader(String name_leader) {
		this.name_leader = name_leader;
	}

}
