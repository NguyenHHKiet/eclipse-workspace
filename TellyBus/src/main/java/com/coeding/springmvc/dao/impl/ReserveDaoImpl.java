package com.coeding.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coeding.springmvc.dao.ReserveDao;
import com.coeding.springmvc.entity.Reserve;

@Repository
@Transactional
public class ReserveDaoImpl implements ReserveDao {

	private static final Logger logger = LoggerFactory.getLogger(ReserveDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional
	public void reserve(Reserve reserve) {
		// TODO Auto-generated method stub
		logger.info("Welcome ReserveDaoImpl! {}.");
		session().save(reserve);
		
	}

	@Override
	public List<Reserve> getReserve(String username) {
		// TODO Auto-generated method stub
		logger.info("Welcome ReserveDaoImpl! {}.");
		Criteria crit = session().createCriteria(Reserve.class);

		crit.add(Restrictions.eq("user.username", username));

		return crit.list();
		
	}
	
}
