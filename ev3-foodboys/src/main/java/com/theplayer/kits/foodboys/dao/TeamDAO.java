package com.theplayer.kits.foodboys.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.theplayer.kits.foodboys.vo.Team;

	//author : Phuong
	
@Repository
public class TeamDAO implements FootballDAO<Team> {
	
	private static SqlSessionFactory sqlFactory;
	
	//author: Hung, Phuong
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

	//author: Hung
	@Override
	public List<Team> selectList() {
		SqlSession session = sqlFactory.openSession();
		return session.selectList("foodboys.team.selectList");
	}
	
	
	@Override
	public int insert(Team arg) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.insert("foodboys.team.insert", arg);
		session.commit();
		return 0;
	}

	@Override
	public int delete(Team arg) {
		arg.setTeam_status(false);
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.update("foodboys.team.update", arg);
		session.commit();
		return 0;
	}

	@Override
	public Team selectOne() {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (Team) session.selectOne("foodboys.team.selectOne");
	}

	@Override
	public int update(Team arg) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.update("foodboys.team.update", arg);
		session.commit();
		return 0;
	}

	@Override
	public Team find(Team arg) {
		return null;
	}

	public Team findTeamName(String team_name) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (Team) session.selectOne("foodboys.team.selectOne", team_name);
	}

	public List<Team> showTeam() {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		
		return session.selectList("foodboys.team.showList");
	}
	
}
