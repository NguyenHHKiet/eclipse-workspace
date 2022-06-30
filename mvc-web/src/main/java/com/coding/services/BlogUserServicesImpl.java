package com.coding.services;

import java.util.List;

import com.coding.entity.BlogUser;
import com.coding.mappers.UserMapper;

public class BlogUserServicesImpl implements UserServices<BlogUser> {

	private UserMapper usermapper;
	
	@Override
	public List<BlogUser> findAllUser() {
		// TODO Auto-generated method stub
		return usermapper.findAllUser();
	}

	@Override
	public BlogUser findIdUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser(BlogUser arg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(BlogUser arg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
