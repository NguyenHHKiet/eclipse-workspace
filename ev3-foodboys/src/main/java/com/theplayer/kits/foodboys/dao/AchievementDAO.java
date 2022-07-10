package com.theplayer.kits.foodboys.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.theplayer.kits.foodboys.vo.Achievement;
//author: Hung
public class AchievementDAO implements FootballDAO<Achievement> {
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
	public List<Achievement> selectList() {
		SqlSession session = sqlFactory.openSession();
		return session.selectList("foodboys.achievement.selectList");
	}

	@Override
	public int insert(Achievement arg) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.insert("foodboys.achievement.insert", arg);
		session.commit();
		return 0;
	}

	@Override
	public int delete(Achievement arg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Achievement selectOne() {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (Achievement) session.selectOne("foodboys.achievement.selectOne");
	}

	@Override
	public int update(Achievement arg) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.update("foodboys.achievement.update", arg);
		session.commit();
		return 0;
	}

	@Override
	public Achievement find(Achievement arg) {
		// TODO Auto-generated method stub
		return null;
	}


}
