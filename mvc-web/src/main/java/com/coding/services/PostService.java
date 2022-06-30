package com.coding.services;

import java.util.List;
import java.util.Map;

import com.coding.dao.BlogPostDao;
import com.coding.entity.BlogPost;


public class PostService {
	private BlogPostDao postdao;
	
	public PostService() {
		this.postdao = new BlogPostDao();
	}
	public List<BlogPost> getPosts() {
		return postdao.findAll();
	}

	public void addPost(Map<String, Object> model) {
		BlogPost post = new BlogPost();
		post.setTitle((String)model.get("title"));
		post.setArticle((String)model.get("article"));
		post.setAuthorId(Integer.parseInt((String)model.get("author_id")));
		postdao.insert(post);
	}

}
