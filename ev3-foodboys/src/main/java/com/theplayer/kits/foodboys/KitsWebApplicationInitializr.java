package com.theplayer.kits.foodboys;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * 주의!! ApplicationContext 와 DispatcherServlet 호출 전에 실행됨
 * 
 * @author bitcamp
 *
 */
//author: Thinh
public class KitsWebApplicationInitializr implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		Enumeration<String> names = servletContext.getInitParameterNames();
//		servletContext.getInitParameter("uploadPath");
		String uploadPath = servletContext.getRealPath(
				servletContext.getInitParameter("uploadPath")
		);
		System.out.println(uploadPath);
		ServletContextParam env = new ServletContextParam(uploadPath);
//		HashMap<String, String> map = new HashMap<String, String>();
//		while(names.hasMoreElements()) {
//			String name = names.nextElement();
//			String value = servletContext.getRealPath(servletContext.getInitParameter(name));
//			map.put(name, value);
//		}
//		ServletContextParam env = new ServletContextParam(map);
	}

	public void deprecated_onStartup(ServletContext servletContext) throws ServletException {
//		System.out.println("KitsWebApplicationInitializr:onStartup");
//		System.out.println("AppContext : "+context);
//		// TODO: read parameter in Servlet Context by web.xml
//		String configLocation = servletContext.getInitParameter("contextConfigLocation");
//		System.out.println(configLocation);
//		String configLocationRealPath = servletContext.getRealPath(configLocation);
//		System.out.println(configLocationRealPath);
//
//		// TODO: configuration xml file
//		try {
//			System.out.println("ClassPath---");
//			ApplicationContext genericContext = new GenericXmlApplicationContext(configLocation);
//			XmlWebApplicationContext genericXmlContext = (XmlWebApplicationContext)genericContext;
//			Arrays.stream(genericXmlContext.getConfigLocations()).forEach(s->System.out.println(s));
//			
//			ApplicationContext classContext = new ClassPathXmlApplicationContext(configLocation);
//			XmlWebApplicationContext classXmlContext = (XmlWebApplicationContext)classContext;
//			Arrays.stream(classXmlContext.getConfigLocations()).forEach(s->System.out.println(s));
//
//			//String[] locs = new String[]{"config/applicaitonContext.xml","config/app.xml"};
//			//ApplicationContext classContextArr = new ClassPathXmlApplicationContext(locs);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			System.out.println("WebPath---");
//			WebApplicationContext webContext = new XmlWebApplicationContext();
//			XmlWebApplicationContext webXmlContext = (XmlWebApplicationContext)webContext;
//			Arrays.stream(webXmlContext.getConfigLocations()).forEach(s->System.out.println(s));
//	
//			WebApplicationContext webappContext = 
//					WebApplicationContextUtils.getWebApplicationContext(servletContext);
//			XmlWebApplicationContext webappXmlContext = 
//					(XmlWebApplicationContext)webappContext;
//			
//			Arrays.stream(webappXmlContext.getConfigLocations()).forEach(s->System.out.println(s));
//			Arrays.stream(webappXmlContext.getBeanDefinitionNames()).forEach(s->System.out.println(s));
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		
	}


}
