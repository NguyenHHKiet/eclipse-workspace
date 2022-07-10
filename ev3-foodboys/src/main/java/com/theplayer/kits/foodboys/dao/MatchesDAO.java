package com.theplayer.kits.foodboys.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.theplayer.kits.foodboys.vo.Matches;

//author: Thinh
public class MatchesDAO implements FootballDAO<Matches> {
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
	
	public List<Matches> showMatches() {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		
		return session.selectList("foodboys.matches.selectList");
	}
	
	@Override
	public List<Matches> selectList() {
		SqlSession session = sqlFactory.openSession();
		return session.selectList("foodboys.matches.selectList");
	}

	@Override
	public int insert(Matches arg) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.insert("foodboys.matches.insert", arg);
		session.commit();
		return 0;
	}

	@Override
	public int delete(Matches arg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Matches selectOne() {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (Matches) session.selectOne("foodboys.matches.selectOne");
	}

	@Override
	public int update(Matches arg) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.update("foodboys.matches.update", arg);
		session.commit();
		return 0;
	}

	@Override
	public Matches find(Matches arg) {
		// TODO Auto-generated method stub
		return null;
	}

}
