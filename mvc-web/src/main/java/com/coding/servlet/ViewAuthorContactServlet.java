package com.coding.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.services.BlogWebServices;


@WebServlet("/user/auditor/viewAuthorContact")
public class ViewAuthorContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogWebServices service;
       
    public ViewAuthorContactServlet() {
        super();
        service = new BlogWebServices();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("id");
		int id = Integer.parseInt(value);
		request.setAttribute("contact", service.getBlogAuthor(id));
		request.getRequestDispatcher("/WEB-INF/views/user/auditor/ViewAuthorContactDetail.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
