package com.management;

import java.util.Scanner;

import com.management.entity.Employee;
import com.management.entity.Project;
import com.management.repositories.DepartmentRepository;
import com.management.repositories.EmployeeRepository;
import com.management.repositories.OrderProjectRepository;
import com.management.repositories.ProjectRepository;

public class Main {

	public static void main(String[] args) {
		ConnectionSQL conn = new ConnectionSQL();
		EmployeeRepository repoEmp = new EmployeeRepository();
		ProjectRepository repoPro = new ProjectRepository();
		OrderProjectRepository repoOrder = new OrderProjectRepository();
		DepartmentRepository repoDep = new DepartmentRepository();
		Scanner sc = new Scanner(System.in);
		
		Project pr1 = new Project(5, "OPP", 15000, "HK", 10);
		Employee emp1 = new Employee(5, "ASV", 200, 0164, "mail.com", 5000, 22);
		Employee emp2 = new Employee(5, "ASV", 200, 0164, "mail.com", 5000, 22);
		
		System.out.println(pr1.getName());
		System.out.println(emp1.getName());
		System.out.println(emp2.getName());
		
		conn.SQl();
		do {
			System.out.println("\n*********Welcome to the Management System**********\n");
			System.out.println("1). Employee Management to Database\n" + "2). Project Management for Employee\n"
					+ "3). State Management Details\n" + "4). Search Employees(name, birth, and department)\n"
					+ "5). Search base over year old\n" + "6). Display relative of employee\n" + "7). Department\n"
					+ "8). EXIT\n");
			System.out.println("Enter your choice : ");
			int bg = sc.nextInt();
			switch (bg) {
			case 1:
				System.out.println("1). Add Employee to the DataBase\n" + "2). Search for Employee\n"
						+ "3). Edit Employee details\n" + "4). Delete Employee Details\n"
						+ "5). Display all Employees working in this company\n" + "6). Add relative\n" + "7). Go Back\n"
						+ "8). EXIT\n");
				System.out.println("Enter your choice : ");
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					repoEmp.add(conn);
					break;
				case 2:
					repoEmp.search(conn);
					break;
				case 3:
					repoEmp.edit(conn);
					break;
				case 4:
					repoEmp.delete(conn);
					break;
				case 5:
					repoEmp.displayAll(conn);
					break;
				case 6:
					repoEmp.AddRelative(conn);
					break;
				case 7:
					break;
				case 8:
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("\nEnter a correct choice from the List");
					break;
				}
				break;
			case 2:
				System.out.println(
						"1). Add Project to the DataBase\n" + "2). Search for Project\n" + "3). Edit Project details\n"
								+ "4). Delete Project Details\n" + "5). Display all Project working in this company\n"
								+ "6). Sort Investment(decrease)\n" + "7). Go Back\n" + "8). EXIT\n");
				System.out.println("Enter your choice : ");
				int p = sc.nextInt();

				switch (p) {
				case 1:
					repoPro.add(conn);
					break;
				case 2:
					repoPro.search(conn);
					break;
				case 3:
					repoPro.edit(conn);
					break;
				case 4:
					repoPro.delete(conn);
					break;
				case 5:
					repoPro.displayAll(conn);
					break;
				case 6:
					repoPro.DisplaySrotInvestment(conn);
					break;
				case 7:
					break;
				case 8:
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("\nEnter a correct choice from the List");
					break;
				}
				break;
			case 3:
				System.out.println("1). Setup Project for Employee to the DataBase\n"
						+ "2). Search for List Project of Employee\n" + "3). Search for List Employee in Project\n"
						+ "4). Update Bonus Employee participate project details\n" + "5). Search for OrderProject\n"
						+ "6). Display All OrderProject\n" + "7). EXIT\n");
				System.out.println("Enter your choice : ");
				int as = sc.nextInt();
				switch (as) {
				case 1:
					repoOrder.SetupOrderProject(conn);
					break;
				case 2:
					repoOrder.DisplayAllProject(conn);
					break;
				case 3:
					repoOrder.DisplayAllEmployees(conn);
					break;
				case 4:
					repoOrder.UpdateBonusEmployee(conn);
					break;
				case 5:
					repoOrder.search(conn);
					break;
				case 6:
					repoOrder.displayAll(conn);
					break;
				case 7:
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("\nEnter a correct choice from the List");
					break;
				}
				break;
			case 4:
				System.out.println("1). Search base on Name\n" + "2). Search base on Brith\n"
						+ "3). Search base on Department\n" + "4). Go Back\n");
				System.out.println("Enter your choice : ");
				int se = sc.nextInt();
				switch (se) {
				case 1:
					repoEmp.SearchEmployeeBaseName(conn);
					break;
				case 2:
					repoEmp.SearchEmployeeBaseBirth(conn);
					break;
				case 3:
					repoEmp.SearchEmployeeBaseDepartment(conn);
					break;
				default:
					break;
				}
				break;
			case 5:
				repoEmp.SearchFromToYearOld(conn);
				break;
			case 6:
				repoEmp.DisplayRelativeBaseEmployee(conn);
				break;
			case 7:
				System.out.println("1). Add Department\n" + "2). Display Department\n" + "3). Go Back\n");
				System.out.println("Enter your choice : ");
				int dep = sc.nextInt();
				switch (dep) {
				case 1:
					repoDep.add(conn);
					break;
				case 2:
					repoDep.displayAll(conn);
					break;
				default:
					break;
				}
				break;
			case 8:
				sc.close();
				System.exit(0);
				break;

			default:
				System.out.println("\nEnter a correct choice from the List");
				break;
			}
		} while (true);
	}

}
