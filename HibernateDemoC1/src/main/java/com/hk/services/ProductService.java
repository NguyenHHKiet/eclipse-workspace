package com.hk.services;

import java.util.List;

import org.hibernate.Session;

import com.company.hibernate.HibernateUtils;
import com.hk.pojo.Product;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;


public class ProductService {

	public List<Product> getProducts(String kw,int page) {
		// TODO Auto-generated method stub
		try(Session session = HibernateUtils.getFactory().openSession()) {
			CriteriaBuilder b = session.getCriteriaBuilder();
			CriteriaQuery<Product> q = b.createQuery(Product.class);
			Root<Product> root = q.from(Product.class);
			q.select(root);
			
			Query query = session.createQuery(q);
			return query.getResultList();
			
		}
	}
}
