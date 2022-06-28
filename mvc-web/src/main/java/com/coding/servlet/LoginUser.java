package com.coding.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coding.entity.BlogUser;
import com.coding.services.BlogWebServices;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/login")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogWebServices userlogin;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
        super();
        // TODO Auto-generated constructor stub
        userlogin = new BlogWebServices();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/user/login.html").forward(request, response);
		System.out.println("show login user");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		/*
		 * login testing name and email
		 * chua kiem tra duoc xac nhan name va email co ton tai tren database hay khong?
		 * */
		System.out.println("Login doPost");
		
		BlogUser user = new BlogUser();
	
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		
		boolean isValue = userlogin.loginUser(user);
		
		if (isValue) {
			System.out.println("Login");
		}else {
			System.out.println("Fail");
		}
	
		
	}

}
