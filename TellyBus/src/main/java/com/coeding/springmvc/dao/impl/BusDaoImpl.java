package com.coeding.springmvc.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coeding.springmvc.dao.BusDao;
import com.coeding.springmvc.entity.Bus;

@Repository
@Transactional
public class BusDaoImpl implements BusDao {
	
	private static final Logger logger = LoggerFactory.getLogger(BusDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	@Transactional
	public void create(Bus bus) {
		// TODO Auto-generated method stub
		logger.info("Welcome BusDaoImpl! {}.");
		session().save(bus);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Bus> getAllUsers() {
		// TODO Auto-generated method stub
		logger.info("Welcome BusDaoImpl! {}.");
		return session().createQuery("from Bus").list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Bus> getCity(String leaveFrom, String goingTo, Date dateLeave, Date dateReturn) {
		// TODO Auto-generated method stub
		logger.info("Welcome BusDaoImpl! {}.");
		return (List<Bus>) session()
				.createQuery("from Bus where leaveFrom=:leaveFrom and goingTo=:goingTo and dateLeave=:dateLeave "
						+ "and dateReturn=:dateReturn")
		.setParameter("leaveFrom", leaveFrom)
		.setParameter("goingTo", goingTo)
		.setParameter("dateLeave", dateLeave)
		.setParameter("dateReturn", dateReturn);

	}

}
