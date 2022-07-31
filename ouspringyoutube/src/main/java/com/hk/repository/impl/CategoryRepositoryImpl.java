package com.hk.repository.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hk.pojo.Category;
import com.hk.repository.CategoryRepository;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {

	@Autowired
    private LocalSessionFactoryBean sessionFactory;
	
	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Category");
        return q.getResultList();
	}

}
