package com.coding.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding.controller.Controller;
import com.coding.controller.HomeController;
import com.coding.utils.TemplateFactory;


/*
 * take all request -> response
 * 	request, response ?
 * 
 * 	how many controller ?
 * 		scan ~ ~
 * 
 * DispatcherServlet + MVC pattern => Web MVC
 * 
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dispatcher");
		System.out.println(request.getMethod());
		System.out.println(request.getRequestURL());	
		System.out.println(request.getRequestURI());
		System.out.println(request.getContextPath());
		System.out.println(request.getServletPath());
		// preparing request info
		String servletPath = request.getServletPath();
		Enumeration<String> emu = request.getParameterNames();
		Map<String, Object> model = new HashMap<String, Object>();
		while( emu.hasMoreElements() ) {
			String name = emu.nextElement();
			Object value = request.getParameter(name);
			model.put(name, value);
		}
		// process logic -controller - model (dao)
		Controller controller=null;
		if(servletPath.equals("/home")) controller = new HomeController();
		
		if(controller != null ) {
			String viewName;
			try {
				viewName = controller.execute(model);
				// view 
				String html = TemplateFactory.viewResolve(viewName, model);
				response.getWriter().append(html);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			response.sendRedirect(request.getContextPath());
//			String html = TemplateFactory.viewResolve("fanadesh/index", null);
//			response.getWriter().append(html);
		}

	}

}
