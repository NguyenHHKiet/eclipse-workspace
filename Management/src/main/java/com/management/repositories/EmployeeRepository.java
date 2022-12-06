package com.management.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.management.ConnectionSQL;
import com.management.entity.Employee;
import com.management.entity.Relative;
import com.management.repositories.repositoryInterface.EmployeeRepositoryInterface;

public class EmployeeRepository implements EmployeeRepositoryInterface {

	Employee emp = new Employee(0, null, 0, 0, null, 0, 0);
	Relative rel = new Relative();
	// The Scanner class is used to get user input, and it is found in the java.util
	// package.
	// To use the Scanner class, create an object of the class and use any ...
	Scanner sc = new Scanner(System.in);

	@Override
	public void display(ResultSet rs) {
		// TODO Auto-generated method stub
		System.out.println("\n--------------Employee List---------------\n");
		System.out.println(String.format("%-10s%-20s%-20s%-20s%-25s%-30s%-10s%-10s", "ID", "Name", "Salary",
				"Contact-no", "Email-Id", "Totol-SalaryBonus", "Year Old", "Department-Id"));
		try {
			while (rs.next()) {
				System.out.println(String.format("%-10s%-20s%-20s%-20s%-25s%-30s%-10s%-10s", rs.getObject(1).toString(),
						rs.getObject(2).toString(), rs.getObject(3).toString(), rs.getObject(4).toString(),
						rs.getObject(5).toString(), rs.getObject(6).toString(), rs.getObject(7).toString(),
						rs.getObject(8).toString()));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void show(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			System.out.println("\nEmployee Details :" + "\nID: " + rs.getObject(1).toString() + "\nName: "
					+ rs.getObject(2).toString() + "\nSalary: " + rs.getObject(3).toString() + "\nContact No: "
					+ rs.getObject(4).toString() + "\nEmail-id: " + rs.getObject(5).toString() + "\nTotol-SalaryBonus:"
					+ rs.getObject(6).toString() + "\nYear Old: " + rs.getObject(7).toString() + "\nDepartment-Id :"
					+ rs.getObject(8).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void AddEmployee(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		try {
			conn.prestatement = conn.connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?)");
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		System.out.println("\nEnter the following details to ADD list:\n");
		System.out.println("Enter ID :");
		emp.setId(sc.nextInt());
		System.out.println("Enter Name :");
		emp.setName(sc.next());
		System.out.println("Enter Salary :");
		emp.setSalary(sc.nextFloat());
		System.out.println("Enter Contact No :");
		emp.setContact_no(sc.nextLong());
		System.out.println("Enter Email-ID :");
		emp.setEmail_id(sc.next());
		emp.setTotolSalaryBonus(emp.getSalary());
		System.out.println("Enter year old :");
		emp.setDateOfBirth(sc.nextInt());
		System.out.println("Enter Department-Id own :");
		emp.setDepartment_id(sc.nextInt());
		try {
			conn.prestatement.setInt(1, emp.getId());
			conn.prestatement.setString(2, emp.getName());
			conn.prestatement.setFloat(3, emp.getSalary());
			conn.prestatement.setLong(4, emp.getContact_no());
			conn.prestatement.setString(5, emp.getEmail_id());
			conn.prestatement.setFloat(6, emp.getTotolSalaryBonus());
			conn.prestatement.setInt(7, emp.getDateOfBirth());
			conn.prestatement.setInt(8, emp.getDepartment_id());
			conn.prestatement.executeUpdate();
			// In this sample, connect to SQL Database, execute a SELECT statement, and
			// return selected rows.
			conn.rs = conn.stmt.executeQuery("select * from employee");
			display(conn.rs);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void SearchEmployee(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Employee ID to search :");
		emp.setId(sc.nextInt());
		int i = 0;
		try {
			conn.rs = conn.stmt.executeQuery("select * from employee");
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
			System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
		}
	}

	@Override
	public void EditEmployee(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		System.out.println("\nEnter the Employee ID to EDIT the details");
		emp.setId(sc.nextInt());
		int j = 0;
		try {
			conn.rs = conn.stmt.executeQuery("select * from employee");
			while (conn.rs.next()) {
				if (emp.getId() == conn.rs.getInt(1)) {
					j++;
					do {
						int ch1 = 0;
						System.out.println("\nEDIT Employee Details :\n" + "1). Employee ID\n" + "2). Name\n"
								+ "3). Salary\n" + "4). Contact No.\n" + "5). Email-ID\n" + "6). GO BACK\n");
						System.out.println("Enter your choice : ");
						ch1 = sc.nextInt();
						switch (ch1) {
						case 1:
							System.out.println("\nEnter new Employee ID:");
							int new_id = sc.nextInt();
							conn.stmt
									.executeUpdate("update employee set id = " + new_id + " where id = " + emp.getId());
							conn.rs = conn.stmt.executeQuery("select * from employee where id = " + new_id);
							this.show(conn.rs);
							break;

						case 2:
							System.out.println("Enter new Employee Name:");
							String new_name = sc.next();
							conn.stmt.executeUpdate(
									"update employee set name = '" + new_name + "' where id = " + emp.getId());
							// show(conn.rs);
							break;

						case 3:
							System.out.println("Enter new Employee Salary:");
							float new_salary = sc.nextFloat();
							conn.stmt.executeUpdate(
									"update employee set salary = " + new_salary + " where id = " + emp.getId());
							conn.rs = conn.stmt.executeQuery(
									"SELECT sum(bonus) as sum_bonus, salary FROM orderproject, employee \r\n"
											+ "where orderproject.employee_id = employee.id and employee_id="
											+ emp.getId());
							// Before start of result set
							if (conn.rs.next()) {
								conn.stmt.executeUpdate("UPDATE employee SET totolSalaryBonus = "
										+ (conn.rs.getInt("sum_bonus") + conn.rs.getInt("salary")) + " where id ="
										+ emp.getId());
							}
							// show(conn.rs);
							break;

						case 4:
							System.out.println("Enter new Employee Contact No. :");
							long new_contact = sc.nextLong();
							conn.stmt.executeUpdate(
									"update employee set contact_no = " + new_contact + " where id = " + emp.getId());
							// show(conn.rs);
							break;

						case 5:
							System.out.println("Enter new Employee Email-ID :");
							String new_email = sc.next();
							conn.stmt.executeUpdate(
									"update employee set email_id = '" + new_email + "' where id = " + emp.getId());
							// show(conn.rs);
							break;

						case 6:
							j++;
							break;

						default:
							System.out.println("\nEnter a correct choice from the List :");
							break;

						}
					} while (j == 0);
				}
			}
		} catch (

		SQLException e1) {
			e1.printStackTrace();
		}
		if (j == 0) {
			System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
		}

	}

	@Override
	public void DeleteEmployee(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		System.out.println("\nEnter Employee ID to DELETE from the Databse :");
		emp.setId(sc.nextInt());
		int k = 0;
		try {
			conn.rs = conn.stmt.executeQuery("select * from employee");
			while (conn.rs.next()) {
				if (emp.getId() == conn.rs.getInt(1)) {
					conn.stmt.executeUpdate("delete from employee where id = " + emp.getId());
					System.out.println("Deleted from the DATABASE successfully!!\n\n");
					// display(conn.rs);
					k++;
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();

		}
		if (k == 0) {
			System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
		}
	}

	@Override
	public void DisplayAllEmployees(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		try {
			conn.rs = conn.stmt.executeQuery("select * from employee");
			this.display(conn.rs);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void displayRelative(ResultSet rs) {
		// TODO Auto-generated method stub
		System.out.println("\n--------------Relative List---------------\n");
		System.out.println(String.format("%-10s%-20s%-10s%-10s", "ID", "Name", "Contact-no", "Employee-Id"));
		try {
			while (rs.next()) {
				System.out.println(String.format("%-10s%-20s%-10s%-10s", rs.getObject(1).toString(),
						rs.getObject(2).toString(), rs.getObject(3).toString(), rs.getObject(4).toString()));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void AddRelative(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		try {
			conn.prestatement = conn.connection.prepareStatement("insert into relative values(?,?,?,?)");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("\nEnter the following details to ADD list:\n");
		System.out.println("Enter ID :");
		rel.setId(sc.nextInt());
		System.out.println("Enter Name :");
		rel.setName(sc.next());
		System.out.println("Enter Contact No :");
		rel.setPhone(sc.next());
		System.out.println("Enter Employee-ID :");
		rel.setEmployee_id(sc.nextInt());
		try {
			conn.prestatement.setInt(1, rel.getId());
			conn.prestatement.setString(2, rel.getName());
			conn.prestatement.setString(3, rel.getPhone());
			conn.prestatement.setInt(4, rel.getEmployee_id());
			conn.prestatement.executeUpdate();
			// In this sample, connect to SQL Database, execute a SELECT statement, and
			// return selected rows.
			conn.rs = conn.stmt.executeQuery("select * from relative");
			displayRelative(conn.rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void SearchEmployeeBaseName(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Employee' Name to search :");
		emp.setName(sc.next());
		int i = 0;
		try {
			conn.rs = conn.stmt.executeQuery("select * from employee");
			while (conn.rs.next()) {
				if (emp.getName().equals(conn.rs.getString(2))) {
					this.show(conn.rs);
					i++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 0) {
			System.out.println("\nEmployee Details are not available, Please enter a valid !!");
		}
	}

	@Override
	public void SearchEmployeeBaseBirth(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Employee's Birth(year old) to search :");
		emp.setDateOfBirth(sc.nextInt());
		int i = 0;
		try {
			conn.rs = conn.stmt.executeQuery("select * from employee");
			while (conn.rs.next()) {
				if (emp.getDateOfBirth() == conn.rs.getInt(7)) {
					this.show(conn.rs);
					i++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 0) {
			System.out.println("\nEmployee Details are not available, Please enter a valid !!");
		}
	}

	@Override
	public void SearchEmployeeBaseDepartment(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Employee's Department-Id to search :");
		emp.setDepartment_id(sc.nextInt());
		int i = 0;
		try {
			conn.rs = conn.stmt.executeQuery("select * from employee");
			while (conn.rs.next()) {
				if (emp.getDepartment_id() == conn.rs.getInt(8)) {
					this.show(conn.rs);
					i++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 0) {
			System.out.println("\nEmployee Details are not available, Please enter a valid !!");
		}
	}

	@Override
	public void SearchFromToYearOld(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Employee's Year Old From :");
		int from = sc.nextInt();
		System.out.println("Enter the Employee's Year Old To :");
		int to = sc.nextInt();
		int i = 0;

		System.out.println("\n--------------Employee List---------------\n");
		System.out.println(String.format("%-10s%-20s%-20s%-20s%-25s%-30s%-10s%-10s", "ID", "Name", "Salary",
				"Contact-no", "Email-Id", "Totol-SalaryBonus", "Year Old", "Department-Id"));
		try {
			conn.rs = conn.stmt.executeQuery("select * from employee");
			while (conn.rs.next()) {
				if (from <= conn.rs.getInt(7) && to >= conn.rs.getInt(7)) {
					System.out.println(String.format("%-10s%-20s%-20s%-20s%-25s%-30s%-10s%-10s",
							conn.rs.getObject(1).toString(), conn.rs.getObject(2).toString(),
							conn.rs.getObject(3).toString(), conn.rs.getObject(4).toString(),
							conn.rs.getObject(5).toString(), conn.rs.getObject(6).toString(),
							conn.rs.getObject(7).toString(), conn.rs.getObject(8).toString()));
					i++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 0) {
			System.out.println("\nEmployee Details are not available, Please enter a valid !!");
		}
	}

	@Override
	public void DisplayRelativeBaseEmployee(ConnectionSQL conn) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Employee's Id :");
		emp.setId(sc.nextInt());
		int i = 0;

		System.out.println("\n--------------Relative List---------------\n");
		System.out.println(String.format("%-10s%-20s%-10s", "ID", "Name", "Phone"));
		try {
			conn.rs = conn.stmt.executeQuery("select * from relative");
			while (conn.rs.next()) {
				if (emp.getId() == conn.rs.getInt(4)) {
					System.out.println(String.format("%-10s%-20s%-10s", conn.rs.getObject(1).toString(),
							conn.rs.getObject(2).toString(), conn.rs.getObject(3).toString()));
					i++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 0) {
			System.out.println("\nEmployee Details are not available, Please enter a valid !!");
		}
	}

}
