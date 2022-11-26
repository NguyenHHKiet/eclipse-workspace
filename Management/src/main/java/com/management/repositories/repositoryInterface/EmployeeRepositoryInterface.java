package com.management.repositories.repositoryInterface;

import java.sql.ResultSet;

import com.management.ConnectionSQL;

public interface EmployeeRepositoryInterface {
	void display(ResultSet rs);

	void show(ResultSet rs);

	void AddEmployee(ConnectionSQL conn);

	void SearchEmployee(ConnectionSQL conn);

	void EditEmployee(ConnectionSQL conn);

	void DeleteEmployee(ConnectionSQL conn);

	void DisplayAllEmployees(ConnectionSQL conn);
}
