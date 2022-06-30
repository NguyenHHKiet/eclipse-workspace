package com.coding.dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.coding.entity.*;

public class BlogPostDao implements BlogDao<BlogPost>{
	
	private static SqlSessionFactory sqlFactory;
	
	private static SqlSessionFactory getSqlSessionFactory() {
		if (sqlFactory == null) {
			
			String resources = "mybatis/mybatis-config.xml";
			Reader rd = null;
			
			try {
				
				rd = Resources.getResourceAsReader(resources);
				sqlFactory = new SqlSessionFactoryBuilder().build(rd);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (rd != null) {
				try {
					rd.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
		}
		return sqlFactory;
	}
	@Override
	public BlogPost findOne(int id) {
		// TODO Auto-generated method stub
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (BlogPost) session.selectOne("blog.post.findId", id);
	}

	@Override
	public List<BlogPost> findAll() {
		// TODO Auto-generated method stub
		//data source
		sqlFactory = getSqlSessionFactory();
		//data source . get Connection
		SqlSession session = sqlFactory.openSession();
		List<BlogPost> list = session.selectList("blog.post.selectAll");
		return list;
	}

	@Override
	public List<BlogPost> find(BlogPost arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BlogPost arg) {
		// TODO Auto-generated method stub
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.insert("blog.post.insert", arg);
		session.commit();
		return 0;
	}

	@Override
	public void update(BlogPost arg) {
		// TODO Auto-generated method stub
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.insert("blog.post.update", arg);
		session.commit();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.insert("blog.post.delete", id);
		session.commit();
	}

	public BlogPost findRecent() {
		// TODO Auto-generated method stub
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (BlogPost) session.selectOne("blog.post.recentOne");
	}
	



}
