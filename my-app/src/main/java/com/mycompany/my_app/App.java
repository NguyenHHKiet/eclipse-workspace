package com.mycompany.my_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://192.168.88.84:3306/cutekhoa";
		String user = "kits5";
		String password = "123yo100";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			String sql = "insert into shell (id, name, email) values ('12' ,'hoangkiet', 'hk@hk.com')";
			
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
