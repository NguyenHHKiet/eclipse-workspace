package com.hk.repository;

import java.util.List;
import java.util.Map;

import com.hk.pojo.Product;

/**
 * @author Admin
 *
 */
public interface ProductRepository {
	List<Product> getProducts(Map<String, String> params, int page);
}
