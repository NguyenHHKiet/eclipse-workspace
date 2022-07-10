package com.theplayer.kits.foodboys.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.theplayer.kits.foodboys.vo.League;
//author: Phuong
public class LeagueDAO implements FootballDAO<League>{
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
	public List<League> selectList() {
		SqlSession session = sqlFactory.openSession();
		return session.selectList("foodboys.league.selectList");
	}

	@Override
	public int insert(League arg) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.insert("foodboys.league.insert", arg);
		session.commit();
		return 0;
	}

	@Override
	public int delete(League arg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public League selectOne() {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (League) session.selectOne("foodboys.league.selectOne");
	}

	@Override
	public int update(League arg) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.update("foodboys.league.update", arg);
		session.commit();
		return 0;
	}

	@Override
	public League find(League arg) {
		// TODO Auto-generated method stub
		return null;
	}

}
