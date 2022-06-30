package com.coding.dao;

import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.coding.entity.BlogUser;

public class BlogUserDao implements BlogDao<BlogUser>{

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
	public BlogUser findOne(int id) {
		// TODO Auto-generated method stub
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (BlogUser) session.selectOne("blog.user.findId", id);
	}

	@Override
	public List<BlogUser> findAll() {
		// TODO Auto-generated method stub
		//data source
		sqlFactory = getSqlSessionFactory();
		//data source . get Connection
		SqlSession session = sqlFactory.openSession();
		List<BlogUser> list = session.selectList("blog.user.findAll");
		return list;
	}

	@Override
	public List<BlogUser> find(BlogUser arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BlogUser arg) {
		// TODO Auto-generated method stub
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.insert("blog.user.insertUser", arg);
		session.commit();
		return 0;
	}

	@Override
	public void update(BlogUser arg) {
		// TODO Auto-generated method stub
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.insert("blog.user.updateUser", arg);
		session.commit();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.insert("blog.user.deleteUser", id);
		session.commit();
	}
	
	public BlogUser findRecent() {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (BlogUser) session.selectOne("blog.user.recentOne");
	}

	public boolean login(BlogUser user) {
		// TODO Auto-generated method stub
		return false;
	}
}
