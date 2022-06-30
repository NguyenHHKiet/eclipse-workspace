package com.coding.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.entity.BlogPost;
import com.coding.services.PostService;
import com.coding.utils.TemplateFactory;


@WebServlet("/post/*")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PostService service;
    public PostServlet() {
        super();
        service = new PostService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		String urlPath = request.getRequestURL().toString();
		String uriPath = request.getRequestURI();
		String method = request.getMethod();
		System.out.println(servletPath + "\n" + urlPath + "\n" + uriPath + "\n" + method);
		int i = uriPath.lastIndexOf(servletPath);
		System.out.println(i);
		String subpath = uriPath.substring(i+(servletPath.length()));
		System.out.println(subpath);
		
		String html = "";
		if(subpath.length()<2) {
			List<BlogPost> list = service.getPosts();
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("posts", list);
			html = TemplateFactory.viewResolve("post/list", model);
		}else {
			if(subpath.equals("/add")) {
				if(method.equals("GET")) {
					html = TemplateFactory.viewResolve("post/add", null);					
				}else if(method.equals("POST")) {
					Map<String, Object> model = new HashMap<String, Object>();
					model.put("title", request.getParameter("title"));
					model.put("article", request.getParameter("article"));
					model.put("author_id", request.getParameter("author_id"));
					service.addPost(model);
					response.sendRedirect("/tutorial/post");					
				}
			}else if(subpath.equals("/view")) {
				
			}else if(subpath.equals("/edit")) {
				if(method.equals("GET")) {
					
				}else if(method.equals("POST")) {
					
				}
			}
			
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.getWriter().append(html);
	}

}
