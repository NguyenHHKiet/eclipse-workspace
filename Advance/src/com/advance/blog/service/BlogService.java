package com.advance.blog.service;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

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

	public Map<String, String> process(String cmd) {
		// TODO Auto-generated method stub
		Map<String, String> model = new HashMap<String, String>();
		
		
		if(!cmd.contains("?")) {
			System.out.println("not contians");//only command
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
				String command = req[0];
				String parameter = req[1];
				
				// string -> map<string, string>
				StringTokenizer tokenizer = new StringTokenizer(parameter, "&");
				while(tokenizer.hasMoreTokens()) {
					tokenizer.nextToken("=");
				}
				
				
				
			}else {
			// model include req, resp
			registPost(model);
			getPostAll(model);
			getPostById(model);
			getPostWithCategory(model);
			getPostByString(model);
			updatePost(model);
			deletePost(model);
			
			registCategory(model);
			getCategoryAll(model);
			getCategoryById(model);
			getCategoryWithCategory(model);
			getCategoryByString(model);
			updateCategory(model);
			deleteCategory(model);
			}
		}
		
		
		return model;
	}


	private void deleteCategory(Map<String, String> model) {
		// TODO Auto-generated method stub
		
	}

	private void updateCategory(Map<String, String> model) {
		// TODO Auto-generated method stub
		
	}

	private void getCategoryByString(Map<String, String> model) {
		// TODO Auto-generated method stub
		
	}

	private void getCategoryWithCategory(Map<String, String> model) {
		// TODO Auto-generated method stub
		
	}

	private void getCategoryById(Map<String, String> model) {
		// TODO Auto-generated method stub
		
	}

	private void getCategoryAll(Map<String, String> model) {
		// TODO Auto-generated method stub
		
	}

	private void registCategory(Map<String, String> model) {
		// TODO Auto-generated method stub
		
	}

	private void deletePost(Map<String, String> model) {
		// TODO Auto-generated method stub
		
	}

	private void updatePost(Map<String, String> model) {
		// TODO Auto-generated method stub
		
	}

	private void getPostByString(Map<String, String> model) {
		// TODO Auto-generated method stub
		
	}

	private void getPostWithCategory(Map<String, String> model) {
		// TODO Auto-generated method stub
		
	}

	private void getPostById(Map<String, String> model) {
		// TODO Auto-generated method stub
		
	}

	private void getPostAll(Map<String, String> model) {
		// TODO Auto-generated method stub
		
	}

	private void registPost(Map<String, String> model) {
		// TODO Auto-generated method stub
		
	}

	

}
