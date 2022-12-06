package com.management.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.management.ConnectionSQL;
import com.management.entity.Project;
import com.management.repositories.repositoryInterface.ProjectRepositoryInterface;

public class ProjectRepository implements ProjectRepositoryInterface {

	Project emp = new Project(0, null, 0, null, 0);
	Scanner sc = new Scanner(System.in);

	@Override
	public void display(ResultSet rs) {
		// TODO Auto-generated method stub
		System.out.println("\n--------------Project List---------------\n");
		System.out.println(String.format("%-10s%-25s%-20s%-20s%-5s", "ID", "Project Name", "Total Investment",
				"Leader Name", "Count"));
		try {
			while (rs.next()) {
				System.out.println(String.format("%-10s%-25s%-20s%-20s%-5s", rs.getObject(1).toString(),
						rs.getObject(2).toString(), rs.getObject(3).toString(), rs.getObject(4).toString(),
						rs.getObject(5).toString()));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void show(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			System.out.println("\nProject Details :" + "\nID: " + rs.getObject(1).toString() + "\nProject Name: "
					+ rs.getObject(2).toString() + "\nTotal Investment: " + rs.getObject(3).toString()
					+ "\nLeader Name: " + rs.getObject(4).toString() + " ");

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void AddProject(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		try {
			conn.prestatement = conn.connection.prepareStatement("insert into project values(?,?,?,?,?)");
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		System.out.println("\nEnter the following details to ADD list:\n");
		System.out.println("Enter ID :");
		emp.setId(sc.nextInt());
		System.out.println("Enter Project Name :");
		emp.setName(sc.next());
		System.out.println("Enter Total Investment :");
		emp.setTotalInvestment(sc.nextFloat());
		System.out.println("Enter Leader Name :");
		emp.setName_leader(sc.next());
		emp.setCount(5);

		try {
			conn.prestatement.setInt(1, emp.getId());
			conn.prestatement.setString(2, emp.getName());
			conn.prestatement.setFloat(3, emp.getTotalInvestment());
			conn.prestatement.setString(4, emp.getName_leader());
			conn.prestatement.setInt(5, emp.getCount());
			conn.prestatement.executeUpdate();
			conn.rs = conn.stmt.executeQuery("select * from project");
			display(conn.rs);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void SearchProject(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Project ID to search :");
		emp.setId(sc.nextInt());
		int i = 0;
		try {
			conn.rs = conn.stmt.executeQuery("select * from project");
			while (conn.rs.next()) {
				if (emp.getId() == conn.rs.getInt(1)) {
					this.show(conn.rs);
					i++;
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (i == 0) {
			System.out.println("\nProject Details are not available, Please enter a valid ID!!");
		}
	}

	@Override
	public void EditProject(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		System.out.println("\nEnter the Project ID to EDIT the details");
		emp.setId(sc.nextInt());
		int j = 0;
		try {
			conn.rs = conn.stmt.executeQuery("select * from project");
			while (conn.rs.next()) {
				if (emp.getId() == conn.rs.getInt(1)) {
					j++;
					do {
						int ch1 = 0;
						System.out.println("\nEDIT Project Details :\n" + "1). Project ID\n" + "2). Project Name\n"
								+ "3). Total Investment\n" + "4). Leader Name.\n" + "5). GO BACK\n");
						System.out.println("Enter your choice : ");
						ch1 = sc.nextInt();
						switch (ch1) {
						case 1:
							System.out.println("\nEnter new Project ID:");
							int new_id = sc.nextInt();
							conn.stmt.executeUpdate("update project set id = " + new_id + " where id = " + emp.getId());
							conn.rs = conn.stmt.executeQuery("select * from project where id = " + new_id);
							this.show(conn.rs);
							break;

						case 2:
							System.out.println("Enter new Project Name:");
							String new_name = sc.next();
							conn.stmt.executeUpdate(
									"update project set name = '" + new_name + "' where id = " + emp.getId());
							// show(conn.rs);
							break;

						case 3:
							System.out.println("Enter new Project Total Investment:");
							float new_totalInvestment = sc.nextFloat();
							conn.stmt.executeUpdate("update project set totalInvestment = " + new_totalInvestment
									+ " where id = " + emp.getId());
							// show(conn.rs);
							break;

						case 4:
							System.out.println("Enter new Project Leader Name. :");
							long new_name_leader = sc.nextLong();
							conn.stmt.executeUpdate("update project set name_leader = " + new_name_leader
									+ " where id = " + emp.getId());
							// show(conn.rs);
							break;

						case 5:
							j++;
							break;

						default:
							System.out.println("\nEnter a correct choice from the List :");
							break;

						}
					} while (j == 0);
				}
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		if (j == 0) {
			System.out.println("\nProject Details are not available, Please enter a valid ID!!");
		}

	}

	@Override
	public void DeleteProject(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		System.out.println("\nEnter Project ID to DELETE from the Databse :");
		emp.setId(sc.nextInt());
		int k = 0;
		try {
			conn.rs = conn.stmt.executeQuery("select * from project");
			while (conn.rs.next()) {
				if (emp.getId() == conn.rs.getInt(1)) {
					conn.stmt.executeUpdate("delete from project where id = " + emp.getId());
					System.out.println("Deleted from the DATABASE successfully!!\n\n");
					// display(conn.rs);
					k++;
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();

		}
		if (k == 0) {
			System.out.println("\nProject Details are not available, Please enter a valid ID!!");
		}
	}

	@Override
	public void DisplayAllProjects(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		try {
			conn.rs = conn.stmt.executeQuery("select * from project");
			this.display(conn.rs);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void DisplaySrotInvestment(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		
	}

}
