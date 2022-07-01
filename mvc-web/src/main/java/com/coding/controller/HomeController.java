package com.coding.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.dto.Menu;
import com.coding.entity.BlogPost;
import com.coding.services.BlogWebServices;
import com.coding.utils.TemplateFactory;


//@WebServlet("/home")
public class HomeController implements Controller {
	private static final long serialVersionUID = 1L;
	private BlogWebServices service;
    public HomeController() {
        super();
        this.service = new BlogWebServices();
    }
    @Deprecated
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		response.setContentType("text/html; charset=utf-8");
		BlogPost post = service.getRecentPost();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("post", post);
		String html = TemplateFactory.viewResolve("fanadesh/index", model);
		request.setAttribute("content", html);
		response.getWriter().append(html);
		
	}
    @Deprecated
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Deprecated
	private List<Menu> makeMenus(){
		List<Menu> menus = new ArrayList<Menu>();
		menus.add(new Menu("Home","/home"));
		menus.add(new Menu("UserAuditor","/user/auditor/viewAuthorContact?id=1"));
		menus.add(new Menu("UserAuthor|createPost","/user/author/creatPost"));
		menus.add(new Menu("UserAuthor|editPost","/user/author/editPost"));
		menus.add(new Menu("UserAuthor|deletePost","/user/author/deletePost"));
		menus.add(new Menu("Manager|editUser","/user/manager/editUser"));
		menus.add(new Menu("User|create","/user/createUser"));
		menus.add(new Menu("User|find","/user/findUser"));
		menus.add(new Menu("User|update","/user/updateUser"));
		menus.add(new Menu("User|viewAll","/user/viewAllUser"));
		menus.add(new Menu("User|detail","/user/viewUserDetail"));
		menus.add(new Menu("User|editComment","/user/editComment"));
		menus.add(new Menu("User|postComment","/user/postComment"));
		menus.add(new Menu("Blog|viewAll","/blog/viewAllPost"));
		menus.add(new Menu("Blog|detail","/blog/viewPostDetail"));
		menus.add(new Menu("Blog|find","/blog/findPost"));
		menus.add(new Menu("Manager|createPost","/user/manager/createPost"));
		menus.add(new Menu("Manager|editPost","/user/manager/editPost"));
		menus.add(new Menu("Manger|deletePost","/user/manager/deletePost"));
		return menus;
		
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		BlogPost post = service.getRecentPost();
		String author_name = service.getAuthorName( post.getAuthorId() );
		String[] tags = service.getTagsBy( post.getId());
		model.put("post", post);
		model.put("authorname", author_name);
		model.put("tags", tags);
		return ("fanadesh/index");
	}

}
