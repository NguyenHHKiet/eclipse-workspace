package com.hk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.pojo.Product;
import com.hk.service.ProductService;

@RestController
@RequestMapping("/api")
public class ApiProductController {
	@Autowired
    private ProductService productService;
    
    @GetMapping("/products")
    public ResponseEntity<List<Product>> list() {
        return new ResponseEntity<>(this.productService.getProducts(null, 0), HttpStatus.OK);
    }
}
