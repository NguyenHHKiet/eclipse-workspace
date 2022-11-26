package com.coeding.springmvc.service;

import java.util.List;

import com.coeding.springmvc.entity.User;

public interface UserService {

	void create(User user);

	List<User> getAllUsers();
}
