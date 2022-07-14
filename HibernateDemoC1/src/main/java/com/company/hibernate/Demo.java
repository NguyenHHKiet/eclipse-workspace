package com.company.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hk.pojo.Product;
import com.hk.services.ProductService;


public class Demo {

	public static void main(String[] args) {
		try(Session s = HibernateUtils.getFactory().openSession()) {
			Query q = (Query) s.createNamedQuery("Product.findAll", Product.class);
			List<Product> products = q.getResultList();
			products.forEach(p -> 
				System.out.printf("%d - %s - %.1f\n", 
				p.getId(), p.getName(), p.getPrice()));
		}
		
//		ProductService s = new ProductService();
//		
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("kw", "iPhone");
//		params.put("fromPrice", "1700000");
//		
//		s.getProducts(params, 2).forEach(p -> 
//		System.out.println("%d - %s - %.1f\n", 
//				p.getId(), p.getName(), p.getPrice()));
	}
}
