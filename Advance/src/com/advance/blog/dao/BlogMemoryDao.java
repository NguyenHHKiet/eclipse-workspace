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

	public void save(BlogPost arg) {
		// TODO Auto-generated method stub
		//update post
		if(arg.getId() != null) {
			for (BlogPost po : postRepo) {
				if(po.getId().intValue() == arg.getId().intValue()) {
					po.CopyData(arg);
				}
			}
		}else {
			arg.setId(postRepo.size() + 1);
			postRepo.add(arg);
		}
		
		//create new id
		
	}

	public BlogPost findLastPost() {
		// TODO Auto-generated method stub
		return (postRepo.size() == 0 ? null :postRepo.get(postRepo.size() - 1)) ;
	}

	public List<BlogPost> findListPostByString(String key) {
		// TODO Auto-generated method stub
		
		List<BlogPost> list = new ArrayList<BlogPost>();
		
		for (BlogPost post : postRepo) {
			if(post != null) {
				post.getTitle().contains(key);
				post.getArticle().contains(key);
			}
			list.add(post);
		}
			
		
		return list;
	}

	public BlogPost findPostById(Integer id) {
		// TODO Auto-generated method stub
		
		for (BlogPost post : postRepo) {
			if(post.getId().intValue() == id.intValue()) {
				return post;
			}
		}
		
		return null;
	}

	
	public List<BlogPost> findPostAll() {
		// TODO Auto-generated method stub
		return postRepo;
	}

	public void deletePost(Integer id) {
		// TODO Auto-generated method stub
		BlogPost del = null;
		for (BlogPost post : postRepo) {
			if(post.getId().intValue() == id.intValue()) {
				del = post;
				break;
			}
		}
		postRepo.remove(del);
	}
	
	
	
}
