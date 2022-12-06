package com.management.repositories.repositoryInterface;

import java.sql.ResultSet;

import com.management.ConnectionSQL;

public interface DepartmentRepositoryInterface {
	void display(ResultSet rs);

	void show(ResultSet rs);

	void AddDepartment(ConnectionSQL conn);
	
	void DisplayDepartment(ConnectionSQL conn);
}
