package com.advance.blog.service;

import com.advance.blog.dao.BlogMemoryDao;

public class BlogService {

	/*
	 * when create remove default constructor by JVM
	 * */
	private BlogMemoryDao dao;
	
	public BlogService(BlogMemoryDao blogMemoryDao) {
		// TODO Auto-generated constructor stub
		super();
		this.dao = blogMemoryDao;
	}

	public BlogService() {}

}
