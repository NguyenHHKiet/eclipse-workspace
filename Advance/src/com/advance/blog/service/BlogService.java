package com.advance.blog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.advance.blog.dao.BlogMemoryDao;
import com.advance.blog.entity.BlogPost;

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

	public Map<String, String> process(String cmd) {
		// TODO Auto-generated method stub
		Map<String, String> model = new HashMap<String, String>();
		model.put("service", this.getClass().getName());
		
		if(!cmd.contains("?")) {
			if(cmd.equals("post/")) {
				recentPostOne(model);
			}else if(cmd.equals("post/list")) {
				getPostAll(model);
			}else if(cmd.equals("category/list")) { //not yet
				getCategoryAll(model);
			}else {
				model.put("404", "Not Found");
			}
//			System.out.println("not contians");//only command
		}else {
			// has query string, regex : * \ ()
			String[] req = cmd.split("\\?");
//			System.out.println(req.length);
			
//			String s1 = "java string split method by viettuts";
//			String[] words = cmd.split("\\s");//tach chuoi dua tren khoang trang
//			//su dung vong lap foreach de in cac element cua mang chuoi thu duoc
//			for (String w : words) {
//				System.out.println(w);
//			}  
			if(req.length ==  2) {
				
				String[] paramenters = req[1].split("&");
				
				for (String elm : paramenters) {
					String[] pair = elm.split("=");
					model.put(pair[0], pair[1]);
				}
				
//				System.out.println(model.get("title") + model.get("article"));
				
				// post
				if (req[0].equals("post/add")) { //post/add?title=das&article=123
					registPost(model);
					
				}
						
				//	fix search
				if (req[0].equals("post/search")) {
					
					List<BlogPost> resultSet1 = getPostByString(model);
//					List<BlogPost> resultSet2 = getPostWithCategory(model);
					
//					model.put("searchdata", resultSet1.toString()+ resultSet2.toString());
					model.put("data search", resultSet1.toString());
				}
				
				
				if (req[0].equals("post/view")) {//post/view?id=1
					getPostById(model);
				}
				
				if (req[0].equals("post/update")) {
					updatePost(model);
				}
				
				if (req[0].equals("post/delete")) {
					deletePost(model);
				}
				
				//category
				if( req[0].equals("category/add") ) {
					registCategory(model);
				}
				if( req[0].equals("category/search") ) {
					getCategoryByString(model);
//					getCategoryWithCategory(model);
				}
				if( req[0].equals("category/view") ) {
					getCategoryById(model);
				}
				if( req[0].equals("category/update") ) {
					updateCategory(model);
				}
				if( req[0].equals("category/delete") ) {
					deleteCategory(model);
				}
			}else {
				// model include req, resp
				model.put("400","Bad Request : need paramter");
				
			}
		}
		
		
		return model;
	}


	private void recentPostOne(Map<String, String> model) {
		// TODO Auto-generated method stub
		BlogPost post = dao.findLastPost();
		if(post == null) {
			model.put("data", "have no post");
		}else {
			model.put("data", post.toString());
		}
		
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void deleteCategory(Map<String, String> model) {
		// TODO Auto-generated method stub
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void updateCategory(Map<String, String> model) {
		// TODO Auto-generated method stub
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void getCategoryByString(Map<String, String> model) {
		// TODO Auto-generated method stub
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void getCategoryWithCategory(Map<String, String> model) {
		// TODO Auto-generated method stub
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void getCategoryById(Map<String, String> model) {
		// TODO Auto-generated method stub
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void getCategoryAll(Map<String, String> model) {
		// TODO Auto-generated method stub
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void registCategory(Map<String, String> model) {
		// TODO Auto-generated method stub
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void deletePost(Map<String, String> model) {
		// TODO Auto-generated method stub
		Integer id = Integer.valueOf(model.get("id"));
		dao.deletePost(id);
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void updatePost(Map<String, String> model) {
		// TODO Auto-generated method stub
		
		BlogPost post = toPost(model);
		dao.save(post);
		
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private BlogPost toPost(Map<String, String> model) {
		// TODO Auto-generated method stub
		if(model.get("id") == null || model.get("title") == null || model.get("article") == null) return null;
		
		BlogPost post = new BlogPost();
		post.setId(Integer.valueOf(model.get("id")));
		post.setTitle(model.get("title"));
		post.setArticle(model.get("article"));
		
		return post;
	}

	private List<BlogPost> getPostByString(Map<String, String> model) {
		// TODO Auto-generated method stub
		String key = model.get("keyword");
//		BlogPost post = new BlogPost();
//
//		post.getTitle().contains(key);
//		post.getArticle().contains(key);
		
		List<BlogPost> list = dao.findListPostByString(key);
		
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
		
		return list;
	}

	private List<BlogPost> getPostWithCategory(Map<String, String> model) {
		// TODO Auto-generated method stub
//		List<BlogPost> list = new ArrayList<BlogPost>();
//		BlogPost post = new BlogPost();
		String key = model.get("keyword");
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
		return null;
	}

	private void getPostById(Map<String, String> model) {
		// TODO Auto-generated method stub
		
		Integer id = Integer.valueOf(model.get("id"));
		BlogPost post = dao.findPostById(id);
		
		model.put("data view", post.toString());
		
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void getPostAll(Map<String, String> model) {
		// TODO Auto-generated method stub
		List<BlogPost> list = dao.findPostAll();
		model.put("data all list", list.toString());
		
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
	}

	private void registPost(Map<String, String> model) {
		// TODO Auto-generated method stub
		BlogPost post = new BlogPost();
		
		if(model.get("title") != null && model.get("article") != null) {
//			System.out.println(model.get("title") + model.get("article"));
			post.setTitle(model.get("title"));
			post.setArticle(model.get("article"));
			dao.save(post);
		}
		
		model.put("msg", new Object() {}.getClass().getEnclosingMethod().getName());
		
	}

	

}
