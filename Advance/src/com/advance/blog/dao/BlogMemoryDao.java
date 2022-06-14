package com.advance.blog.dao;

import java.util.ArrayList;
import java.util.List;

import com.advance.blog.entity.BlogCategory;
import com.advance.blog.entity.BlogPost;

/**
 * data store in memory
 * DAO has method
 * Create : new data store					data object
 * Read (Retrieve) : get data, view, search	select by keyword
 * Update : change data value				data object has id
 * Delete : remove data						id
 * 
 * @version 
 * @author NguyenHHKiet
 * 
 * */

public class BlogMemoryDao {

	private List<BlogPost> postRepo;
	private List<BlogCategory> cateRepo;
	
	public BlogMemoryDao() {
		// TODO Auto-generated constructor stub
		super();
		postRepo = new ArrayList<BlogPost>();
		cateRepo = new ArrayList<BlogCategory>();
	}
	
}
