package com.company.hibernate;

import com.hk.services.ProductService;

public class Demo {

	public static void main(String[] args) {
		ProductService s = new ProductService();
		s.getProducts(null, 0).forEach(p -> System.out.println("%d - %s - %.1f\n", p.g));
	}
}
