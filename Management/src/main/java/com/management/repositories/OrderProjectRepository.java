package com.management.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.management.ConnectionSQL;
import com.management.entity.Employee;
import com.management.entity.OrderProject;
import com.management.entity.Project;
import com.management.repositories.repositoryInterface.OrderProjectRepositoryInterface;

public class OrderProjectRepository implements OrderProjectRepositoryInterface {
	OrderProject emp = new OrderProject(0, 0, 0, 0);
	Scanner sc = new Scanner(System.in);

	@Override
	public void display(ResultSet rs) {
		// TODO Auto-generated method stub
		System.out.println("\n--------------Order Project List---------------\n");
		System.out.println(String.format("%-10s%-25s%-20s%-20s", "ID", "Bonus", "Employee-Id", "Project-Id"));
		try {
			while (rs.next()) {
				System.out.println(String.format("%-10s%-25s%-20s%-20s", rs.getObject(1).toString(),
						rs.getObject(2).toString(), rs.getObject(3).toString(), rs.getObject(4).toString()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showOrderProject(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			System.out.println("\nOrderProject Details :" + "\nID: " + rs.getObject(1).toString() + "\nBonus: "
					+ rs.getObject(2).toString() + "\nEmployee-Id: " + rs.getObject(3).toString() + "\nProject-Id: "
					+ rs.getObject(4).toString() + " ");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void show(ResultSet rs, String type) {
		// TODO Auto-generated method stub
		try {
			if (type == "Employee") {
				System.out.println("\n--------------Employee Participate List---------------\n");
				System.out.println(String.format("%-10s%-20s%-20s%-20s%-25s%-30s", "ID", "Name", "Salary", "Contact-no",
						"Email-Id", "Totol-SalaryBonus"));
				while (rs.next()) {
					System.out.println(String.format("%-10s%-20s%-20s%-20s%-25s%-30s", rs.getObject(1).toString(),
							rs.getObject(2).toString(), rs.getObject(3).toString(), rs.getObject(4).toString(),
							rs.getObject(5).toString(), rs.getObject(6).toString()));
				}
			} else {
				System.out.println("\n--------------Project Participate List---------------\n");
				System.out.println(String.format("%-10s%-20s%-20s%-20s%-25s", "ID", "Project Name", "Total Investment",
						"Leader Name", "Count"));
				while (rs.next()) {
					System.out.println(String.format("%-10s%-20s%-20s%-20s%-25s", rs.getObject(1).toString(),
							rs.getObject(2).toString(), rs.getObject(3).toString(), rs.getObject(4).toString(),
							rs.getObject(5).toString()));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void SetupOrderProject(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		try {
			conn.prestatement = conn.connection.prepareStatement("insert into orderProject values(?,?,?,?)");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("\nEnter the following details to ADD list:\n");
		System.out.println("Enter ID :");
		emp.setId(sc.nextInt());
		emp.setBonus(0);
		System.out.println("Enter Employee Id :");
		emp.setEmployee_id(sc.nextInt());
		System.out.println("Enter Project Id :");
		emp.setProject_id(sc.nextInt());

		try {
			conn.prestatement.setInt(1, emp.getId());
			conn.prestatement.setFloat(2, emp.getBonus());
			conn.prestatement.setInt(3, emp.getEmployee_id());
			conn.prestatement.setInt(4, emp.getProject_id());
			conn.prestatement.executeUpdate();
			// In this sample, connect to SQL Database, execute a SELECT statement, and
			// return selected rows.
			conn.stmt.executeUpdate("UPDATE project SET count = count - 1 where id =" + emp.getProject_id());
			conn.rs = conn.stmt.executeQuery("select * from orderProject");
			display(conn.rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void DisplayAllEmployees(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		Project ae = new Project();
		String type = "Employee";
		System.out.println("Enter the Project-ID to search :");
		ae.setId(sc.nextInt());
		int i = 0;
		try {
			conn.rs = conn.stmt.executeQuery("select employee.* from orderproject inner join employee\r\n"
					+ "on orderproject.employee_id = employee.id\r\n" + "and project_id=" + ae.getId());
			this.show(conn.rs, type);
			i++;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 0) {
			System.out.println("\nProject Details are not available, Please enter a valid ID!!");
		}
	}

	@Override
	public void DisplayAllProject(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		Employee ap = new Employee();
		String type = "Project";
		System.out.println("Enter the Employee-ID to search :");
		ap.setId(sc.nextInt());
		int i = 0;
		try {
			conn.rs = conn.stmt.executeQuery("select project.* from orderproject inner join project\r\n"
					+ "on orderproject.project_id = project.id\r\n" + "and employee_id=" + ap.getId());
			this.show(conn.rs, type);
			i++;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 0) {
			System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
		}
	}

	@Override
	public void UpdateBonusEmployee(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		System.out.println("Enter the OrderProject-ID of Employee :");
		emp.setId(sc.nextInt());
		System.out.println("Enter Bonus of Employee for Project :");
		emp.setBonus(sc.nextFloat());
		int i = 0;
		try {
			conn.stmt.executeUpdate("UPDATE orderProject SET bonus = " + emp.getBonus() + " where id =" + emp.getId());

			conn.rs = conn.stmt.executeQuery("select * from orderproject");
			while (conn.rs.next()) {
				if (emp.getId() == conn.rs.getInt(1)) {
					int id=conn.rs.getInt(3);
					conn.rs = conn.stmt
							.executeQuery("SELECT sum(bonus) as sum_bonus, salary FROM orderproject, employee \r\n"
									+ "where orderproject.employee_id = employee.id and employee_id="
									+ id);
					// Before start of result set
					if (conn.rs.next()) {
						conn.stmt.executeUpdate("UPDATE employee SET totolSalaryBonus = "
								+ (conn.rs.getInt("sum_bonus") + conn.rs.getInt("salary")) + " where id ="
								+ id);
						i++;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 0) {
			System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
		}
	}

	@Override
	public void DisplayAll(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		try {
			conn.rs = conn.stmt.executeQuery("select * from orderProject");
			this.display(conn.rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void SearchOrderProject(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		System.out.println("Enter the OrderProject ID to search :");
		emp.setId(sc.nextInt());
		int i = 0;
		try {
			conn.rs = conn.stmt.executeQuery("select * from orderproject");
			while (conn.rs.next()) {
				if (emp.getId() == conn.rs.getInt(1)) {
					this.showOrderProject(conn.rs);
					i++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 0) {
			System.out.println("\nOrderProject Details are not available, Please enter a valid ID!!");
		}
	}

}
