package com.coding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.coding.entity.*;

/**
 * @author KITS_007
 *
 */
public class BlogAuthorDao implements BlogDao<BlogAuthor>{
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void connect() {
		// TODO Auto-generated method stub
		
		Context ctx;
		
		try {
			ctx = new InitialContext();
		
			Context env = (Context) ctx.lookup("java:comp/env");
			DataSource ds = (DataSource) env.lookup("jdbc/mysql");
			conn = ds.getConnection();
			
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void closed() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public BlogAuthor findOne(int id) {
		// TODO Auto-generated method stub
		connect();
		try {
			String sql = "select * from blog_author where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			BlogAuthor author = new BlogAuthor();
			while(rs.next()) {
				author.setId(rs.getInt("id"));
				author.setFirstName(rs.getString("first_name"));
				author.setLastName(rs.getString("last_name"));
				author.setDisplayName(rs.getString("display_name"));
			}
			return author;
		}catch(Exception e) {
			
		}finally {
			closed();			
		}
		return null;
	}

	@Override
	public List<BlogAuthor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogAuthor> find(BlogAuthor arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BlogAuthor arg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(BlogAuthor arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
