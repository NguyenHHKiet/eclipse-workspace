package com.coding.services;

import java.util.List;

import com.coding.dao.BlogUserDao;
import com.coding.entity.BlogUser;

public class BlogWebServices {
	
	private BlogUserDao userdao;
	
	public BlogWebServices() {
		super();
		userdao = new BlogUserDao();
	}

	//goi tu dao cho servlet
	public void addUser(BlogUser user) {
		if (user != null) {
			if (!user.getName().isEmpty() | !user.getEmail().isEmpty()) {
				System.out.println("Create New Account..!");
				userdao.insert(user);
			}
		}
	}
	public List<BlogUser> viewUser() {
		return userdao.findAll();
	}
	public boolean loginUser(BlogUser user) {
		if (user != null) {
			userdao.login(user);
			System.out.println("Login Successful..!!");
			return true;
		}else {
			System.out.println("Login Fail..!!");
		}
		return false;
	}
}
