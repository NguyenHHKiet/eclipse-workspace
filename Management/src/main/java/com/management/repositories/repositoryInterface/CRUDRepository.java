package com.management.repositories.repositoryInterface;

import java.sql.ResultSet;

import com.management.ConnectionSQL;

public interface CRUDRepository {
	void display(ResultSet rs);

	void show(ResultSet rs);

	void add(ConnectionSQL conn);

	void search(ConnectionSQL conn);

	void edit(ConnectionSQL conn);

	void delete(ConnectionSQL conn);

	void displayAll(ConnectionSQL conn);
}
