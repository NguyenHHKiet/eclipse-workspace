package com.coding.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.entity.BlogUser;
import com.coding.services.BlogWebServices;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/add")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BlogWebServices adduser;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
        adduser = new BlogWebServices();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("WEB-INF/user/add.html").forward(request, response);
		System.out.println("show add user");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		/*
		 * create user from create form add data into database
		 * chua kiem tra duoc name va email bi trung nhau
		 * */
		response.setContentType("text/html;charset=UTF-8");
		BlogUser user = new BlogUser();
		
		System.out.println("create add user");
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		
		adduser.addUser(user);
	}

}
