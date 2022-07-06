package com.theplayer.kits;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class Main {

	public static void main(String[] args) {
		System.out.println("Main:main");
		run("find.xml");
	}
	private static void run(String configLocation) {
		//1) classpath 에 위치한 경우
//		ApplicationContext genericContext = new GenericXmlApplicationContext(configLocation);
//		Object bean = genericContext.getBean("");
//		System.out.println(bean);
		
//		ApplicationContext classContext = new ClassPathXmlApplicationContext(configLocation);
//		//String[] locs = new String[]{"config/applicaitonContext.xml","config/app.xml"};
//		//ApplicationContext classContextArr = new ClassPathXmlApplicationContext(locs);
//
//		//2) WebApplicationContext 생성 web.xml 파일 내부에 설정을 통해 생성하여 사용한다.
//		WebApplicationContext webContext = new XmlWebApplicationContext();
//		((XmlWebApplicationContext)webContext).setConfigLocation(configLocation);
//		Object bean = webContext.getBean("tvan");
//		System.out.println(bean);
//
//		Arrays.stream(
//		((XmlWebApplicationContext)webContext).getConfigLocations())
//		.forEach(s-> System.out.println(s)
//		);
//
//		// 3) ServletContext 가 필요
//		WebApplicationContext webappContext =
//		WebApplicationContextUtils.getWebApplicationContext(null/*getServletContext()*/);
//		//java.lang.IllegalArgumentException: ServletContext must not be null
//
	}

}
