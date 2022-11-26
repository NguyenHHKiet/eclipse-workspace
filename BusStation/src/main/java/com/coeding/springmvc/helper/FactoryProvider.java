package com.coeding.springmvc.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FactoryProvider {

	private static SessionFactory factory;
	
	private static SessionFactory getFactory() {
		// TODO Auto-generated method stub
		try {
			if (factory == null) {
				factory = new Configuration().configure("hibernate.cfg.xml")
						.buildSessionFactory();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return factory;
	}
}
