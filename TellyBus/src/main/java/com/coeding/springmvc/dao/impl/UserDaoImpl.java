package com.coeding.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coeding.springmvc.dao.UserDao;
import com.coeding.springmvc.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		logger.info("Welcome UserDaoImpl! {}.");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		logger.info("Welcome UserDaoImpl! {}.");
		return session().createQuery("from User").list();
	}
}
