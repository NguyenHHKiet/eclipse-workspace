package com.advance.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/blog";
		String user = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			String sql = "insert into blog_user (name, email) values ('hoangkiet', 'hk@hk.com')";
			
			Statement stmt = conn.createStatement();
			
			boolean result = stmt.execute(sql);
			
			System.out.println(result);
			
			stmt.close();
			conn.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
