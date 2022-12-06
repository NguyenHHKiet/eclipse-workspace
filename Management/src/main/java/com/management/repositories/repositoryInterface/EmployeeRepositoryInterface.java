package com.management.repositories.repositoryInterface;

import java.sql.ResultSet;

import com.management.ConnectionSQL;

public interface EmployeeRepositoryInterface {
	void display(ResultSet rs);

	void show(ResultSet rs);

	void AddEmployee(ConnectionSQL conn);

	void AddRelative(ConnectionSQL conn);

	void SearchEmployee(ConnectionSQL conn);

	void EditEmployee(ConnectionSQL conn);

	void DeleteEmployee(ConnectionSQL conn);

	void DisplayAllEmployees(ConnectionSQL conn);

	void SearchEmployeeBaseName(ConnectionSQL conn);

	void SearchEmployeeBaseBirth(ConnectionSQL conn);

	void SearchEmployeeBaseDepartment(ConnectionSQL conn);
	
	void SearchFromToYearOld(ConnectionSQL conn);
	
	void DisplayRelativeBaseEmployee(ConnectionSQL conn);
}
