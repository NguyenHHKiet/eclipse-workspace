package com.hk.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.company.hibernate.HibernateUtils;
import com.hk.pojo.Product;




public class ProductService {
	private static final int SIZE = 3;

	public List<Product> getProducts(Map<String, String> params,int page) {
		// TODO Auto-generated method stub
		try(Session session = HibernateUtils.getFactory().openSession()) {
			CriteriaBuilder b = (CriteriaBuilder) session.getCriteriaBuilder();
			CriteriaQuery<Product> q = b.createQuery(Product.class);
			Root<Product> root = q.from(Product.class);
			q.select(root);
			
			
			
			List<Predicate> predicates = new ArrayList<>();
			String kw = params.get("kw");
			if (kw != null && !kw.isEmpty()) {
				Predicate p = b.like(root.get("name").as(String.class), 
						String.format("%%%&%%", kw));
				predicates.add(p);
			}
			
			String fp = params.get("fromPrice");
			if (fp != null) {
				Predicate p = b.greaterThanOrEqualTo(root.get("price"), 
						new BigDecimal(fp));
				predicates.add(p);
			}
			
			String tp = params.get("toPrice");
			if (tp != null) {
				Predicate p = b.lessThanOrEqualTo(root.get("price"), 
						new BigDecimal(tp));
				predicates.add(p);
			}
			
			q.where(predicates.toArray(new Predicate[] {}));
			
			q.orderBy(b.desc(root.get("id")), b.desc(root.get("name")));
			
			Query query = (Query) session.createQuery(q.toString(), Product.class);
			
			if (page > 0) {
				int start = (page - 1) * SIZE;
				query.setFirstResult(start);
				query.setMaxResults(SIZE);
			}
			
			return query.getResultList();
			
		}
		
	}
}
