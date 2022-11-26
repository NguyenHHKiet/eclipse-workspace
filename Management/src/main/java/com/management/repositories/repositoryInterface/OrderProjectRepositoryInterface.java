package com.management.repositories.repositoryInterface;

import java.sql.ResultSet;

import com.management.ConnectionSQL;

public interface OrderProjectRepositoryInterface {
	void display(ResultSet rs);

	void showOrderProject(ResultSet rs);

	void SearchOrderProject(ConnectionSQL conn);

	void SetupOrderProject(ConnectionSQL conn);

	void DisplayAllEmployees(ConnectionSQL conn);

	void DisplayAllProject(ConnectionSQL conn);

	void UpdateBonusEmployee(ConnectionSQL conn);

	void DisplayAll(ConnectionSQL conn);
}
