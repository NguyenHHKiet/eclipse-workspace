package com.coding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import com.coding.entity.BlogUser;

public class BlogUserDao implements BlogDao<BlogUser>{
	
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
		try {
			connect();
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
	
	
	// view chua show ra toan bo du lieu tren html, nhung method da lay duoc gia tri cua user
	@SuppressWarnings("unchecked")
	public List<BlogUser> findAll() {
		
		return (List<BlogUser>) action( s -> {
			try {				
				pstmt = conn.prepareStatement("select * from blog_user");
				rs = pstmt.executeQuery();
				List<BlogUser> list = new ArrayList<BlogUser>();
				while (rs.next()) {
					BlogUser user = new BlogUser();
					user.setUser_id(rs.getInt("user_id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					list.add(user);
				}
				return list;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}) ;
	}
	
	//create user insert into database complete, nhung chua co bat truong hop name, email trung nhau..
	@Override
	public int insert(BlogUser arg) {
		// TODO Auto-generated method stub
		String sql = "insert into blog_user (name, email) values (?,?)";
		
		return (int) action( s -> {
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, arg.getName());
				pstmt.setString(2, arg.getEmail());
				return pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return 0;
		});
	}
	
	// login chua kiem tra duoc name va email co ton tai o database hay khong?
	public BlogUser login(BlogUser arg) {
		String sql = "select * from blog_user where name=? and email=?";
		
		return (BlogUser) action( s -> {
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, arg.getName());
				pstmt.setString(2, arg.getEmail());
				rs = pstmt.executeQuery();
				BlogUser test = new BlogUser();
				if (rs.next()) {
					
					test.setName(rs.getString("name"));
					test.setEmail(rs.getString("email"));
				}
				return test;
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public BlogUser findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogUser> find(BlogUser arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BlogUser arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
