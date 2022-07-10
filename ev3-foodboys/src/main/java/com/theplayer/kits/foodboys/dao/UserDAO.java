package com.theplayer.kits.foodboys.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.theplayer.kits.foodboys.vo.User;

//author: Hung
@Repository
public class UserDAO implements FootballDAO<User>{
	private static SqlSessionFactory sqlFactory;
	
	private static SqlSessionFactory getSqlSessionFactory() {
		if( sqlFactory == null ) {
			String resource = "mybatis/mybatis-config.xml";
			Reader rd=null;
			try {
				// ctx.lookup
				rd = Resources.getResourceAsReader(resource);
				sqlFactory = new SqlSessionFactoryBuilder().build(rd);
			} catch (IOException e) {
				e.printStackTrace();
			} 
			if(rd!=null) {
				try {
					rd.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sqlFactory;
	}
	@Override
	public List<User> selectList() {
		SqlSession session = sqlFactory.openSession();
		return session.selectList("foodboys.user.selectList");
	}

	@Override
	public int insert(User arg) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.insert("foodboys.user.insert", arg);
		session.commit();
		return 0;
	}

	@Override
	public int delete(User arg) {
		arg.setStatus(false);
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.update("foodboys.user.selectOne", arg);
		session.commit();
		return 0;
	}

	@Override
	public User selectOne() {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (User) session.selectOne("foodboys.user.selectOne");
	}

	@Override
	public int update(User arg) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.update("foodboys.user.update", arg);
		session.commit();
		return 0;
	}

	@Override
	public User find(User arg) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (User) session.selectOne("foodboys.user.selectOne", arg);
	}
	
	public User findUsername(String username) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (User) session.selectOne("foodboys.user.findUsername",username);
	}
	
	public User findAccount(String username, String password) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		User user = new User(username, password);
		return (User) session.selectOne("foodboys.user.findAccount", user);
	}
}
