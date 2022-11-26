package com.coeding.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.dao.UserDao;
import com.coeding.springmvc.entity.User;
import com.coeding.springmvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		this.userDao.create(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return this.userDao.getAllUsers();
	}

}
