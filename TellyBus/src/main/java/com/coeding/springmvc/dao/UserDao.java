package com.coeding.springmvc.dao;

import java.util.List;

import com.coeding.springmvc.entity.User;

public interface UserDao {

	void create(User user);

	List<User> getAllUsers();
}
