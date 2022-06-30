package com.coding.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import com.coding.entity.BlogUser;
import com.coding.services.BlogWebServices;

/**
 * Servlet implementation class ViewUser
 */
@WebServlet("/view")
public class ViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogWebServices userdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUser() {
        super();
        // TODO Auto-generated constructor stub
        userdao = new BlogWebServices();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setContentType("text/html;charset=UTF-8");
		
		List<BlogUser> user = userdao.viewUser();
		
//		request.setAttribute("person", user);
		
//		ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
//		resolver.setTemplateMode(TemplateMode.HTML);
//		resolver.setCharacterEncoding("UTF-8");
//		resolver.setPrefix("WEB-INF/user/");
//		resolver.setSuffix(".html");
		
		Context context = new Context();
		System.out.println("User == " + user.get(0).getName());
		context.setVariable("persons", user);
		
		
//		TemplateEngine temp = new TemplateEngine();
//		temp.setTemplateResolver(resolver);
//		
//		String html = temp.process("view", context);
//		response.getWriter().append(html);

		request.getRequestDispatcher("WEB-INF/user/view.html").forward(request, response);
		request.setAttribute("persons", user);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
