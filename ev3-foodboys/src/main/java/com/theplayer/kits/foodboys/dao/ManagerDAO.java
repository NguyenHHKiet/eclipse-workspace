package com.theplayer.kits.foodboys.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.theplayer.kits.foodboys.vo.Manager;
//author: Hung
public class ManagerDAO implements FootballDAO<Manager>{
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
	public List<Manager> selectList() {
		SqlSession session = sqlFactory.openSession();
		return session.selectList("foodboys.manager.selectList");
	}

	@Override
	public int insert(Manager arg) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.insert("foodboys.manager.insert", arg);
		session.commit();
		return 0;
	}

	@Override
	public int delete(Manager arg) {
		arg.setManager_status(false);
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.update("foodboys.manager.selectOne", arg);
		session.commit();
		return 0;
	}

	@Override
	public Manager selectOne() {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (Manager) session.selectOne("foodboys.manager.selectOne");
	}

	@Override
	public int update(Manager arg) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.update("foodboys.manager.update", arg);
		session.commit();
		return 0;
	}

	@Override
	public Manager find(Manager arg) {
		// TODO Auto-generated method stub
		return null;
	}

	public Manager findManagerName(String manager_name) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (Manager) session.selectOne("foodboys.manager.findManagerName",manager_name);
	}

}
