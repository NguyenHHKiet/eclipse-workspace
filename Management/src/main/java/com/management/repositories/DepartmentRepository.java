package com.management.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.management.ConnectionSQL;
import com.management.entity.Department;
import com.management.repositories.repositoryInterface.DepartmentRepositoryInterface;

public class DepartmentRepository implements DepartmentRepositoryInterface {
	
	Department dep = new Department(0, null);
	Scanner sc = new Scanner(System.in);

	@Override
	public void display(ResultSet rs) {
		// TODO Auto-generated method stub
		System.out.println("\n--------------Department List---------------\n");
		System.out.println(String.format("%-10s%-20s", "ID", "Name"));
		try {
			while (rs.next()) {
				System.out.println(String.format("%-10s%-20s", rs.getObject(1).toString(),
						rs.getObject(2).toString()));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void show(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			System.out.println("\nDepartment Details :" + "\nID: " + rs.getObject(1).toString() + "\nName: "
					+ rs.getObject(2).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		try {
			conn.prestatement = conn.connection.prepareStatement("insert into department values(?,?)");
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		System.out.println("\nEnter the following details to ADD list:\n");
		System.out.println("Enter ID :");
		dep.setId(sc.nextInt());
		System.out.println("Enter Name :");
		dep.setName(sc.next());
		
		try {
			conn.prestatement.setInt(1, dep.getId());
			conn.prestatement.setString(2, dep.getName());
			conn.prestatement.executeUpdate();
			// In this sample, connect to SQL Database, execute a SELECT statement, and
			// return selected rows.
			conn.rs = conn.stmt.executeQuery("select * from department");
			display(conn.rs);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void displayAll(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		try {
			conn.rs = conn.stmt.executeQuery("select * from department");
			this.display(conn.rs);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void search(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		
	}

}
