package com.hk.services;

import java.util.List;
import java.util.Map;

import com.hk.pojo.Product;

public interface ProductService {

	List<Product> getProducts(Map<String, String> params, int page);
}
