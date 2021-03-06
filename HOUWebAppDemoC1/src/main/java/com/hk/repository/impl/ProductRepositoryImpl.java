package com.hk.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hk.pojo.Product;
import com.hk.repository.ProductRepository;

@Repository
@PropertySource("classpath:database.properties")
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private LocalSessionFactoryBean sessionFactory;
	@Autowired
	private Environment env;

	@Override
	public List<Product> getProducts(Map<String, String> params, int page) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getObject().getCurrentSession();
		CriteriaBuilder b = (CriteriaBuilder) session.getCriteriaBuilder();
		CriteriaQuery<Product> q = b.createQuery(Product.class);
		Root root = q.from(Product.class);
		q.select(root);

		List<Predicate> predicates = new ArrayList<>();
		String kw = params.get("kw");
		if (kw != null && !kw.isEmpty()) {
			Predicate p = b.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
			predicates.add(p);
		}

		String fp = params.get("fromPrice");
		if (fp != null) {
			Predicate p = b.greaterThanOrEqualTo(root.get("price").as(Long.class), Long.parseLong(fp));
			predicates.add(p);
		}

		String tp = params.get("toPrice");
		if (tp != null) {
			Predicate p = b.lessThanOrEqualTo(root.get("price").as(Long.class), Long.parseLong(tp));
			predicates.add(p);
		}

		String cateId = params.get("cateId");
		if (cateId != null) {
			Predicate p = b.equal(root.get("categoryId"), Integer.parseInt(cateId));
			predicates.add(p);
		}

		q.where(predicates.toArray(new Predicate[] {}));

		q.orderBy(b.desc(root.get("id")), b.desc(root.get("name")));

		Query query = session.createQuery(q.toString(), Product.class);

		if (page > 0) {
			int size = Integer.parseInt(env.getProperty("page.size").toString());
			int start = (page - 1) * size;
			query.setFirstResult(start);
			query.setMaxResults(size);
		}

		return query.getResultList();
	}

}
