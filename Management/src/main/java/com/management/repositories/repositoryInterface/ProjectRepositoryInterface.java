package com.management.repositories.repositoryInterface;

import java.sql.ResultSet;

import com.management.ConnectionSQL;

public interface ProjectRepositoryInterface {
	void display(ResultSet rs);

	void show(ResultSet rs);

	void AddProject(ConnectionSQL conn);

	void SearchProject(ConnectionSQL conn);

	void EditProject(ConnectionSQL conn);

	void DeleteProject(ConnectionSQL conn);

	void DisplayAllProjects(ConnectionSQL conn);

	void DisplaySrotInvestment(ConnectionSQL conn);
}
