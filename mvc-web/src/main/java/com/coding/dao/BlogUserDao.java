package com.coding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.coding.entity.BlogUser;

public class BlogUserDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void connect() {
		// TODO Auto-generated method stub
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void closeAll() {
		// TODO Auto-generated method stub
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//		Context ctx = new InitialContext();
//		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
//		Connection con = ds.getConnection();
//		System.out.println(con);
//		
//		//sql : ResultSet (select)
//		// = equals, like contains (%ho endwith, ho% startwith)
//		String sql= "select * from blog_user ";
//		
//		PreparedStatement pstmt = con.prepareStatement(sql);
//		ResultSet rs = pstmt.executeQuery();
//		
//		while (rs.next()) {
//			//row and column
//			BlogUser user = new BlogUser(
//					rs.getInt("user_id"),
//					rs.getString("name"),
//					rs.getString("email")
//					);
//			System.out.println(user);
//		}
//		rs.close();
//		pstmt.close();
//		con.close();

	private Object action(Function<String, Object> action ) {
		// TODO Auto-generated method stub
		connect();
		try {
			return action.apply("apply : ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return null;
	}
	
	public BlogUser findById(int id) {
		// TODO Auto-generated method stub
		
//		Function<String, Object> exe = (s) ->{
//			System.out.println("hi hihi");
//			return null;
//		};
		
		return (BlogUser) action( (s) ->
		{
			System.out.println(s);
			String sql = "select * from blog_user where user_id =?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					BlogUser user = new BlogUser(
							rs.getInt("user_id"),
							rs.getString("name"),
							rs.getString("email")
							);
					return user;//of apply
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});
	}
	
	
}
