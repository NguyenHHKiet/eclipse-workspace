package com.hk.services;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.company.hibernate.HibernateUtils;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;


public class ProductService {

	private List<Product> getProducts(String kw,int page) {
		// TODO Auto-generated method stub
		try(Session session = HibernateUtils.getFactory().openSession()) {
			CriteriaBuilder b = session.getCriteriaBuilder();
			CriteriaQuery<Product> q = b.createQuery(Product.class);
			Root root = q.from(Product.class);
			q.select(root);
			
			Query query = session.createQuery(q);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
