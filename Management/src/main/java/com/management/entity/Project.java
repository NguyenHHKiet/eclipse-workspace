package com.management.entity;

import java.util.List;

public class Project {

	private int id;
	private String name;
	private float totalInvestment;
	private String nameLeader;
	private int count;
	private List<OrderProject> orderprojects;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int id, String name, float totalInvestment, String nameLeader, int count) {
		super();
		this.id = id;
		this.name = name;
		this.totalInvestment = totalInvestment;
		this.nameLeader = nameLeader;
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

	public String getNameLeader() {
		return nameLeader;
	}

	public void setNameLeader(String nameLeader) {
		this.nameLeader = nameLeader;
	}

	public List<OrderProject> getOrderprojects() {
		return orderprojects;
	}

	public void setOrderprojects(List<OrderProject> orderprojects) {
		this.orderprojects = orderprojects;
	}

}
