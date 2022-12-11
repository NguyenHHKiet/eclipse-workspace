package com.management.repositories.repositoryInterface;

import java.sql.ResultSet;

import com.management.ConnectionSQL;

public interface DepartmentRepositoryInterface {
//	public static final int dasd = 0;
//	public static final String dsa = "";
	void display(ResultSet rs);

	void show(ResultSet rs);

	void AddDepartment(ConnectionSQL conn);
	
	void DisplayDepartment(ConnectionSQL conn);
}
