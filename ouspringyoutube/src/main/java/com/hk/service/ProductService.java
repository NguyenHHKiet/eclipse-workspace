package com.hk.service;

import java.util.List;
import java.util.Map;

import com.hk.pojo.Product;

public interface ProductService {
	List<Product> getProducts(Map<String, String> params, int page);
    int countProduct();
    boolean addProduct(Product p);
    boolean deleteProduct(int id);
}
