package com.coding.services;

import java.util.List;

import com.coding.dao.BlogAuthorDao;
import com.coding.dao.BlogPostDao;
import com.coding.dao.BlogTagDao;
import com.coding.dao.BlogUserDao;
import com.coding.entity.BlogAuthor;
import com.coding.entity.BlogPost;
import com.coding.entity.BlogTag;
import com.coding.entity.BlogUser;


public class BlogWebServices {
	
	private BlogUserDao userdao;
	private BlogAuthorDao authordao;
	private BlogPostDao postdao;
	private BlogTagDao tagdao;
	
	public BlogWebServices() {
		super();
		userdao = new BlogUserDao();
		authordao = new BlogAuthorDao();
		postdao = new BlogPostDao();
		tagdao = new BlogTagDao();
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
		if (userdao.login(user)) {
			System.out.println("Login Successful..!!");
			return true;
		}else {
			System.out.println("Login Fail..!!");
		}
		return false;
	}
	
	public void addTag(BlogTag tag) {
		tagdao.insert(tag);
	}
	public BlogPost getPost(int pid) {
//		PageDTO admin;
//			BlogPost post;
//			join
//			BlogUser user;
//			join
//			BlogTag tag;
		return null;
	}
	
	public BlogAuthor getBlogAuthor(int id) {
		BlogAuthor auditor = authordao.findOne(id);
		return auditor;
	}
	public BlogPost getRecentPost() {
		return postdao.findRecent();
	}

	public String getAuthorName(Integer authorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getTagsBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
