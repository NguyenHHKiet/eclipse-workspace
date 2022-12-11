package com.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionSQL {
	// Connection interface. A Connection is a session between a Java application
	// and a database.
	// It helps to establish a connection with the database.
	public Connection connection; // Use the connection class to connect to SQL Database.
	/*
	 * The Statement interface provides methods to execute queries with the
	 * database. The statement interface is a factory of ResultSet i.e. it provides
	 * factory method to get the object of ResultSet.
	 * 
	 * 1) public ResultSet executeQuery(String sql): is used to execute SELECT
	 * query. It returns the object of ResultSet. 2) public int executeUpdate(String
	 * sql): is used to execute specified query, it may be create, drop, insert,
	 * update, delete etc. 3) public boolean execute(String sql): is used to execute
	 * queries that may return multiple results. 4) public int[] executeBatch(): is
	 * used to execute batch of commands.
	 */
	public Statement stmt;
	/*
	 * public interface PreparedStatement extends Statement. An object that
	 * represents a precompiled SQL statement. A SQL statement is precompiled and
	 * stored in a PreparedStatement object. This object can then be used to
	 * efficiently execute this statement multiple times.
	 */
	public PreparedStatement prestatement;
	/*
	 * ResultSet interface. The object of ResultSet maintains a cursor pointing to a
	 * row of a table. Initially, cursor points to before the first row.
	 */
	public ResultSet rs;

	public void SQl() {

		try {
			System.out.println("Loading driver...");
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Connect to your database.
			// Replace server name, username, and password with your credentials
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "");
			// connection.prepareStatement("create table employee(id int,name
			// varchar(25),salary float(7,2),contact_no bigint(11),email_id varchar(25)) if
			// not exists");

			// Create and execute a Update SQL statement.
			stmt = connection.createStatement();
			stmt.executeUpdate(
					"create table if not exists department(id int not null,name varchar(25) not null,PRIMARY KEY(id))");

			stmt.executeUpdate(
					"create table if not exists employee(id int not null,name varchar(25) not null,salary float(10,3) default '0',contact_no bigint(11) not null,email_id varchar(25) not null,totolSalaryBonus float(20,3) default '0',dateOfBirth int not null,department_id int not null,PRIMARY KEY(id)"
							+ ",FOREIGN KEY(department_id) REFERENCES department(id))");

			stmt.executeUpdate(
					"create table if not exists project(id int not null,name varchar(25) not null,totalInvestment float(20,3) default '0',name_leader varchar(25) not null,count int default '10',PRIMARY KEY(id ) )");

			stmt.executeUpdate(
					"create table if not exists orderProject(id int not null,bonus float(10,3) default '0',employee_id int not null,project_id int not null, PRIMARY KEY(id )"
							+ ",FOREIGN KEY(employee_id) REFERENCES employee(id)"
							+ ",FOREIGN KEY(project_id) REFERENCES project(id))");
			stmt.executeUpdate(
					"create table if not exists relative(id int not null,nameRelative varchar(25) not null, phone varchar(25),employee_id int not null, PRIMARY KEY(id )"
							+ ",FOREIGN KEY(employee_id) REFERENCES employee(id))");

			System.out.println("Database connected!");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
