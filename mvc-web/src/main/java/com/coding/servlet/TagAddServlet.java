package com.coding.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.entity.BlogTag;
import com.coding.services.BlogWebServices;


@WebServlet(urlPatterns = {"/tag/add"})
public class TagAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BlogWebServices service;
	
    public TagAddServlet() {
        super();
        // TODO Auto-generated constructor stub
        service = new BlogWebServices();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// send to form
		request
		.getRequestDispatcher("/WEB-INF/views/tag/add.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BlogTag tag = new BlogTag();
		tag.setPostId(Integer.parseInt(request.getParameter("postid")));
		tag.setTag(request.getParameter("tag"));
		service.addTag(tag);
		response.sendRedirect("/tutorial/tag/list");
	}

}
