package com.coding.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import java.time.LocalDateTime;

@WebServlet("/template")
public class ThymleafTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThymleafTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Class.forName("org.thymleaf.~~");
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        // default path : /src/main/resources/templates/~~~.html
        // layout : page design
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        
        // payload : data
        Context context = new Context();
        context.setVariable("name", null);
        context.setVariable("date", LocalDateTime.now());

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        String html = templateEngine.process("test", context);// rendering
        // default path : /src/main/resources/templates/test.html
        
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().append(html);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
