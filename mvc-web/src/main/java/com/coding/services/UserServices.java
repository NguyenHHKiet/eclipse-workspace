package com.coding.services;

import java.util.List;

public interface UserServices<T> {

	List<T> findAllUser();
	T findIdUser(int id);
	int insertUser(T arg);
	int updateUser(T arg);
	int deleteUser(int id);
	
}
