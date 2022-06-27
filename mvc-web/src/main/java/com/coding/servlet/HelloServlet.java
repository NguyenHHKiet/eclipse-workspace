package com.coding.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.coding.dao.BlogUserDao;
import com.coding.entity.BlogUser;

@WebServlet("/home")
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(req.getServletPath());
		//user connection pool in container
		BlogUserDao usersdao = new BlogUserDao();
		BlogUser user = usersdao.findById(1);
		
		if (user == null) {
			user = new BlogUser(0, "", "");
		}
		
		req.setAttribute("user", usersdao);
		
		req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	//service() -> doGet, doPost
	
	
}
