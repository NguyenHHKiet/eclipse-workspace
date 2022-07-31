package com.hk.configs;

import java.util.Properties;

import javax.ejb.TransactionManagement;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.google.common.base.Preconditions;

import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;

/**
 * @author Admin
 *
 */
@Configuration
@PropertySource("classpath:databases.properties")
public class HibernateConfig {

	@Autowired
	private Environment env;

	public HibernateConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setPackagesToScan(new String[] { "com.hk.pojo" });
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("hibernate.connection.driverClass")));
		dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("hibernate.connection.url")));
		dataSource.setUsername(Preconditions.checkNotNull(env.getProperty("hibernate.connection.username")));
		dataSource.setPassword(Preconditions.checkNotNull(env.getProperty("hibernate.connection.password")));
		return dataSource;
	}

	private Properties hibernateProperties() {
		Properties props = new Properties();
		props.put(DIALECT, env.getProperty("hibernate.dialect"));
		props.put(SHOW_SQL, env.getProperty("hibernate.showSql"));
		return props;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}


}