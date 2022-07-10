package com.theplayer.kits.foodboys.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.theplayer.kits.foodboys.vo.Player;
//_______________________________________________________________________
//author: 
// - Long, Phuong: private static SqlSessionFactory getSqlSessionFactory()
// - Phuong      : public Player searchPlayer(String name)
// - Long        : left
//_______________________________________________________________________

@Repository
public class PlayerDAO implements FootballDAO<Player>{
	private static SqlSessionFactory sqlFactory;
	
	// Long, Phuong
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
	
	
	//Long
	@Override
	public List<Player> selectList() {
		SqlSession session = sqlFactory.openSession();
		return session.selectList("foodboys.player.selectList");
	}
	
	
//	@Override
//	public List<Player> selectList() {
//		SqlSession session = sqlFactory.openSession();
//		return session.selectList("foodboys.player.selectList");
//	}

	@Override
	public int insert(Player arg) {
		// TODO Auto-generated method stub
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.insert("foodboys.player.insert", arg); //query
		session.commit();
		return 0;
	}

	@Override
	public int delete(Player arg) {
		arg.setPlayer_status(false);
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.update("foodboys.player.update", arg);
		session.commit();
		return 0;
	}

	@Override
	public Player selectOne() {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (Player) session.selectOne("foodboys.player.selectOne");
	}

	@Override
	public int update(Player arg) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.update("foodboys.player.update", arg);
		session.commit();
		return 0;
	}

	@Override
	public Player find(Player arg) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Player findPlayerName(String player_name) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (Player) session.selectOne("foodboys.player.selectOne", player_name);
	}

	
	//--------------------------------------------------------------------
	//author: Nam Phuong
	public Player searchPlayer(String name) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (Player) session.selectOne("foodboys.player.search",name);
	}


	public List<Player> showPlayer() {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		
		return session.selectList("foodboys.player.selectList");
	}
	
//	public int updateImages(Player arg) {
//		sqlFactory = getSqlSessionFactory();
//		SqlSession session = sqlFactory.openSession();
//		session.update("foodboys.player.update", arg);
//		session.commit();
//		return 0;
//	}
}
