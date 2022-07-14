package com.company.hibernate;

import java.util.Locale.Category;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.hk.pojo.Product;

public class HibernateUtils {

	private static final SessionFactory factory;
	
	static {
		Configuration config = new Configuration();
		Properties props = new Properties();
		props.setProperty(Environment.DIALECT, "org.hibernate.dialect.MYSQLDialect");
		props.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		props.setProperty(Environment.URL, "jdbc:mysql://localhost/saledb");
		props.setProperty(Environment.USER, "root");
		props.setProperty(Environment.PASS, "");
		props.setProperty(Environment.SHOW_SQL, "true");
		config.setProperties(props);
		
		config.addAnnotatedClass(Category.class);
		config.addAnnotatedClass(Product.class);
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		
		factory = config.buildSessionFactory(registry);
	}

	public static SessionFactory getFactory() {
		// TODO Auto-generated method stub
		return factory;
	}
}
