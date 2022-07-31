package com.hk.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.pojo.Product;
import com.hk.repository.ProductRepository;
import com.hk.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductRepository productRepository;
	
	@Override
	public List<Product> getProducts(Map<String, String> params, int page) {
		// TODO Auto-generated method stub
		return this.productRepository.getProducts(params, page);
	}

	@Override
	public int countProduct() {
		// TODO Auto-generated method stub
		return this.productRepository.countProduct();
	}

	@Override
	public boolean addProduct(Product p) {
		// TODO Auto-generated method stub
		// xu ly update
        p.setImage("https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248652/dkeolz3ghc0eino87iec.jpg");
        
        return this.productRepository.addProduct(p);
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return this.productRepository.deleteProduct(id);
	}

}
